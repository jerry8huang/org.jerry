package factoryMethod;

//BenzDriver is concrete factory implementing factory Driver.

public class BenzDriver implements Driver {
	
	public Car driveCar(){
		
		return new Benz();
	}

}
