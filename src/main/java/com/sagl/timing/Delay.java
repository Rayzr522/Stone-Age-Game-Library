package com.sagl.timing;

public class Delay {

	private long	startTime;
	private long	delayMillis;

	public Delay(long delayMillis) {

		this.startTime = System.currentTimeMillis();
		this.delayMillis = delayMillis;
		try {

			new Thread() {

				public void run() {

					while (true) {

						if (check()) break;

					}

				}

			}.start();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private boolean check() {

		long currentTime = System.currentTimeMillis();
		if (currentTime - startTime >= delayMillis) {

			try {

				new Thread() {

					public void run() {
						delayedRun();
					}

				}.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;

		}

		return false;

	}

	public void delayedRun() {
		
		System.err.println("ERROR! No delay code!");

	}

}
