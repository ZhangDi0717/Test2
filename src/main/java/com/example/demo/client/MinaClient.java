package com.example.demo.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {

    public static void main(String[] args) {
        //1、创建客户端IoService
        IoConnector connector=new NioSocketConnector();
        //客户端链接超时时间
        connector.setConnectTimeoutMillis(30000);
        //2、客户端过滤器
        connector.getFilterChain().addLast("test",
                new ProtocolCodecFilter(
                        new TextLineCodecFactory(
                                Charset.forName("UTF-8"),
                                LineDelimiter.WINDOWS.getValue(),
                                LineDelimiter.WINDOWS.getValue()
                        )
                )
        );
        //3、客户端IoHandler，发生消息
        connector.setHandler(new MinaClientHandler("你好！/r/n 大家好！\\rquit"));
        //连接服务端
        connector.connect(new InetSocketAddress("localhost", 9123));
       //System.out.println(connector.connect(new InetSocketAddress("localhost", 9123)));
       int a=1;
       a=2;

    }
}

