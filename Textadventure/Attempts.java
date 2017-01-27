package Textadventure;

import java.io.Serializable;

public class Attempts implements Serializable, Comparable<Attempts>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int minutes, seconds;
	private String name;
	private int time;
	
	public Attempts(int min, int sec, String name){
		
		this.minutes = min;
		this.seconds = sec;
		this.name    = name;
		
		this.time = Integer.parseInt(""+minutes+seconds);
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Attempts o) {
		if(time>o.time)	return -1;
		else if(time<o.time) return 1;
		return 0;
	}

	
	
}
