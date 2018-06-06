package controller;
import java.util.Iterator;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import model.UserDaoImpl;

@Controller  
public class UserController {  

	/*@Autowired
	private UserDaoImpl impl;*/
	
	@RequestMapping("/queryUser")
	public ModelAndView queryUser() throws Exception{
		UserDaoImpl impl= new UserDaoImpl();
		List<User> userList = impl.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/alluser");
		mv.addObject("userList",userList);
		return mv;
	}
	
	@RequestMapping("/selectUser")
	public ModelAndView selectUser(HttpServletRequest req) throws Exception{
		String userName = req.getParameter("uname");
		String password = req.getParameter("password");
		
		UserDaoImpl impl= new UserDaoImpl();
		User u = impl.findUser(userName, password);
		if (u.getLimited().equals("1")) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index1");
		mv.addObject("user",u);
		return mv;
		}
		return null;
	}
	
	@RequestMapping("/insertUser")
	public ModelAndView insertUser(HttpServletRequest req) throws Exception{
		String userName = req.getParameter("uname");
		String password = req.getParameter("password");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		String code = req.getParameter("code");
		String email = req.getParameter("email");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setTel(tel);
		user.setAddress(address);
		user.setCode(code);
		user.setEmail(email);
		
		UserDaoImpl impl= new UserDaoImpl();
		boolean u = impl.insertUser(user);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/insertuserok");
		return mv;
	}
	
	@RequestMapping("/searchUser")
	public ModelAndView searchUser(HttpServletRequest req) throws Exception{
		String userName = req.getParameter("uname");
		UserDaoImpl impl= new UserDaoImpl();
		List<User> userList = impl.selectUserByName(userName);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchResult");
		mv.addObject("userList",userList);
		return mv;
	}
	
	//根据获取的id删除新闻
    @RequestMapping(value="/deleteUser")
    public ModelAndView deleteUser(HttpServletRequest request, ModelAndView mv){
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        //判断id是否为空
        	UserDaoImpl impl= new UserDaoImpl();
        	int i = impl.deleteUser(userId);
        //用redirect进行重定向
        mv.setViewName("/alluser");
        return mv;
    }
}  
	

