package Breakout_week3Day1;

public class Samsung extends AndroidTV implements Android {

	public void openanApp() {
		System.out.println("openAPP in concrete class");
		
	}

	public void watchvideo() {
		System.out.println("watchvideo in concrete class");
		
	}

	public void playvideo() {
		System.out.println("playvideo in concrete class");
		
	}

	@Override
	void ownmethod() {
		System.out.println("Abstract class own method implemented in concrete class");
		
	}
	public static void main(String[] args) {
		Samsung sam=new Samsung();
		System.out.println("Inside Samsung class which is also called as concrete class:");
		sam.openanApp();
		sam.watchvideo();
		sam.playvideo();
		sam.ownmethod();
	}

}
