package decorator;

public class Decorator implements Component {
	
	protected Component component;
	
	Decorator(Component component){
		
		this.component=component;
	}
	
	public void go(){
		
		component.go();
		
	}

}
