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
		//�ͷ���Դ
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
		// �� ��selectUserByName���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}
	
	
}