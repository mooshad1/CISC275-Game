import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ArrowHandler extends Handler {

	public static final int arrowWidth = 50;
	public static final int arrowHeight = 140;
	Image image;
	
	ArrowHandler(OverallGame overallGame) {
		super(overallGame);
		// TODO Auto-generated constructor stub
		try{
			image = ImageIO.read(new File("img/arrow.png"));
		}
		catch(IOException e)
		{
			System.out.println("Arrow Image not found");
		}
	}

	public void paint(Graphics g) {
		for (GameObject gameObject : getOverallGame().getGameState().getGameObjectCollection())
		{
			if (gameObject instanceof Arrow)
			{
				// rotate arrow - NEEDS TESTING -----------------------------------------------------
				Arrow myArrow = (Arrow) gameObject;
				double rotation_needed = 180 - myArrow.getDirection();
				double locationX = (double) arrowWidth;
				double locationY = (double) arrowHeight;
				AffineTransform tx = AffineTransform.getRotateInstance(rotation_needed, locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				
				g.drawImage( image, (int)gameObject.xPosition, (int)gameObject.yPosition, Color.gray, null);
			}
		}
	}
	
}
