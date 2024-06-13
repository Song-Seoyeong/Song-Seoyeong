package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import common.Pagination;

/**
 * Servlet implementation class SelectBoardListServlet
 */
@WebServlet("/list.bo")
public class SelectBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		
		
		//현재 페이지
		int currentPage = 1; // 아무값도 안들어올때는 1페이지 유지
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));  // 값이 들어오면 들어온 값으로 현재 페이지 넘버를 변경함
		}
		
		// 전체 게시글 수 (이게 있어야 한페이지에 몇개인지 설정해두고 페이지의 개수를 나타낼 수 있음)
		int listCount = service.getListCount();
		System.out.println(listCount);
		
		// 페이징 계산 : 게시글, 검색, 댓글 등 페이징 처리가 들어가는 곳이 많기때문에 따로 코드를 빼서 사용함
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = service.selectBoardList(pi);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("WEB-INF/views/board/boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
