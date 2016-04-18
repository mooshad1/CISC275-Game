
public class GameInput {
	
	KeyReader mykeyreader = new KeyReader();
	boolean flag = true; // while true we are setting power, while false we are setting direction
	Arrow arrowtracker;
	PowerBar powerbartracker;
	
	public GameInput(){
		
	}
	
	public GameInput(Arrow arrowtracker, PowerBar powerbartracker){
		this.arrowtracker = arrowtracker;
		this.powerbartracker = powerbartracker;
	}
	
	public void onTick(){
		if(mykeyreader.returnReleased() == true){
			if(flag){
				powerbartracker.setPower();
				flag = false;
				mykeyreader.setReleased(false);
			}
			else{
				arrowtracker.setDirection();
				flag = true;
				mykeyreader.setReleased(false);
			}
		}
		
		// Check if power and direction are set
		if(powerbartracker.getPower() != -1 && arrowtracker.getDirection() != -1){
			// THROW PROJECTILE HERE ---------------------------------------------------------------------------
			
			System.out.println("Power: " + powerbartracker.getPower());
			System.out.println("Direction: " + arrowtracker.getDirection());
			System.out.println("");
			
			// return power, power fluc, direction, directionfluc to defaults
			powerbartracker.defaultPower();
			arrowtracker.defaultDirection();
		}
	}
}
