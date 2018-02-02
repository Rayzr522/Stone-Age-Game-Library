package com.sagl.control;


public abstract class Command {
	
	public abstract void code();
	
	public final void execute() {
		
		code();
		
	}

}
