package decorator;

public class ConDecoratorSingDance extends Decorator{
	
	ConDecoratorSingDance(Component component){
		
		super(component);
	}

	public void go(){
		
		component.go();
		dance();
		
		
		
	}
	
	void dance(){
		
		System.out.println("dance");
	}
	
}
