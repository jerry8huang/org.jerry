package factoryMethod;

public class EntryFactory {
	
	public static void main(String[] args){
		
		
		Car car=new BMWDriver().driveCar();
		
	
		//Car car=new BenzDriver().driveCar();
				
		
		car.drive();
		
	}

}
