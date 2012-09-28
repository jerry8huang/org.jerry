package decorator;

public class ConDecoratorSing extends Decorator {
	
	 ConDecoratorSing(Component component){
		 
		 super(component);
	 }

	 public void go(){
		 component.go();
		 
         sing();		
		 
	 }
	 
	 void sing(){
		 
		 System.out.println("sing");
	 }
	 
}
