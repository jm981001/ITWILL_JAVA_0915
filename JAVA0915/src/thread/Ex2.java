package thread;

import java.time.LocalTime;

public class Ex2 {

	public static void main(String[] args) {

		Thread timer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<=60; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(LocalTime.now()); 
				}
			}
		});
	}

}
