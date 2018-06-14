package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl {
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	//查找所有用户
	public List<User> getAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("selectAllUser");
		// 该 “selectAllUser”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
	//根据用户名和密码查找用户
	public User findUser(String userName, String password){
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		//通过SqlSession操作数据库
		//第一个参数：（statement）映射文件statement的id，等于=namespace+"."+statement的id
		//第二个参数：（parameter）指定和映射文件中所匹配的parameterType类型的参数
		//session.selectOne结果是与映射文件中所匹配的resultType类型的对象
		User u = session.selectOne("selectUser", user);
		//释放资源
		session.commit();
		session.close();
		return u;
	}
	
	//插入一个用户对象
	public boolean insertUser(User user){
		SqlSession session = sqlSessionFactory.openSession();
		User u = session.selectOne("insertUser", user);
		session.commit();
		session.close();
		return true;
	}
	
	//通过用户名模糊从查询用户
	public List<User> selectUserByName(String userName){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("selectUserByName", userName);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
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
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}

	public List<User> userorder(int userId){
		SqlSession session = sqlSessionFactory.openSession();
		List<User> lk = session.selectList("userorder", userId);
		// 该 “selectUserByName”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}
	
}
