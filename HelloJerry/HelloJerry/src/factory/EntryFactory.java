package factory;

public class EntryFactory {
	
	public static void main(String[] args){
		
		//�뿪������߱����˾�����͵���
		//Car car=new BMWDriver().driveCar();
		
		//�뿪������߱��۵�˾�����͵���
		Car car=new BenzDriver().driveCar();
				
		//���˳���ֻ�躰��������
		car.drive();
		
	}

}
