package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		//JDBC 에서의 Connection 만든 것과 동일하다
		
		SqlSession session = null;
		try {
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			InputStream stream = Resources.getResourceAsStream("/Mybatis-config.xml"); // Mybatis-config.xml 파일 생성하기
			SqlSessionFactory ssf = ssfb.build(stream);
			session = ssf.openSession();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
		
}
