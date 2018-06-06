package DaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.Ticket;
import model.DbUtils;
import model.User;

public class TicketDaoImpl {
	private SqlSessionFactory sqlSessionFactory;
	public TicketDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	//模糊从查询车票
	public List<Ticket> serachTickets(String ti){
		SqlSession session = sqlSessionFactory.openSession();
		List<Ticket> lk = session.selectList("serachTickets", ti);
		
		session.commit();
		session.close();
		return lk;
	}


}
