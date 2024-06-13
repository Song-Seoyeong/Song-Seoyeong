package employee.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import employee.model.vo.Employee;

public class EmployeeDAO {

	public Employee login(SqlSession session, Employee e) {
		
		/* 
		 * 첫번째 인자 :내 접근할 쿼리명
		 * 두번째 인자	: 쿼리에 전달할 데이터
		 */
		Employee loginUser = session.selectOne("employeeMapper.login", e);
		// 반환 타입이 타입이기때문에 따로 다운캐스팅을 하지않아도 된다
		System.out.println(loginUser);
		return loginUser;
	}
	
	public int updateEmployee(SqlSession session, Employee e) {
		int result = session.update("employeeMapper.updateEmployee", e);
		
		return result;
	}

	public ArrayList<Employee> selectAll(SqlSession session) {
		ArrayList<Employee> list = (ArrayList)session.selectList("employeeMapper.selectAll");
		return list;
	}

	public int insertEmployee(SqlSession session, Employee e) {
		int result = session.insert("employeeMapper.insertEmployee", e);
		return result;
	}

	public int checkEmpNo(SqlSession session, int inputId) {
		int result = session.selectOne("employeeMapper.checkEmpNo", inputId);
		return result;
	}
//
	public int updateState(SqlSession session, HashMap<String, Object> map) {
		//인자로 보낼 수 있는 데이터의 개수는 0/1이다
		// 2개 이상의 데이터를 보낼 때는 vo 객체에 담아서 보내거나, 컬렉션/배열에 담아 보낸다
		int result = session.update("employeeMapper.updateState", map);
		return result;
	}

}
