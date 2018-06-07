package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Order;
import model.OrderDaoImpl;
import model.User;
import model.UserDaoImpl;

@Controller
public class OrderController {

	@RequestMapping("/insertOrder")
	public ModelAndView insertOrder(HttpServletRequest req) throws Exception{
		String userName = req.getParameter("userName");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		String code = req.getParameter("code");
		String email = req.getParameter("email");
		Float price = Float.parseFloat(req.getParameter("price"));
		Order order = new Order();
		order.setUserName(userName);
		order.setTel(tel);
		order.setAddress(address);
		order.setCode(code);
		order.setEmail(email);
		order.setPrice(price);
		OrderDaoImpl impl= new OrderDaoImpl();
		boolean o = impl.insertOrder(order);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/addorderok");
		return mv;
	}
	
	@RequestMapping("/queryOrder")
	public ModelAndView queryUser() throws Exception{
		OrderDaoImpl impl= new OrderDaoImpl();
		List<Order> orderList = impl.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/allorder");
		mv.addObject("orderList",orderList);
		return mv;
	}
	
}
