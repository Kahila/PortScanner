/**
 * 
 * @author Kahila kalombo (218095095)
 * @version 1.0
 * @since 2020-07-27
 * */

import portScanner.GetIP;
import portScanner.ScanPorts;
import portScanner.Threading;

public class Main {

	public static void main(String[] args) {
		GetIP ip = new GetIP();
		ScanPorts ports = new ScanPorts();
		Threading threads[]; 
		threads = new Threading[1009]; //working with 1009 threads
		int start = 0, end = 0;
		
		System.out.printf("System IP Address is %s\n\n", ip.getIP());//outputs IP
		for (int i =1; i <= 1009; i++) {
			if (i ==1) {
				start = 1;
				end = (i*65)+1;
			}
			else {
				start = end+1;
				end = (i*65)+1;
			}
			//creating the processes
			threads[i-1] = new Threading("Thread "+(i)+" from "+ start +" - "+end, start, end);
			threads[i-1].start();
		}
	}
}

