package decorator;

public class ConDecoratorDance extends Decorator{
	
	ConDecoratorDance(Component component){
		
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
