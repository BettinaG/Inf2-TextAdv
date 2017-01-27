package Textadventure;

import java.io.Serializable;

public class Saves implements Serializable{

	public boolean key, fire, ssp, sudokuHelp;
	public String pos; 
	public boolean[] maps;
	public int minutes, seconds, help;
	public String name;
	
	public Saves(boolean key, boolean fire, boolean ssp, boolean sudokuHelp, String pos, boolean[] maps, int help, int minutes, int seconds, String name){
		
		this.key 		= key; 
		this.fire 		= fire;
		this.ssp 		= ssp;
		this.sudokuHelp = sudokuHelp;
		this.maps 		= maps;
		this.minutes 	= minutes;
		this.seconds 	= seconds;
		this.name 		= name;
		this.pos 		= pos;
		this.help 		= help;
	}
	
	}
