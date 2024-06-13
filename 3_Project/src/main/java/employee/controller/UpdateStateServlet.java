package employee.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.EmployeeService;

/**
 * Servlet implementation class UpdateStateServlet
 */
@WebServlet("/updateState.me")
public class UpdateStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("empNo"));
		String col = request.getParameter("column").equals("관리자") ? "is_admin" : "status";
		String value = request.getParameter("value");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("column", col);
		map.put("value", value);
		
		// MyBatis인자로 보낼 수 있는 데이터의 개수는 0/1이다
		// 2개 이상의 데이터를 보낼 때는 vo 객체에 담아서 보내거나, 컬렉션/배열에 담아 보낸다
		
		
		int result = new EmployeeService().updateState(map);
		
		response.getWriter().print(result == 1? "success":"fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
