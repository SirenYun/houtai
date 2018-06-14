package controller;

import java.util.List;

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
		mv.setViewName("/addorderdetailok");
		return mv;
	}
	
	@RequestMapping("/searchOrderitem")
	public ModelAndView searchUser(HttpServletRequest req) throws Exception{
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		OrderitemDaoImpl impl= new OrderitemDaoImpl();
		List<Orderitem> orderitemList = impl.selectOrderitemById(orderId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orderdetail");
		mv.addObject("orderitemList",orderitemList);
		return mv;
	}
	
	@RequestMapping(value="/deleteOrderitem")
    public ModelAndView deleteOrderitem(HttpServletRequest request, ModelAndView mv){
        Integer orderitemId = Integer.valueOf(request.getParameter("orderitemId"));
        //判断id是否为空
        OrderitemDaoImpl impl = new OrderitemDaoImpl();
        	int o = impl.deleteOrderitem(orderitemId);
        //用redirect进行重定向
        mv.setViewName("/deleteorderitemok");
        return mv;
    }
	
	@RequestMapping("/findupdate")
	public ModelAndView findupdate(HttpServletRequest req) throws Exception{
		int orderitemId = Integer.parseInt(req.getParameter("orderitemId"));
		OrderitemDaoImpl impl= new OrderitemDaoImpl();
		List<Orderitem> orderitemList = impl.findupdate(orderitemId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updatedetail");
		mv.addObject("orderitemList",orderitemList);
		return mv;
	}
	
	@RequestMapping("/updatedetail")
	public ModelAndView updatedetail(HttpServletRequest req) throws Exception{
		int orderitemId = Integer.valueOf(req.getParameter("orderitemId"));
		int orderId = Integer.valueOf(req.getParameter("orderId"));
		int productId = Integer.valueOf(req.getParameter("productId"));
		String productName = req.getParameter("productName");
		String size = req.getParameter("size");
		int count = Integer.valueOf(req.getParameter("count"));
		Float price = Float.parseFloat(req.getParameter("price"));
		Orderitem orderitem = new Orderitem();
		orderitem.setOrderitemId(orderitemId);
		orderitem.setOrderId(orderId);
		orderitem.setProductId(productId);
		orderitem.setProductName(productName);
		orderitem.setSize(size);
		orderitem.setCount(count);
		orderitem.setPrice(price);
		OrderitemDaoImpl impl= new OrderitemDaoImpl();
		int u = impl.updatedetail(orderitem);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/updatedetailok");
		return mv;
	}
}
