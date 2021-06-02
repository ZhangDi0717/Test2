package com.example.demo.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.session.IoSession;

public class MinaClientHandler extends IoHandlerAdapter {

    private final String values;

    public MinaClientHandler(String values) {
        this.values = values;
    }

//    @Override
//    public void sessionOpened(IoSession session) {
//        session.write(values);
//    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("收到服务器响应消息：" + message);
    }

    @Override
    public void sessionOpened(IoSession session) {
        session.write(values);
        //调用IoService的dispose方法关闭线程
        //IoService service = session.getService();
        //service.dispose();
    }

}
