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
		 * �����������˿�
		 * */
		try {
			DatagramSocket socket=new DatagramSocket(8888);
			byte [] buf=new byte[1024];
			DatagramPacket packet=new DatagramPacket(buf, buf.length);
			//��������
			socket.receive(packet);
			String info=new String(buf,0,packet.getLength());
			System.out.println("���Ƿ�����,�ͻ���˵:"+info);
			
			/*
			 * ��Ӧ��Ϣ
			 * */
			//����ͻ��˵�ַ,�˿ں�,����
			InetAddress address=packet.getAddress();
			int port=packet.getPort();
			byte [] bytes="��ӭ��".getBytes();
			DatagramPacket packet2=new DatagramPacket(bytes, bytes.length,address,port);
			socket.send(packet2);
			socket.close();
		} catch (SocketException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
