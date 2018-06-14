package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderitemDaoImpl {

	private SqlSessionFactory sqlSessionFactory;
	public OrderitemDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	public boolean insertOrderitem(Orderitem orderitem){
		SqlSession session = sqlSessionFactory.openSession();
		User o = session.selectOne("insertOrderitem", orderitem);
		session.commit();
		session.close();
		return true;
	}
	
	public List<Orderitem> selectOrderitemById(int orderId){
		SqlSession session = sqlSessionFactory.openSession();
		List<Orderitem> lk = session.selectList("selectOrderitemById", orderId);
		// �� ��selectUserByName���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}
	
	public int deleteOrderitem(int orderitemId){
		SqlSession session = sqlSessionFactory.openSession();
		int o = session.delete("deleteOrderitem", orderitemId);
		session.commit();
		session.close();
		return o;
	}
	
	public List<Orderitem> findupdate(int orderId){
		SqlSession session = sqlSessionFactory.openSession();
		List<Orderitem> lk = session.selectList("findupdate", orderId);
		// �� ��selectUserByName���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}
	
	public int updatedetail(Orderitem orderitem){
		SqlSession session = sqlSessionFactory.openSession();
		int o = session.update("updatedetail", orderitem);
		session.commit();
		session.close();
		return o;
	}
	
	
}
