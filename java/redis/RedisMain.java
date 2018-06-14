package redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisMain {

	public static void main(String[] args) {  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-redis.xml");  
        RedisUtils redisUtils = (RedisUtils) ctx.getBean("redisUtils");  
        redisUtils.set("china","´ÉÆ÷");  
        List<String> list = new ArrayList<String>();  
        list.add("a");  
        list.add("b");  
        list.add("c");  
        redisUtils.set("list", list);  
        System.out.println("china=" + redisUtils.get("china"));  
        System.out.println("list[1]=" + ((List)redisUtils.get("list")).get(1));  
    }  
}  
