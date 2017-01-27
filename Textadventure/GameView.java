package Textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.io.Serializable;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1289122293765373385L;
	
	private JButton saveBtn = new JButton("Speichern&Ende");	//SPEICHERN&ENDE BUTTON
	private JLabel minutes, seconds;							//LABEL MINUTENANZEIGE / SEKUNDENANZEIGE
	private JButton itemBtn1, itemBtn2, itemBtn3;				//ANZEIGEBUTTONS FÜR ITEMS
	private JLabel gameText = new JLabel();						//TEXTBEREICH FÜR DAS GAMEPANEL
	private TextField input = new TextField();	
	private JLabel bilder[];
	
	public GameView(){
		
		/*
		 * ALLGEMEINES ZUM FENSTER
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,600);
		setVisible(true);
		
		/*
		 * FENSTERINHALTE
		 */		
		
		JPanel itemPnl = new JPanel();					//ITEMPANEL
		itemPnl.setBackground(new Color(50,100,140));
		JPanel menuPnl = new JPanel();					//MENÜPANEL
		menuPnl.setBackground(new Color(50,100,140));
		JPanel timePnl = new JPanel();					//TIMEPANEL
		timePnl.setBackground(new Color(60,110,150));
		JPanel gamePnl = new JPanel();					//SPIELPANEL
		gamePnl.setBackground(new Color(70,120,160));
		JPanel picPnl = new JPanel(); 					//PICTUREPANEL FÜR DAS GAMEPANEL
		
		
		JLabel timeLbl = new JLabel("Time: ");				//LABEL FÜR ZEITANZEIGE
		JLabel timeDots = new JLabel(":");					//LABEL FÜR ":" ZWISCHEN MINUTEN UND SEKUNDEN
		JLabel minutes = new JLabel();						//LABEL FÜR MINUTENANZEIGE						
    	JLabel seconds = new JLabel();						//LABEL FÜR SEKUNDENANZEIGE
    	
    	ImageIcon noItem = new ImageIcon("src/Textadventure/noItem.png");		//BILDDATEI FÜR "KEIN ITEM"
    	ImageIcon noMap = new ImageIcon("src/Textadventure/noMap.jpg");			//BILDDATEI FÜR "KEINE MAP"
		
		/*
		 *  GAMEPANEL BEFÜLLEN
		 */
		
		noMap.setImage(noMap.getImage().getScaledInstance(130, 100, Image.SCALE_DEFAULT));	//BILDGRÖßE ANPASSEN
		this.bilder = new JLabel[12];				//ARRAY MIT BILDLABELS
		for(int i=0; i<12; i++)						//ARRAY MIT LEEREN KARTENBILDERN FÜLLEN
		{
			bilder[i] = new JLabel(noMap);
		}
		
		picPnl.setLayout(new GridLayout(3,4));		//GRIDLAYOUT FÜR BILD/KARTENBEREICH
		for(int i=0; i<12; i++)						//BILDLABELS DEM PANEL HINZUFÜGEN
		{
			picPnl.add(bilder[i]);
		}
		
		gameText.setPreferredSize(new Dimension(725,175) );
		gameText.setBackground(Color.BLACK);
		gameText.setForeground(Color.GREEN);
		Font font = new Font("Lucida Console",Font.CENTER_BASELINE, 12);
		gameText.setFont(font);
		gameText.setOpaque(true);
		gameText.setFont(gameText.getFont().deriveFont(13f));		
		
		input.setPreferredSize(new Dimension(725, 20));
				
		gamePnl.add(picPnl);
		gamePnl.add(gameText);
		gamePnl.add(input, BorderLayout.SOUTH);

		/*
		 * ITEMPANEL BEFÜLLEN
		 */
		
		noItem.setImage(noItem.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));	//BILDGRÖßE ANPASSEN
		itemBtn1 = new JButton(noItem);			
		itemBtn1.setBackground(Color.BLACK);
		itemBtn2 = new JButton(noItem);		
		itemBtn2.setBackground(Color.BLACK);
		itemBtn3 = new JButton(noItem);
		itemBtn3.setBackground(Color.BLACK);
		
		Box box = Box.createVerticalBox();														//BOXLAYOUT FÜR ITEMANZEIGE
		box.add(Box.createVerticalStrut(30));
		box.add(itemBtn1);
		box.add(Box.createVerticalStrut(40));
		box.add(itemBtn2);
		box.add(Box.createVerticalStrut(40));
		box.add(itemBtn3);
		itemPnl.add(box);
		
		/*
    	 * MENÜPANEL BEFÜLLEN
    	 */
    	
    	this.minutes = minutes;
		minutes.setText("00");
    	this.seconds = seconds;
		seconds.setText("00");		
		
		timePnl.add(timeLbl);
		timePnl.add(minutes);
		timePnl.add(timeDots);
		timePnl.add(seconds);		
	
		menuPnl.add(saveBtn);
		menuPnl.add(Box.createHorizontalStrut(645));
		menuPnl.add(timePnl);
		
		/*
		 * FENSTER BEFÜLLEN
		 */
		
		add(itemPnl, BorderLayout.WEST);
		add(gamePnl, BorderLayout.CENTER);
		add(menuPnl, BorderLayout.SOUTH);
		
	}

	/*
	 * GETTER UND SETTER METHODEN
	 */
	
	public void setMap(int i, ImageIcon bild) {
		this.bilder[i].setIcon(bild);
	}
	
	public int getMinutes(){
		return Integer.parseInt(minutes.getText());
	}
	
	public void setMinutes(int minutes){
		if(String.valueOf(minutes).length() == 1)
		{
			this.minutes.setText(String.valueOf("0"+minutes));
		} 
		else this.minutes.setText(String.valueOf(minutes));
	}
	
	public int getSeconds(){
		return Integer.parseInt(seconds.getText());
	}
	
	public void setSeconds(int seconds){
		if(String.valueOf(seconds).length() == 1)
		{
			this.seconds.setText(String.valueOf("0"+seconds));
		}
		else this.seconds.setText(String.valueOf(seconds));
	}

	public JButton getSaveBtn(){
		return saveBtn;
	}
	
	public String getInput(){
		return input.getText();
	}
	
	public void setInput(String input){
		this.input.setText(input);
	}
	
	public void setGameText(String text){
		this.gameText.setText(text);
	}
	
	public JLabel getGameText() {
		return gameText;
	}
	
	public TextField getInputField(){
		return input;
	}
	
	public JButton getItemBtn1(){
		return itemBtn1;
	}
	
	public JButton getItemBtn2(){
		return itemBtn2;
	}
	
	public JButton getItemBtn3(){
		return itemBtn3;
	}
	
	public static String convertToMultiline(String orig)			//METHODE UM IN LABELS MEHRZEILIG ZU SCHREIBEN
	{
	    return "<html>" + orig.replaceAll("\n", "<br>");
	}
}

