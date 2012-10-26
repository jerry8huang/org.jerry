package factoryMethod;

//BMWDriver is concrete factory implementing factory Driver.

public class BMWDriver {
	
	public Car driveCar(){
		
		return new BMW();
	}

}
