package redis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import redis.clients.jedis.Jedis;

public class test {
	public static void main(String[] args) {
	Jedis jedis = new Jedis("localhost");
    System.out.println("连接成功");
    //设置 redis 字符串数据
    jedis.set("runoobkey", "www.runoob.com");
    // 获取存储的数据并输出
    System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
    
    jedis.lpush("site-list", "Runoob"); //添加， 
    jedis.lpush("site-list", "Google");
    jedis.lpush("site-list", "Taobao");
    jedis.lpush("site-list", "Google");  //添加重复
    jedis. lrem ("site-list", 2, "Google");  //删除为google
    // 获取存储的数据并输出
    List<String> list = jedis.lrange("site-list", 0 ,2);
    for(int i=0; i<list.size(); i++) {
        System.out.println("列表项为: "+list.get(i));
    }
    
    String key = null;
	jedis.sadd(key, "member1");
    jedis.sadd(key, "member1"); // Set不允许重复
    jedis.sadd(key, "member2");
    jedis.smembers(key);// 获取到set集合


}

}
