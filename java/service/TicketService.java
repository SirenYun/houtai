package service;

import java.util.Iterator;
import java.util.List;

import domain.Ticket;

public interface TicketService {
	Iterator<Ticket> get(String ti);

}
