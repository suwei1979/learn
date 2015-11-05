package test.spring.methodinjection;

public interface Command {

	void setState(Object commandState);

	Object execute();

}
