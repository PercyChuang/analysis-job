package com.lmw.analysis.redis;

/**
 * REDIS锁
 */
public interface IRedisLock {
   
    /**
     * Acquire lock.
     * 
     * @return true if lock is acquired, false acquire timeouted
     * @throws InterruptedException
     *             in case of thread interruption
     */
    public boolean acquire() throws InterruptedException;

    /**
     * Acquired lock release.
     */
    public void release();
}
