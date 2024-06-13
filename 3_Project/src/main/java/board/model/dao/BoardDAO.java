package board.model.dao;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {

	public int getListCount(SqlSession session) {
		int listCount = session.selectOne("boardMapper.getListCount");
		return listCount;
	}

}
