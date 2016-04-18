
public class PowerBar extends GameObject {
	private int powerfluc; //the power that fluctuates on every tick
	private int power; // the power that the player chooses using the space bar.
	private boolean flag; // Used to determine if powerfluc bar is going up or down
	
	public PowerBar(double xPosition, double yPosition, double xVelocity,
			double yVelocity, GameState gameState) {
		super(xPosition, yPosition, xVelocity, yVelocity, gameState);
		
		power = -1;
		powerfluc = 0;
		flag = true;
	}
	
	
	private void setPowerFluc(){
		if(flag){
			powerfluc++;
			if(powerfluc >= 100){
				flag = false;
			}
		}
		else{
			powerfluc--;
			if(powerfluc <= 0){
				flag = true;
			}
		}
	}

	public void updateState(){
		this.xPosition = gameState.frameWidth / 8;
		this.yPosition = gameState.frameHeight - 300;  // These variables will need to be changed later
		this.xVelocity = 0;
		this.yVelocity = 0;
		
		setPowerFluc();
	}
	
	public int getPowerFluc(){
		return powerfluc;
	}
	
	public void setPowerFluc(int x){
		powerfluc = x;
	}
	
	// this is called when the player releases the space bar
	public void setPower(){
		power = powerfluc;
	}
	
	public int getPower(){
		return power;
	}
	
	public void defaultPower(){
		power = -1;
		this.setPowerFluc(0);
		flag = true;
	}
}
