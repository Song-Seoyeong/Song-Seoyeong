package employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class InsertEmployeeServlet
 */
@WebServlet("/insertEmp.me")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int empNo = Integer.parseInt(request.getParameter("id"));
		String empName = request.getParameter("name");
		String job = request.getParameter("job");
		Integer mgrNo = request.getParameter("mgr").indexOf("-") == 0
							? null : Integer.parseInt(request.getParameter("mgr"));
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int deptNo = Integer.parseInt(request.getParameter("dept"));
		String isAdmin = request.getParameter("isAdmin") == null ? "N" : request.getParameter("isAdmin");
		// isAdmin 은 체크를 안할 경우 null 반환 >> 이유 : 체크박스는 체크를 안하면 아예 값을 안보내게 되고
		// 그 상태에서 getParameter을 하게 되니 없는 값이므로 String의 기본값 null이 담기게 된다
		
		Employee e = new Employee(empNo, null, empName, job, mgrNo, null, null, sal, comm, deptNo, null, isAdmin, null);
		int result = new EmployeeService().insertEmployee(e);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/admin.me?afterEnroll=Y");
		}else {
			request.setAttribute("msg", "사원 등록에 실패 했습니다");
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
