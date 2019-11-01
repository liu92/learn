package org.learn.boot.cache.distributedlock;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisDistributedLock
 * @Description:
 * @Author: lin
 * @Date: 2019/10/25 22:59
 * History:
 * @<version> 1.0
 */
public class RedisDistributedLock implements DistributedLock {



    /**
     * stringRedisTemplate 是对 RedisTemplate再一次封装
     */
    private StringRedisTemplate stringRedisTemplate;

    /**
     *
     */
    private RedisTemplate redisTemplate;

    /**
     * 分布式锁的键值
     */
    private String lockKey;

    /**
     * 锁的超时时间 10s
     */
    int expireTime = 10 * 1000;

    /**
     * 锁等待，防止线程饥饿
     */
    int acquireTimeout  = 1000;

    /**
     * 获取指定键值的锁
     * @param stringRedisTemplate
     * @param lockKey 锁的键值
     */
    public RedisDistributedLock(StringRedisTemplate stringRedisTemplate, String lockKey) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.lockKey = lockKey;
    }





    /**
     * 获取锁
     * @return 锁标识
     * @author
     */
    @Override
    public String distributedAcquireAndRelease() {
        // 随机生成一个id ，这个id主要是用来在删除时 判断 一个key中值是相等。
        String uuid = UUID.randomUUID().toString();
        try {
            Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(lockKey,
                    uuid , expireTime, TimeUnit.SECONDS);
            // 如果这里返回为true 说明锁已经被其他线程。那么其他线程来 就获取不到锁，然后返回false.
            if(!aBoolean){
                return "请稍后重试";
            }
            //下面 就去执行业务逻辑
        }catch (Exception e){

        }finally {
            if(uuid.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                /**
                 * 释放锁, 为什么要使用uuid做判断呢？ 因为在多线程情况下，会出现锁失效的情况，比如说有三个线程
                 // 第一个线程执行总共需要15s，第二个线程执行需要 8s , 第三个先执行需要 5s
                 // 如果第一个现在在执行到解锁操作是，如果不去判断，并且第一个线程的执行到10s 时锁已经过期了，
                 // 那么 第二个线程在执行获取锁的时候就可以获取到了,
                 // 在第一个线程再执行5s中，也就是执行完了解锁操作，而第二个线程同样执行5s中 但是没有执行完。
                 // 但是这里有个问题 就是第一个线程在执行到15s时 执行了 解锁操作。 但是这个锁 不是第一个线程加的 而是第二个线程加的， 所以
                 // 就造成了 释放锁错误 ，而这个随机变量 就是用来判断是不是 同一个线程 加锁key对应的值，如果不是 则不能进行解锁操作。
                  同理 后面的线程也是一样的道理 ，锁在过期后，这个锁的释放 需要对应。
                 */
              stringRedisTemplate.delete(lockKey);
            }
        }

        return null;
    }


}
