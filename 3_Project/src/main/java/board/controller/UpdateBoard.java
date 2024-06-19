package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import employee.model.vo.Employee;

/**
 * Servlet implementation class UpdateBoard
 */
@WebServlet("/updateBoard.bo")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardService service = new BoardService();
		
		String title = request.getParameter("title");
		String isNotice = request.getParameter("isNotice");
		int bNo = Integer.parseInt(request.getParameter("bId"));
		String content = request.getParameter("content");
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		Board b = new Board(bNo, title, content, e.getEmpNo(), null, 0, null, null, isNotice, null);
		
		int result = service.updateBoard(b);
		if(result > 0 ) {
			request.getRequestDispatcher("/list.bo").forward(request, response);
		}else {
			request.setAttribute("msg", "글 수정 중 에러 발생");
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
