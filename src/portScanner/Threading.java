
/**
 * 
 * @author Kahila kalombo (218095095)
 * @version 1.0
 * @since 2020-07-27
 * @filename Threading
 * */

package portScanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*class responsible for allocating number of 
 threads to specific IP range*/
public class Threading implements Runnable{
	private Thread t;
	private String tName;
	private int start = 0, end = 0;
	
	public Threading (String name, int start, int end){
		tName = name;
//		System.out.printf("Creating thread %s\n", tName);
		this.start = start;
		this.end = end;
	}

//	method provides an entry point for the thread.
	public void run() {		
			String hostname = "";		
			Socket s = null;
			
			try {
				InetAddress add = InetAddress.getLocalHost();
				hostname = add.getHostAddress();
			}catch(Exception e) {
			}
	
			try {
				//checking if the host exists ... in this case the computer being used
				InetAddress ipAddr = InetAddress.getByName(hostname);
				
				//looping through all the ports and checking for open ones
				for (int i = start; i <= end; i++) {//65535
					if (i > 65535)
						break;
					try {
						s = new Socket(hostname, i);
						System.out.printf("port %d:\t\t\topen\n",i);
						s.close();
					}catch(IOException e){
					}
				}
			}catch(UnknownHostException e) {
				System.out.printf("Host Not Found\n");
			}
			if (s != null) {
				try {
					s.close();
				}catch(IOException e) {}
			}
		}
	
	public void start() {
		if (t == null) {
			t = new Thread (this, tName);
			t.start();
		}
	}
}
