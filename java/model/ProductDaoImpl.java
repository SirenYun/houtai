package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProductDaoImpl {

	private SqlSessionFactory sqlSessionFactory;
	public ProductDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	public boolean insertProduct(Product product){
		SqlSession session = sqlSessionFactory.openSession();
		Product p = session.selectOne("insertProduct", product);
		//释放资源
		session.commit();
		session.close();
		return true;
	}
	
	public List<Product> getAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Product> lk = session.selectList("selectAllProduct");
		session.commit();
		session.close();
		return lk;
	}
	
	public List<Product> selectProductByName(String productName){
		SqlSession session = sqlSessionFactory.openSession();
		List<Product> lk = session.selectList("selectProductByName", productName);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
	public int deleteProduct(int productId){
		SqlSession session = sqlSessionFactory.openSession();
		int u = session.delete("deleteProduct", productId);
		session.commit();
		session.close();
		return u;
	}
	
	public List<Product> selectProductById(int productId){
		SqlSession session = sqlSessionFactory.openSession();
		List<Product> lk = session.selectList("selectProductById", productId);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
	public int updateProduct(Product product){
		SqlSession session = sqlSessionFactory.openSession();
		int u = session.update("updateProduct", product);
		session.commit();
		session.close();
		return u;
	}
	
	public List<Product> productorder(int productId){
		SqlSession session = sqlSessionFactory.openSession();
		List<Product> lk = session.selectList("productorder", productId);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
}
