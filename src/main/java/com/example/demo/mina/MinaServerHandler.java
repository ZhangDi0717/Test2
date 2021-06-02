package com.example.demo.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;

public class MinaServerHandler extends IoHandlerAdapter {//IoHandlerAdapter

    /**
     * Session创建连接时，系统调用该函数
     * @param ioSession
     * @throws Exception
     */
    @Override
    public void sessionCreated(IoSession ioSession) throws Exception {
        System.out.println("server session created");
        super.sessionCreated(ioSession);
    }

    /**
     * Session打开连接时，系统调用该函数
     * @param ioSession
     * @throws Exception
     */
    @Override
    public void sessionOpened(IoSession ioSession) throws Exception {
        System.out.println("server session opened");
        super.sessionOpened(ioSession);
    }

    /**
     * Session关闭连接时，系统调用该函数
     * @param ioSession
     * @throws Exception
     */
    @Override
    public void sessionClosed(IoSession ioSession) throws Exception {

    }

    @Override
    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {

    }

    @Override
    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {

    }

    /**
     * session发送消息是，系统调用该函数
     * @param ioSession
     * @param o
     * @throws Exception
     */
    @Override
    public void messageReceived(IoSession ioSession, Object o) throws Exception {
        System.out.println("l1->Message has been Received");
        IoBuffer ioBuffer = (IoBuffer)o;
        byte[] data = new byte[ioBuffer.limit()];
        ioBuffer.get(data);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            stringBuffer.append((char)data[i]);
        }
        String msg = stringBuffer.toString();
        System.out.println(msg);

        //发送
        if(ioSession.isConnected()){
            IoBuffer buffer = IoBuffer.allocate(10);
            buffer.setAutoExpand(true);
            buffer.put(data);
            buffer.flip();
            ioSession.write(buffer);
        }
    }

    /**
     * 系统主动向session发送消息
     * @param ioSession
     * @param o
     * @throws Exception
     */
    @Override
    public void messageSent(IoSession ioSession, Object o) throws Exception {

    }

    @Override
    public void inputClosed(IoSession ioSession) throws Exception {

    }

    @Override
    public void event(IoSession ioSession, FilterEvent filterEvent) throws Exception {

    }
}
