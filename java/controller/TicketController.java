package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DaoImpl.TicketDaoImpl;
import domain.Ticket;
import service.TicketService;

@Controller
public class TicketController {
		
		@Autowired
		private TicketService TicketService;
		
		@RequestMapping("/tickets")
		public ModelAndView tickets(HttpServletRequest req) {
			String ti = req.getParameter("ti");
			Iterator<Ticket> tickets = TicketService.get(ti);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/ticketList");
			mv.addObject("tickets",tickets);
			return mv;
		}
}
