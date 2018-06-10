package model;

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
	
	
	
	
}
