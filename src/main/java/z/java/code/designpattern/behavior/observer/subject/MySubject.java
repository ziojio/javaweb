package z.java.code.designpattern.behavior.observer.subject;

public class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("onChanged self!");
		notifyObservers();
	}

}
