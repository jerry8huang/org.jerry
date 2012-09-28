package decorator;

public class Entry {
	
	public static void main(String[] args){
		
		Component component=new ConComponent();
		ConDecoratorSingDance conDecoratorSingDance=new ConDecoratorSingDance(new ConDecoratorSing(component));
		conDecoratorSingDance.go();
		
	}

}
