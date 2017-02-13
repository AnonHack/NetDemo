package com.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {	
	public static void main(String[] args) {
		try {
			InetAddress address=InetAddress.getByName("localhost");
			int port=8888;
			DatagramSocket socket=new DatagramSocket();
			/*
			 * 发送数据
			 * */
			byte [] buf="用户名:anon;密码:2356".getBytes();
			DatagramPacket data= new DatagramPacket(buf, 0, buf.length, address,port);
			
			socket.send(data);
			/*
			 * 接收数据
			 * */
			byte[]buf2=new byte[1024];
			DatagramPacket packet=new DatagramPacket(buf2, 0, buf2.length);
			
			socket.receive(packet);
			String reply=new String(buf2,0,buf.length);
			System.out.println("我是客户端,服务器说:"+reply);
			socket.close();
		} catch (UnknownHostException | SocketException e) {
			
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
}
