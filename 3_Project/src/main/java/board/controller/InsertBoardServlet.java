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
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insertBoard.bo")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardService service = new BoardService();
		Employee loginUser = (Employee)request.getSession().getAttribute("loginUser");
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");
		String isNotice = (String)request.getParameter("isNotice");
		
		Board b = new Board(0, title, content, loginUser.getEmpNo(), loginUser.getEmpName(), 0, null, null, isNotice, isNotice);
		int result = service.insertBoard(b);
		if(result > 0) {
			b = service.selectBoard(b.getBoardNo(), loginUser.getEmpNo());
			System.out.println(b);
			request.setAttribute("b", b);
			request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "글작성 중 오류발생");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jap");
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
