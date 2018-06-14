package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	public List<Order> selectOrderById(int orderId){
		SqlSession session = sqlSessionFactory.openSession();
		List<Order> lk = session.selectList("selectOrderById", orderId);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
	public int deleteOrder(int orderId){
		SqlSession session = sqlSessionFactory.openSession();
		int o = session.delete("deleteOrder", orderId);
		session.commit();
		session.close();
		return o;
	}
	
	public int updateOrder(Order order){
		SqlSession session = sqlSessionFactory.openSession();
		int o = session.update("updateOrder", order);
		session.commit();
		session.close();
		return o;
	}
	
	public List<Order> findOrder(int orderId){
		SqlSession session = sqlSessionFactory.openSession();
		List<Order> lk = session.selectList("findOrder", orderId);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
}
