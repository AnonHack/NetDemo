package com.net.server;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����tcp��������
 * */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(8800);
			Socket socket=null;
			int count=0;
			System.out.println("��������������");
			
			while (true) {
				socket=ss.accept();
				
				ServerThread thread=new ServerThread(socket);
				thread.start();
				count++;
//				System.out.println("�ͻ�������:"+count);
//				InetAddress address=socket.getInetAddress();
//				System.out.println("��ǰ�ͻ��˵�IP��ַ:"+address);
			}
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
//public class Server {
//	public static void main(String[] args) {
//		try {
//			//1.����һ����������Socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
//			ServerSocket serverSocket=new ServerSocket(8800);
//			Socket socket=null;
//			//��¼�ͻ��˵�����
//			int count=0;
//			System.out.println("***�����������������ȴ��ͻ��˵�����***");
//			//ѭ�������ȴ��ͻ��˵�����
//			while(true){
//				//����accept()������ʼ�������ȴ��ͻ��˵�����
//				socket=serverSocket.accept();
//				//����һ���µ��߳�
//				ServerThread serverThread=new ServerThread(socket);
//				//�����߳�
//				serverThread.start();
//				
//				count++;//ͳ�ƿͻ��˵�����
//				System.out.println("�ͻ��˵�������"+count);
//				InetAddress address=socket.getInetAddress();
//				System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
//
