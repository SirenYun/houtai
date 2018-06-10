package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Order;
import model.OrderDaoImpl;
import model.Orderitem;
import model.OrderitemDaoImpl;

@Controller
public class OrderitemController {

	@RequestMapping("/insertOrderitem")
	public ModelAndView insertOrderitem(HttpServletRequest req) throws Exception{
		int orderId = Integer.valueOf(req.getParameter("orderId"));
		int productId = Integer.valueOf(req.getParameter("productId"));
		String productName = req.getParameter("productName");
		String size = req.getParameter("size");
		int count = Integer.valueOf(req.getParameter("count"));
		Float price = Float.parseFloat(req.getParameter("price"));
		Orderitem orderitem = new Orderitem();
		orderitem.setOrderId(orderId);
		orderitem.setProductId(productId);
		orderitem.setProductName(productName);
		orderitem.setSize(size);
		orderitem.setCount(count);
		orderitem.setPrice(price);
		OrderitemDaoImpl impl= new OrderitemDaoImpl();
		boolean i = impl.insertOrderitem(orderitem);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/addorderitemok");
		return mv;
	}
	
	
	
	
}
