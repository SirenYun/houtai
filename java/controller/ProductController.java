package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Product;
import model.ProductDaoImpl;
import model.User;
import model.UserDaoImpl;

@Controller  
public class ProductController {

	@RequestMapping("/insertProduct")
	public ModelAndView insertUser(HttpServletRequest req) throws Exception{
		String productName = req.getParameter("productName");
		String color = req.getParameter("color");
		Float price = Float.parseFloat(req.getParameter("price"));
		String size = req.getParameter("size");
		String img = req.getParameter("img");
		Product product = new Product();
		product.setProductName(productName);
		product.setColor(color);
		product.setPrice(price);
		product.setSize(size);
		product.setImg(img);
		ProductDaoImpl impl= new ProductDaoImpl();
		boolean p = impl.insertProduct(product);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/addproductok");
		return mv;
	}
	
	@RequestMapping("/queryProduct")
	public ModelAndView queryProduct() throws Exception{
		ProductDaoImpl impl= new ProductDaoImpl();
		List<Product> productList = impl.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/allproduct");
		mv.addObject("productList",productList);
		return mv;
	}
	
	@RequestMapping("/searchProduct")
	public ModelAndView searchProduct(HttpServletRequest req) throws Exception{
		String productName = req.getParameter("productName");
		ProductDaoImpl impl= new ProductDaoImpl();
		List<Product> productList = impl.selectProductByName(productName);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchProductResult");
		mv.addObject("productList",productList);
		return mv;
	}
	
	
	
}
