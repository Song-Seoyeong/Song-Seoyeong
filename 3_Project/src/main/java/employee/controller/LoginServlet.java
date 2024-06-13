package employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.model.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		
		Employee e = new Employee();
		e.setEmpNo(id);
		e.setPwd(pwd);
		
		EmployeeService eService = new EmployeeService();
		Employee loginUser = eService.login(e);
		
		if(loginUser != null) {
			// 로그인 유저 정보를 보내야하기때문에 forward() 사용
			// 로그인 후 계속 그 정보를 사용하기 때문에 session 영역에 담는다
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(600); //10분(초기준)
			response.sendRedirect(request.getContextPath());
			// 데이터를 session에 담아 전달하기때문에 sendRedirect()로 보내더라도 데이터가 유지된다
			
		}else {
			request.setAttribute("msg", "로그인을 실패했습니다."); // 에러가 날때마다 안내 문구를 다르게 사용
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
