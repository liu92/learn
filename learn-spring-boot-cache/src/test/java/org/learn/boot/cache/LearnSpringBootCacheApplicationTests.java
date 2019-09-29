package org.learn.boot.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.boot.cache.mapper.EmployeeMapper;
import org.learn.boot.cache.po.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringBootCacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	//这个是用来操作 k-v 的， k-v 都是对象
	@Autowired
	RedisTemplate redisTemplate;

	// 操作字符串的， 其实准确来说是不是字符串 而是一种结构
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<Object, Employee> employeeRedisTemplate;


	@Test
	public void contextLoads() {
		Employee e = employeeMapper.getEmployeeById(1);
		System.out.println(e);
	}


	/**
	 * redis 常见的五大数据类型
	 *  string(字符串), list(列表), set(集合), hash(散列), ZSet(有序集合)
	 *  stringRedisTemplate.opsForValue()[string 字符串]
	 *  stringRedisTemplate.opsForList()[list 列表]
	 *  stringRedisTemplate.opsForSet()[set 集合]
	 *  stringRedisTemplate.opsForHash()[hash 散列]
	 *  stringRedisTemplate.opsForZSet()[zSet 有序集合]
	 *
	 */
	@Test
	public void testRedis(){
		// 给redis 中保存数据
		// stringRedisTemplate.opsForValue().append("msg", "hello");
		// 获取 redis中的值
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

		// 往redis中存放一个 mylist
//		stringRedisTemplate.opsForList().leftPush("mylist","1");
//		stringRedisTemplate.opsForList().leftPush("mylist","2");
		// 从list 中取出一个值， left pop 表示从 列表的左边开始取，上面存入的数据 格式是第1个位置时1=2，第2个位置2=1
//		String mylist = stringRedisTemplate.opsForList().leftPop("mylist");
//		System.out.println(mylist);
	}

	@Test
	public void testObject(){
		Employee employeeById = employeeMapper.getEmployeeById(1);
		// 默认如果保存对象，使用jdk 序列化机制，序列化后的数据保存到redis中
//		redisTemplate.opsForValue().set("emp", employeeById);
		//如果不想序列化数据，那么
		// 1、将数据以json的方式保存。(1)自己将对象转为json,(2)redisTemplate 默认的序列化规则
		//

		employeeRedisTemplate.opsForValue().set("emp", employeeById);
	}
}











