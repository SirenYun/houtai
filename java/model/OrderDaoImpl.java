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
		// 该 “selectAllUser”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
	
	
	
	
}
