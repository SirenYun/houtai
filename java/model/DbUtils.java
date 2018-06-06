package model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtils {
	public static SqlSessionFactory getSession(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");// ��ȡconfig�ļ��� ע�ⷴб��
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory; //���sqlSessionFactory.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
