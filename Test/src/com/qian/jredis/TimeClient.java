package com.qian.jredis;

import java.net.SocketAddress;

/**
 * 时间的客户端，用来服务redisbasedDistributedLock类
 * @author qld
 *
 */
public class TimeClient {
    
    private SocketAddress adress;

    public TimeClient(SocketAddress adress) {
        super();
        this.adress = adress;
    }
    
    public void close(){
        //关闭什么吧
    }

    public long  currentTimeMillis(){
        
        return System.currentTimeMillis();
    }
    
}
