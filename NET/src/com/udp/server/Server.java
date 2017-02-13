package com.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import javax.lang.model.element.NestingKind;

public class Server {
	public static void main(String[] args) {
		/*
		 * 创建服务器端口
		 * */
		try {
			DatagramSocket socket=new DatagramSocket(8888);
			byte [] buf=new byte[1024];
			DatagramPacket packet=new DatagramPacket(buf, buf.length);
			//接收数据
			socket.receive(packet);
			String info=new String(buf,0,packet.getLength());
			System.out.println("我是服务器,客户端说:"+info);
			
			/*
			 * 响应信息
			 * */
			//定义客户端地址,端口号,数据
			InetAddress address=packet.getAddress();
			int port=packet.getPort();
			byte [] bytes="欢迎你".getBytes();
			DatagramPacket packet2=new DatagramPacket(bytes, bytes.length,address,port);
			socket.send(packet2);
			socket.close();
		} catch (SocketException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
