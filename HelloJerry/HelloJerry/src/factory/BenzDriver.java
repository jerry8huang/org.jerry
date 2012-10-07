package factory;

public class BenzDriver implements Driver {
	
	public Car driveCar(){
		
		return new Benz();
	}

}
