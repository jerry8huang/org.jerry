package factory;

public class EntryFactory {
	
	public static void main(String[] args){
		
		//想开宝马告诉宝马的司机，就得了
		//Car car=new BMWDriver().driveCar();
		
		//想开宝马告诉奔驰的司机，就得了
		Car car=new BenzDriver().driveCar();
				
		//上了车，只需喊“开车”
		car.drive();
		
	}

}
