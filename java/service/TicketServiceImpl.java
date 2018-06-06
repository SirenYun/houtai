package service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import DaoImpl.TicketDaoImpl;
import domain.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	public TicketServiceImpl() {
		
		
	}
	public Iterator<Ticket> get(String ti){
		TicketDaoImpl Ticket= new TicketDaoImpl();
		
		List l = Ticket.serachTickets(ti);
		
		Iterator<Ticket> tickets = l.iterator();
		
		return tickets;
	}
}
