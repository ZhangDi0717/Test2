package com.example.demo.mina;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

@Configuration
public class ConfigMina {
    @Bean
    public IoAcceptor ioAcceptor() throws IOException {
        //创建相应对类
        NioSocketAcceptor nio = new NioSocketAcceptor();
        //设置session的大小
        nio.getSessionConfig().setReadBufferSize(2048);
        //设置不操作时间自动关闭时间
        nio.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
        //设置session的操作相应函数
        nio.setHandler(new MinaServerHandler());
        //设置服务端的端口号
        nio.bind(new InetSocketAddress(9116));
        return nio;
    }
}
