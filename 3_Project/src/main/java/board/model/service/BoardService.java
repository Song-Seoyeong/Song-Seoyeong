package board.model.service;

import static common.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.PageInfo;

public class BoardService {
	BoardDAO bDAO = new BoardDAO();

	public int getListCount() {
		
		SqlSession session = getSqlSession();
		int listCount = bDAO.getListCount(session);
		
		return listCount;
	}

	public ArrayList<Board> selectBoardList(PageInfo pi) {
		SqlSession session = getSqlSession();
		ArrayList<Board> list = bDAO.selectBoardList(session, pi);
		return list;
	}

}
