package redis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import redis.clients.jedis.Jedis;

public class test {
	public static void main(String[] args) {
	Jedis jedis = new Jedis("localhost");
    System.out.println("���ӳɹ�");
    //���� redis �ַ�������
    jedis.set("runoobkey", "www.runoob.com");
    // ��ȡ�洢�����ݲ����
    System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("runoobkey"));
    
    jedis.lpush("site-list", "Runoob"); //��ӣ� 
    jedis.lpush("site-list", "Google");
    jedis.lpush("site-list", "Taobao");
    jedis.lpush("site-list", "Google");  //����ظ�
    jedis. lrem ("site-list", 2, "Google");  //ɾ��Ϊgoogle
    // ��ȡ�洢�����ݲ����
    List<String> list = jedis.lrange("site-list", 0 ,2);
    for(int i=0; i<list.size(); i++) {
        System.out.println("�б���Ϊ: "+list.get(i));
    }
    
    String key = null;
	jedis.sadd(key, "member1");
    jedis.sadd(key, "member1"); // Set�������ظ�
    jedis.sadd(key, "member2");
    jedis.smembers(key);// ��ȡ��set����


}

}
