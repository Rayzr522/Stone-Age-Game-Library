package com.sagl.thread;

public class ThreadUtils {

    public static void sleep(int millis) {
	try {
	    Thread.sleep(millis);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
