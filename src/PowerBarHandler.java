import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PowerBarHandler extends Handler {

	Image image;
	
	PowerBarHandler(OverallGame overallGame) {
		super(overallGame);
		// TODO Auto-generated constructor stub
		try{
			image = ImageIO.read(new File("img/powerbar.png"));
		}
		catch(IOException e)
		{
			System.out.println("PowerBar Image not found");
		}
	}

	public void paint(Graphics g) {
		for (GameObject gameObject : getOverallGame().getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof PowerBar)
			{
				g.drawImage( image, (int)gameObject.xPosition, (int)gameObject.yPosition, Color.gray, null);
			}
		}
	}
	
}
