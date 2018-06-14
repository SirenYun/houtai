package redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtils {
	
	@Autowired  
    private RedisTemplate<String,Object> redisTemplate;  
  
    /**  
     * �õ�ָ��keyֵ��value  
     * @param key  
     */  
    public Object get(String key){  
        return redisTemplate.boundValueOps(key).get();  
    }  
  
    /**  
     * ����ָ��keyֵ��value  
     * @param key  
     * @param value  
     */  
    public void set(String key, Object value){  
        redisTemplate.boundValueOps(key).set(value);  
    }  
  
    /**  
     * ɾ��ָ��key��value  
     * @param key  
     */  
    public void del(String key){  
        redisTemplate.delete(key);  
    }  
}  
