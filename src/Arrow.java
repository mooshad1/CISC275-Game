
public class Arrow extends GameObject {
	private int directfluc;
	private int direction;
	private boolean flag; // Used to determine if arrow is rotating left or right
	
	public Arrow(double xPosition, double yPosition, double xVelocity,
			double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		
		direction = -1;
		flag = true;
		directfluc = 0;
	}
	
	
	private void setDirectFluc(){
		if(flag){
			directfluc++;
			if(directfluc >= 180){
				flag = false;
			}
		}
		else{
			directfluc--;
			if(directfluc <= 0){
				flag = true;
			}
		}
	}

	public void updateState(){
		this.xPosition = gameState.frameWidth / 2 - 150;
		this.yPosition = gameState.frameHeight - 350;
		this.xVelocity = 0;
		this.yVelocity = 0;
		
		setDirectFluc();
	}
	
	public int getDirection(){
		return direction;
	}
	
	public void setDirection(){
		direction = directfluc;
	}
	
	public int getDirectFluc(){
		return directfluc;
	}
	
	public void setDirectFluc(int x){
		directfluc = x;
	}
	
	public void defaultDirection(){
		direction = -1;
		this.setDirectFluc(0);
		flag = true;
	}
}
