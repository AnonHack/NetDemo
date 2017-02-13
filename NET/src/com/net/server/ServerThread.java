package com.net.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	Socket  socket=null;
	private InputStream in;
	private BufferedReader br;
	private OutputStream os;
	private BufferedWriter bw;
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	
	public void run() {
		try {
			in=socket.getInputStream();
			br=new BufferedReader(new InputStreamReader(in));
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("我是服务器,客户端说:"+info);
				
			}
			socket.shutdownInput();
			os=socket.getOutputStream();
			bw=new BufferedWriter(new OutputStreamWriter(os));
			bw.write("欢迎你!");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				try {
					if (bw!=null) {
					bw.close();
					}
					if (os!=null) {
						os.close();
					}
					if (socket!=null) {
						socket.close();
					}
					if (br!=null) {
						br.close();
						
					}
					if (in!=null) {
						in.close();
						
					}
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		
	}
 
	
}
