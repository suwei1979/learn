package test.spring.sample;

public class LoveScene {
	public void play() {
		//
		Boy boy = new Boy("handsomeboy");
		// problem happens
		// Boy boy = new Boy("uglyboy");
		boy.seek();
		boy.setgirl(new Girl("any girl"));
		boy.kiss();
		boy.marry();
	}
}
