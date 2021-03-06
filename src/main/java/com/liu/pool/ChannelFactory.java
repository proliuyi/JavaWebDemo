package com.liu.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * 
 * @function   信道工厂
 * @author     极客空
 * @date       2018年12月16日 下午5:04:15
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class ChannelFactory extends BasePooledObjectFactory<ManagedChannel> {

    private String host;
    private int port;

    @SuppressWarnings("deprecation")
    @Override
    public ManagedChannel create() throws Exception {
        return ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
    }
    
    @Override
    public PooledObject<ManagedChannel> wrap(ManagedChannel channel) {
        return new DefaultPooledObject<ManagedChannel>(channel);
    }
    
    public ChannelFactory(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
}
