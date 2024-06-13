package board.model.service;

import static common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDAO;

public class BoardService {

	public int getListCount() {
		
		BoardDAO bDAO = new BoardDAO();
		
		SqlSession session = getSqlSession();
		int listCount = bDAO.getListCount(session);
		
		return listCount;
	}

}
