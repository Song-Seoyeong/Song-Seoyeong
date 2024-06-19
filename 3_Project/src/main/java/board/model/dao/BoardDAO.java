package board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.vo.Board;
import board.model.vo.PageInfo;

public class BoardDAO {

	public int getListCount(SqlSession session) {
		int listCount = session.selectOne("boardMapper.getListCount");
		return listCount;
	}
	
	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi){
		
		// 첫 번째 이자 int offset : 건너뛸 게시글 수
		// 두 번째 인자 int limit : 선택할 게시글 수
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage()-1)*pi.getBoardLimit(), pi.getBoardLimit());
		
		
		
		ArrayList<Board> list = (ArrayList)session.selectList("boardMapper.selectBoardList", null, rowBounds);
		
		return list;
	}

	public int getSearchListCount(SqlSession session, HashMap<String, String> map) {
		int listCount = session.selectOne("boardMapper.getSearchListCount", map);
		
		return listCount;
	}

	public ArrayList<Board> selectSList(SqlSession session, HashMap<String, String> map, PageInfo pi) {
		RowBounds rowBounds = new RowBounds((pi.getCurrentPage() - 1)*pi.getBoardLimit(), pi.getBoardLimit());
		
		return (ArrayList)session.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

	public Board selectBoard(SqlSession session, int bId) {
		return session.selectOne("boardMapper.selectBoard", bId);
	}

	public int updateCount(SqlSession session, int bId) {
		return session.update("boardMapper.updateCount", bId);
	}

	public int insertBoard(SqlSession session, Board b) {
		return session.insert("boardMapper.insertBoard", b);
	}

	public int updateBoard(SqlSession session, Board b) {
		return session.update("boardMapper.updateBoard", b);
	}

	public int deleteBoard(SqlSession session, int bId) {
		return session.update("boardMapper.deleteBoard", bId);
	}
	
}
