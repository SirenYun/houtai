package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl {
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	//���������û�
	public List<User> getAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("selectAllUser");
		// �� ��selectAllUser���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}
	
	//�����û�������������û�
	public User findUser(String userName, String password){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		//ͨ��SqlSession�������ݿ�
		//��һ����������statement��ӳ���ļ�statement��id������=namespace+"."+statement��id
		//�ڶ�����������parameter��ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		//session.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���
		User u = session.selectOne("selectUser", user);
		//�ͷ���Դ
		session.commit();
		session.close();
		return u;
	}
	
	//����һ���û�����
	public boolean insertUser(User user){
		SqlSession session = sqlSessionFactory.openSession();
		User u = session.selectOne("insertUser", user);
		session.commit();
		session.close();
		return true;
	}
	
	//ͨ���û���ģ���Ӳ�ѯ�û�
	public List<User> selectUserByName(String userName){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("selectUserByName", userName);
		// �� ��selectUserByName���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}

	public int deleteUser(int userId){
		SqlSession session = sqlSessionFactory.openSession();
		int u = session.delete("deleteUser", userId);
		session.commit();
		session.close();
		return u;
	}
	
	public int updateUser(User user){
		SqlSession session = sqlSessionFactory.openSession();
		int u = session.update("updateUser", user);
		session.commit();
		session.close();
		return u;
	}
	
	public List<User> selectUserById(int userId){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("selectUserById", userId);
		// �� ��selectUserByName���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}

	public List<User> userorder(int userId){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("userorder", userId);
		// �� ��selectUserByName���������ļ��е�һ��id��ƥ�䡣
		session.commit();
		session.close();
		return lk;
	}
	
}
