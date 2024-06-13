package employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginViewServlet
 */
@WebServlet("/loginView.me") // 이전 버전에서 자동 생성
public class LoginViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기서는 로그인 화면만 보려고 하기때문에 데이터 전달 및 받을 필요가 없음
		/*
			화면 이동 1번째 방식 :RequestDispatcher.forward()
				request, response 유지 >> 데이터 전달 가능(데이터 삭제 안됨)
				url 유지
		
			화면 이동 2번째 방식 : HttpServletResponse.sendRedirect()
				request, response 유지x, 새로 객체 생성 >> 데이터 전달 불가 
				url 변경(인자로 넣은 경로로 변경)
				
		*/
		// response.sendRedirect("WEB-INF/views/employee/login.jsp");
		// 이대로 하게 되면 view > view 간의 이동이 된다, 근데 우리는 WEB-INF에서 이동하기 때문에 사용할 수 없다
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/employee/login.jsp");
		view.forward(request, response);
		// 데이터 전달을 하지않더라도 상황에 따라 forward()를 쓰는 경우도 있다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// post 방식으로 들어오더라도 바로 doget을 호출하기때문에 신경쓰지않아도 된다
		doGet(request, response);
	}

}
