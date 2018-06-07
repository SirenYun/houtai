package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderDaoImpl {

	private SqlSessionFactory sqlSessionFactory;
	public OrderDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	public boolean insertOrder(Order order){
		SqlSession session = sqlSessionFactory.openSession();
		User o = session.selectOne("insertOrder", order);
		session.commit();
		session.close();
		return true;
	}
	
	public List<Order> getAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Order> lk = session.selectList("selectAllOrder");
		// �� ��selectAllUser���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}
	
	
	
	
	
}
