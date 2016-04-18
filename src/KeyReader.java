import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Class responsible for getting the power and direction from the powerbar and 
// arrow when the spacebar is pressed.  These variables should be passed to 
// the projectile class to tell the program where the projectile is going.
public class KeyReader extends JPanel {

	private static final long serialVersionUID = 543L;
	
	private boolean released = false; // determines whether the space bar was pressed
	
	public KeyReader() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}
	
	// Confirms whether space is pressed or not
	public boolean returnReleased(){
		return released;
	}
	
	public class MyKeyListener implements KeyListener {
		
		@Override
		public void keyTyped(KeyEvent e) {
			//System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	
		// Nothing should happen here
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			//if(KeyEvent.getKeyText(e.getKeyCode()) == "Space"){
			//	pressed = true;
			//}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			if(KeyEvent.getKeyText(e.getKeyCode()) == "Space"){
				released = true;
			}
		}
	}
	
	public void setReleased(boolean x){
		released = x;
	}
	
	/*
	public static void main(String[] args) {
		JFrame frame = new JFrame("Key Reader");
		KeyReader mykeyreader = new KeyReader();
		frame.add(mykeyreader);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	*/
	
}
