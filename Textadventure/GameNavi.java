package Textadventure;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class GameNavi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601;
	private GameView view;
	private Texte texte;
	private String pos; 
	private String input;
	private Action action;
	
	public boolean fire, sudokuHelp, ssp, key, sspWon, sudokuWon, gameWait, isRunning;
	public int help;
	public String versteck, versteckText;
	
	
	public GameNavi(GameView view){

		this.view = view;
		this.texte = new Texte();
		
		this.isRunning = true;
		this.help = 0;
	}
	
	public void play(String input){
		if(sudokuHelp) texte.setText(versteck, "Hier ist nichts Interessantes mehr drin.");
		
		if(pos.equals("start")){
			if(input.equals("")){
				view.setGameText(convertToMultiline(texte.getText("start")));
			}
			else if(input.equalsIgnoreCase("ok")){
				view.setGameText(convertToMultiline(texte.getText("f1")));
				this.pos = "f1";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText("start")));
		}
		else if(pos.equals("f1")) {
			if(input.equalsIgnoreCase("weiter")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else if(input.equalsIgnoreCase("links")){
				view.setGameText(convertToMultiline(texte.getText("l1")));
				pos = "l1";
			}
			else if(input.equalsIgnoreCase("rechts")){
				view.setGameText(convertToMultiline(texte.getText("r1")));
				pos = "r1";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("f2")) {
			if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f1")));
				pos = "f1";
			}
			else if(input.equalsIgnoreCase("weiter")){
				view.setGameText(convertToMultiline(texte.getText("f3")));
				pos = "f3";
			}
			else if(input.equalsIgnoreCase("links")){
				view.setGameText(convertToMultiline(texte.getText("l2")));
				pos = "l2";
			}
			else if(input.equalsIgnoreCase("rechts")){
				view.setGameText(convertToMultiline(texte.getText("r2")));
				pos = "r2";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("f3")) {
			if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else if(input.equalsIgnoreCase("links")){
				view.setGameText(convertToMultiline(texte.getText("l3")));
				pos = "l3";
			}
			else if(input.equalsIgnoreCase("rechts")){
				view.setGameText(convertToMultiline(texte.getText("r3")));
				pos = "r3";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		
		/*
		 *	Erste Tür links, Verwaltung
		 */
		 
		else if(pos.equals("l1")) {
			if(input.equalsIgnoreCase("auf")){
				view.setGameText(convertToMultiline(texte.getText("l1A")));
				pos = "l1A";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f1")));
				pos = "f1";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("l1A")) {
			if(input.equalsIgnoreCase("raus")){
				view.setGameText(convertToMultiline(texte.getText("f1")));
				pos = "f1";
			}
			else if(input.equalsIgnoreCase("aktenv")){
				view.setGameText(convertToMultiline(texte.getText("a1")+texte.getText("l1B")));
			}
			else if(input.equalsIgnoreCase("aktenL")){
				view.setGameText(convertToMultiline(texte.getText("a2")+texte.getText("l1B")));
			}
			else if(input.equalsIgnoreCase("safe")){
				if(sudokuWon){
					if(!key) {
						texte.setText("safe", "Der Tür des Safes öffnet sich. Darin liegen haufenweise Dokumente, \ndie offensichtlich gefälscht wurden, um den grauenhaften Umgang mit den Patienten zu vertuschen.\n Außerdem liegt da ein Schlüssel. Du steckst ihn ein.");
						key = true;
						view.setGameText(convertToMultiline(texte.getText("safe")+texte.getText("l1B")));
					}
					else if(key) {
						texte.setText("safe","Im Safe liegen haufenweise Dokumente, \ndie offensichtlich gefälscht wurden, um den grauenhaften Umgang mit den Patienten zu vertuschen.");
						view.setGameText(convertToMultiline(texte.getText("safe")+texte.getText("l1B")));
					}
				}
				else view.setGameText(convertToMultiline(texte.getText("safe")+texte.getText("l1B")));
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
					
		/*
		 *  Erste Tür rechts, Medikamente
		 */
		 
		else if(pos.equals("r1")) {
			if(input.equalsIgnoreCase("auf")){
				view.setGameText(convertToMultiline(texte.getText("r1A")));
				pos = "r1A";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f1")));
				pos = "f1";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("r1A")) {
			if(input.equalsIgnoreCase("raus")){
				view.setGameText(convertToMultiline(texte.getText("f1")));
				pos = "f1";
			}
			else if(input.equalsIgnoreCase("akten")){
				view.setGameText(convertToMultiline(texte.getText("a3")+texte.getText("r1B")));
			}
			else if(input.equalsIgnoreCase("medizin")){
				view.setGameText(convertToMultiline(texte.getText("m")+texte.getText("r1B")));
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
					
		/*
		 *  Zweite Tür links, Core
		 */
		 
		else if(pos.equals("l2")) {
			if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else if(input.equalsIgnoreCase("ALOHAHUHU")){
				if(fire){
					view.setGameText(convertToMultiline(texte.getText("l2B")));
					pos = "l2B";
				}
				else {
					view.setGameText(convertToMultiline(texte.getText("l2A")));
					pos = "l2A";
				}
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("l2A")) {
			if(input.equalsIgnoreCase("raus")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("l2B")) {
			if(input.equalsIgnoreCase("raus")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else if(input.equalsIgnoreCase("dynamit")){
				view.setGameText(convertToMultiline(texte.getText("d")));
				view.getInputField().removeActionListener(action);
				view.getInputField().setBackground(Color.BLACK);
				view.getInputField().setFocusable(false);
				//isRunning = false;
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		
		/*
		 *   Zweite Tür rechts, Kunden
		 */
		
		else if(pos.equals("r2")) {
			if(input.equalsIgnoreCase("auf")){
				view.setGameText(convertToMultiline(texte.getText("r2A")));
				pos = "r2A";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("r2A")) {
			if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f2")));
				pos = "f2";
			}
			else if(input.equalsIgnoreCase("klein")){
				view.setGameText(convertToMultiline(texte.getText("um1")+texte.getText("r2A")));
			}
			else if(input.equalsIgnoreCase("gross")){
				view.setGameText(convertToMultiline(texte.getText("um2")+texte.getText("r2A")));
			}
			else if(input.equalsIgnoreCase("frau")){
				view.setGameText(convertToMultiline(texte.getText("uf")+texte.getText("r2A")));
			}
			else if(input.equalsIgnoreCase("akte")){
				view.setGameText(convertToMultiline(texte.getText("a4")+texte.getText("r2A")));
			}
			else if(input.equalsIgnoreCase("tuer")){
				view.setGameText(convertToMultiline(texte.getText("r4")));
				pos = "r4";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		
		/*
		 *  Tür hinter Kundenzimmer, Testsubjekte
		 */
		 
		else if(pos.equals("r4")) {
			if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("r2B")));
				pos = "r2B";
			}
			else if(input.equalsIgnoreCase("auf")){
				view.setGameText(convertToMultiline(texte.getText("r4A")));
				pos = "r4A";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("r4A")) {
			if(input.equalsIgnoreCase("ecke")){
				view.setGameText(convertToMultiline(texte.getText("t1")+texte.getText("r4B")));
			}
			else if(input.equalsIgnoreCase("mitte")){
				view.setGameText(convertToMultiline(texte.getText("t2")+texte.getText("r4B")));
			}
			else if(input.equalsIgnoreCase("grins")){
				view.setGameText(convertToMultiline(texte.getText("t3")+texte.getText("r4B")));
			}
			else if(input.equalsIgnoreCase("stuhl")){
				view.setGameText(convertToMultiline(texte.getText("t4")+texte.getText("r4B")));
			}
			else if(input.equalsIgnoreCase("akten")){
				view.setGameText(convertToMultiline(texte.getText("a7")+texte.getText("r4B")));
			}
			else if(input.equalsIgnoreCase("raus")){
				view.setGameText(convertToMultiline(texte.getText("r2A")));
				pos = "r2A";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
					
		/*
		 *	Dritte Tür links, Mitarbeiter
		 */
		
		else if(pos.equals("l3")) {
			if(input.equalsIgnoreCase("auf")){
				view.setGameText(convertToMultiline(texte.getText("l3A")));
				pos = "l3A";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f3")));
				pos = "f3";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("l3A")) {
			if(input.equalsIgnoreCase("dry")){
				view.setGameText(convertToMultiline(texte.getText("dry")+texte.getText("l3B")));
			}
			else if(input.equalsIgnoreCase("drx")){
				view.setGameText(convertToMultiline(texte.getText("drx")+texte.getText("l3B")));
			}
			else if(input.equalsIgnoreCase("hibbel")){
				view.setGameText(convertToMultiline(texte.getText("s")+texte.getText("s")));
			}
			else if(input.equalsIgnoreCase("akten")){
				view.setGameText(convertToMultiline(texte.getText("a5")+texte.getText("l3B")));
			}
			else if(input.equalsIgnoreCase("tuer")){
				view.setGameText(convertToMultiline(texte.getText("l4")));
				pos = "l4";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f3")));
				pos = "f3";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
					
		/*
		 *  Tür hinter Mitarbeiterzimmer, Chefs
		 */
		
		else if(pos.equals("l4")) {
			if(input.equalsIgnoreCase("auf")){
				view.setGameText(convertToMultiline(texte.getText("l4A")));
				pos = "l4A";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("l3B")));
				pos = "l3B";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("l4A")) {
			if(input.equalsIgnoreCase("akten")){
				view.setGameText(convertToMultiline(texte.getText("a6")+texte.getText("l4B")));
			}
			else if(input.equalsIgnoreCase("schmidt")){
				view.setGameText(convertToMultiline(texte.getText("smt")+texte.getText("l4B")));
			}
			else if(input.equalsIgnoreCase("cornwall")){
				if(!sspWon) view.setGameText(convertToMultiline(texte.getText("ceo")+texte.getText("l4B")));
				else if(sspWon){
					texte.setText("ceo", "\"Du hast mich geschlagen. Das Passwort zum Serverraum lautet: ALOHAHUHU\"");
					view.setGameText(convertToMultiline(texte.getText("ceo")+texte.getText("l4B")));
				}
			}
			else if(input.equalsIgnoreCase("schatten")){
				view.setGameText(convertToMultiline(texte.getText("dahl")+texte.getText("l4B")));
			}
			else if(input.equalsIgnoreCase("raus")){
				view.setGameText(convertToMultiline(texte.getText("l3A")));
				pos = "l3A";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		
		/*
		 *   Dritte Tür Rechts, Abstellraum
		 */
		
		else if(pos.equals("r3")) {
			if(input.equalsIgnoreCase("auf")){
				if(!key){
					view.setGameText(convertToMultiline("Die Tür ist verschlossen.")+texte.getText("r3"));
				}
				else if(key){
					view.setGameText(convertToMultiline("Du öffnest die Tür mit dem Schlüssel aus dem Safe. "+texte.getText("r3A")));
					pos = "r3A";
				}
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f3")));
				pos = "f3";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("r3A")) {
			if(input.equalsIgnoreCase("schrank")){
				view.setGameText(convertToMultiline(texte.getText("sr")+texte.getText("r3B")));
			}
			else if(input.equalsIgnoreCase("spind")){
				view.setGameText(convertToMultiline(texte.getText("sp")+texte.getText("r3B")));
			}
			else if(input.equalsIgnoreCase("tisch")){
				view.setGameText(convertToMultiline(texte.getText("t")));
				pos = "t";
			}
			else if(input.equalsIgnoreCase("werkbank")){
				view.setGameText(convertToMultiline(texte.getText("wb")));
				pos = "wb";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("f3")));
				pos = "f3";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("t")) {
			if(input.equalsIgnoreCase("geld")){
				view.setGameText(convertToMultiline(texte.getText("g")+texte.getText("t")));		
			}
			else if(input.equalsIgnoreCase("feuer")){
				view.setGameText(convertToMultiline(texte.getText("f0")));
				pos = "f0";
			}	
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("r3B")));
				pos = "r3A";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
		else if(pos.equals("f0")){
			if(input.equalsIgnoreCase("nimm")){
				fire = true;
				texte.setText("t", "Auf dem Tisch liegen eine halbleere Schachtel Zigaretten und etwas Kleingeld.\n>Geld näher ansehen\t(geld)\n>zurücktreten\t\t(zurueck)\n");
				view.setGameText(convertToMultiline("Du stecks das Feuerzeug ein.\n"+texte.getText("t")));
				pos = "t";
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("t")));
			}
		}
		else if(pos.equals("wb")) {
			if(input.equalsIgnoreCase("schere")){
				view.setGameText(convertToMultiline(texte.getText("sch")+texte.getText("wb")));
			}
			else if(input.equalsIgnoreCase("nimm")){
				ssp = true;
				texte.setText("r3B", "Zu deiner linken steht ein gewöhnlicher Schrank, rechts ein alter Spind und vor dir ein abgenutzter Tisch.\n>Schrank öffnen\t\t(schrank)\n>Spind öffnen\t\t(spind)\n>Tisch untersuchen\t(tisch)\n>zurück in den Flur\t(zurueck)\n");
				view.setGameText(convertToMultiline("Du steckst die Schere, den Stein und das Papier ein. \nDie Werkbank ist jetzt leer.\n"+texte.getText("r3B")));
			}
			else if(input.equalsIgnoreCase("stein")){
				view.setGameText(convertToMultiline(texte.getText("st")+texte.getText("wb")));
			}
			else if(input.equalsIgnoreCase("papier")){
				view.setGameText(convertToMultiline(texte.getText("pa"))+texte.getText("wb"));
			}
			else if(input.equalsIgnoreCase("zurueck")){
				view.setGameText(convertToMultiline(texte.getText("r3B")));
				pos = "r3A";
			}
			else view.setGameText(convertToMultiline(texte.getText("no")+texte.getText(pos)));
		}
	}
	
	/*
	 * GETTER UND SETTER METHODEN
	 */
	
	public boolean isRunning(){
		return isRunning;
	}
	
	public String getInput(){
		return input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getPos(){
		return pos;
	}
	
	public void setPos(String pos){
		this.pos = pos; 
	}
	
	public static String convertToMultiline(String orig)			//METHODE UM IN LABELS MEHRZEILIG ZU SCHREIBEN
	{
	    return "<html>" + orig.replaceAll("\n", "<br>");
	}
	
	public void setText()
	{
		view.setGameText(convertToMultiline(texte.getText(pos)));
	}
	
	public void hideHelp(){
		versteck = "a"+Integer.toString(help);
		texte.setText(versteck, "In dem Aktenschrank war ein abgerissenes Stück Papier versteckt. Du steckst es ein.");
		versteckText = texte.getText(versteck);
	}

	public void setupAction(){
		this.action = new AbstractAction()
		{
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		       	try{
		        	input = view.getInput();
		        	play(input);		
		        	view.setInput("");
		        	
		        }catch(NullPointerException exception){}
		    };
		
		};
		view.getInputField().addActionListener(action);	
		//view.getInputField().addKeyListener(this);
	}

	
	
}
