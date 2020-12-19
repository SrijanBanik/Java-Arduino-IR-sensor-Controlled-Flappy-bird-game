
	
	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
	
	import com.fazecast.jSerialComm.*;
	
	public class ir extends flappyBird implements ActionListener{
	
		public int value;
	
		public  ir() {
			flappyBird  = new flappyBird();
			
	
			SerialPort[] ports = SerialPort.getCommPorts();
			System.out.println("Select a port:");
			int i = 1;
			for(SerialPort port : ports) 
				System.out.println(i++ +  ": " + port.getSystemPortName());
			Scanner s = new Scanner(System.in);
			int chosenPort = s.nextInt();
	
		SerialPort serialPort = ports[chosenPort - 1];
			if(serialPort.openPort()) 
				System.out.println("Port opened successfully.");
			else {
				System.out.println("Unable to open the port.");
		return;}
						//serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
			serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
	
			Scanner data = new Scanner(serialPort.getInputStream());
			 value = 0;
			// flappyBird fp = new flappyBird();
			while(data.hasNextLine()){
				try{value = Integer.parseInt(data.nextLine());}catch(Exception e){}
				System.out.println(value);
				
						if(value==0) {
							
							
						//	ActionEvent e;
							//ActionEvent irEvent = null;
							//flappyBird.actionPerformed(irEvent );
							flappyBird.jump();
								
							}
						}
						
						
			}
				}
			
			//System.out.println("Done.");
		
		
	
