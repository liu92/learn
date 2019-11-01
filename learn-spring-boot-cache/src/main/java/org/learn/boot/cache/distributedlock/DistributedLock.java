package org.learn.boot.cache.distributedlock;

/**
 *  使用redis来 编写分布式锁
 * @ClassName: DistributedLock
 * @Description:
 * @Author: lin
 * @Date: 2019/10/25 22:58
 * @History:
 * @<version> 1.0
 */
public interface DistributedLock {

    /**
     * 获取锁 和释放锁
     * @author
     * @return 锁标识
     */
    String distributedAcquireAndRelease();


}
