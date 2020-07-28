/**
 * 
 * @author Kahila kalombo (218095095)
 * @version 1.0
 * @since 2020-07-27
 * @filename GetIP
 * */

package portScanner;

import java.net.InetAddress;

public class GetIP {
	private String systemIP = "";

	public String getIP(){
		try {
			InetAddress add = InetAddress.getLocalHost();
			systemIP = add.getHostAddress();
		}catch(Exception e) {
			systemIP = "IP not Found!!\n";
		}
		return (systemIP);
	}
}
