package decorator;

public class Entry {
	
	public static void main(String[] args){
		
		Component component=new ConComponent();
		ConDecoratorDance conDecoratorSingDance=new ConDecoratorDance(new ConDecoratorSing(component));
		conDecoratorSingDance.go();
		
	}

}
