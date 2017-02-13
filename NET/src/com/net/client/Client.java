package com.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("localhost",8800);
			OutputStream  os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("�û���:anon;����:52314");
			pw.flush();
			socket.shutdownOutput();
			InputStream in=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String reply=null;
			while ((reply=br.readLine())!=null) {
				System.out.println("���ǿͻ���,������˵:"+reply);
			}
			br.close();
			in.close();
			pw.close();
			os.close();
		} catch (UnknownHostException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
//public class Client {
//	public static void main(String[] args) {
//		try {
//			//1.�����ͻ���Socket��ָ����������ַ�Ͷ˿�
//			Socket socket=new Socket("localhost", 8800);
//			//2.��ȡ���������������˷�����Ϣ
//			OutputStream os=socket.getOutputStream();//�ֽ������
//			PrintWriter pw=new PrintWriter(os);//���������װΪ��ӡ��
//			pw.write("�û�����alice;���룺789");
//			pw.flush();
//			socket.shutdownOutput();//�ر������
//			//3.��ȡ������������ȡ�������˵���Ӧ��Ϣ
//			InputStream is=socket.getInputStream();
//			BufferedReader br=new BufferedReader(new InputStreamReader(is));
//			String info=null;
//			while((info=br.readLine())!=null){
//				System.out.println("���ǿͻ��ˣ�������˵��"+info);
//			}
//			//4.�ر���Դ
//			br.close();
//			is.close();
//			pw.close();
//			os.close();
//			socket.close();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
