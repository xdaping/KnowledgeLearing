package others;


import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.Random;

public class AutoHitWeb {

	public static void main(String args[]) {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Robot robot = new Robot();
			
			while (true) {
				robot.mouseMove(screenSize.width/2-40, screenSize.height-285);
				Random a = new Random();
				int  b = a.nextInt(500);
				int  c = a.nextInt(10);
				int i=0;
				robot.delay(4000);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.delay(c);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.delay(1000);
				while(i++<1500){
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.delay(5);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
//					//robot.delay(500);
////					robot.mouseMove(screenSize.width/2+(800-670),150 );
////					robot.delay(1000);
//					robot.mousePress(InputEvent.BUTTON1_MASK);
//					//robot.delay(500);
//					robot.mouseRelease(InputEvent.BUTTON1_MASK);
//					robot.delay(500);
					System.out.println(i);
				}
					
					
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
