/**
 * 
 * @author Kahila kalombo (218095095)
 * @version 1.0
 * @since 2020-07-27
 * @filename ScanPorts
 * */

package portScanner;

import java.net.*;
import java.io.*;

public class ScanPorts { // the method throws an UnknownHostException error
	public void listOpen(){
		
		
		String hostname = "localhost";		
		Socket s = null;
		
		try {
			//checking if the host exists ... in this case the computer being used
			InetAddress ipAddr = InetAddress.getByName(hostname);
			
			//looping through all the ports and checking for open ones
			for (int i = 1; i <= 65535; i++) {
				try {
					s = new Socket(hostname, i);
					System.out.printf("port %d:\t\t\topen\n",i);
					s.close();
				}catch(IOException e){
					System.out.printf("port %d:\t\t\tclosed\n", i);
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
}