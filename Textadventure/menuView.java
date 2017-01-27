package Textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menuView extends JFrame{
	
	JButton contGameBtn, newGameBtn, scoreBtn;
	
	public menuView(){
		
		/*
		 * EINLEITUNGS DIALOGFENSTER
		 */
			
		
		
		Font font = new Font("Lucida Console",Font.CENTER_BASELINE, 13);
		String introStr = "Jahr 2048\n\nDu bist Teil einer Organisation die gegen \nein globales Unternehmen arbeitet. Dieses Unternehmen namens"
				+ "\"MediTech\" hat das Gesundheitswesen mit seiner \nErfindung dem \"MediChip\" revolutioniert."
				+ "\n\nJedoch sind sie dabei ohne Rücksicht auf Verluste vorgegangen und es heißt, dass viele ihrer sogenannten \"Kunden\" "
				+ "nach Einsatz des MediChips von der Bildfläche verschwunden sind.\n\nDu wurdest mit der Aufgabe betraut MediTech von innen heraus endgültig zu zerstören,"
				+ "um weitere Opfer zu verhindern."
				+ "Nach wochenlanger Arbeit ist es dir gelungen die äußeresten Abwehrsysteme der Hauptserver MediTechs zu durchdringen."
				+ "\n\nDu befindest dich jetzt als virtueller Eindringling in dem sogenannten \"Datenbunker\". Deine gesamte Umbgebung spiegelt "
				+ "die Inhalte gespeicherter Daten wider. Personen sind nur die Daten, die über sie existieren."
				+ "\n\nDein Ziel ist es den zentralen Speicher mit Hilfe eines einsatzbereiten Virus zu zerstören."
				+ "Verschaffe dir Zugang zum Kern des Datenbunkers und setze den Virus frei.";
		JLabel introText = new JLabel(convertToMultiline("<html><div style='text-align: center;'>" + introStr + "</div></html>"));
		introText.setOpaque(true);
		introText.setBackground(Color.BLACK);
		introText.setForeground(Color.GREEN);
		introText.setFont(font);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.BLACK);
		newGameBtn   = new JButton("Neues Spiel");
		contGameBtn  = new JButton ("Weiterspielen");
		scoreBtn = new JButton("Highscore");
		btnPnl.add(contGameBtn);
		btnPnl.add(newGameBtn);
		btnPnl.add(scoreBtn);
		
		JPanel spacePnl = new JPanel();
		spacePnl.setBackground(Color.BLACK);
		spacePnl.add(Box.createHorizontalStrut(20));
		
		add(spacePnl,BorderLayout.WEST);
		add(introText);
		add(btnPnl, BorderLayout.SOUTH);
		
				
		setSize(500,500);
		setLocation(400,50);
		setVisible(true);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JButton getContBtn(){
		return contGameBtn;
	}
	
	public JButton getNewGameBtn() {
		return newGameBtn;
	}
	
	public JButton getScoreBtn() {
		return scoreBtn;
	}
	
	public static String convertToMultiline(String orig)			//METHODE UM IN LABELS MEHRZEILIG ZU SCHREIBEN
	{
	    return "<html>" + orig.replaceAll("\n", "<br>");
	}

}
