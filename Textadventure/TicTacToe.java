package Textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TicTacToe extends JFrame{

	private JDialog tttDlg;	
	private JButton quitBtn, restartBtn;
	private JButton[] XOButtons = new JButton[9];
	
	private int[] check = new int[9];				//Kontrollvariable 0=leer 1=cpu 2=player
	private int waitInt;
	private Timer timer;
	private boolean isRunning;
	private boolean tttWin;
	
	private ImageIcon blank = new ImageIcon("src/Textadventure/blank.png");		//BILDDATEI (LEER) LADEN
	ImageIcon circle = new ImageIcon("src/Textadventure/circle.jpg");		//BILDDATEI (KREIS) LADEN

	
	public TicTacToe(){
		
		/*
		 *  VORBEREITUNG
		 */
		
		ImageIcon cross = new ImageIcon("src/Textadventure/cross.jpg");		//BILDDATEI (KREUZ) LADEN
		
		isRunning = true;
		quitBtn = new JButton("Aufgeben");									//AUFGEBEN BUTTON
		restartBtn = new JButton("Neu");									//NEU BUTTON
		
		for(int i=0; i<9; i++){												
			JButton btn = new JButton(blank);								//ALLE SPIELFELD-BUTTONS LEER MACHEN
			XOButtons[i] = btn;
			check[i] = 0;													//ALLE SPIELFELDVARIABLEN AUF 0 SETZEN
		}	
		
		/*
		 *  ACTIONLISTENER
		 */
		
		quitBtn.addActionListener(e->{										//AKTION AUFGEBEN-BUTTON:
			this.tttDlg.dispose();											// FENSTER SCHLIEßEN
			for(int i=0; i<9; i++){											//	
				XOButtons[i].setIcon(blank);								// ALLE SPIELFELD-BUTTONS LEER MACHEN
				check[i] = 0;												// ALLE SPIELFELDVARIABLEN AUF 0 SETZEN
			}
		});
		
		restartBtn.addActionListener(e->{									//AKTION NEU-BUTTON:
			for(int i=0; i<9; i++){											//
				XOButtons[i].setIcon(blank);								// ALLE SPIELFELD-BUTTONS LEER MACHEN
				check[i] = 0;												// ALLE SPIELFELDVARIABLEN AUF 0 SETZEN
			}
			isRunning = true;
			
		});
		
		XOButtons[0].addActionListener(e->{									//BUTTON OBEN LINKS
			XOButtons[0].setIcon(cross);
			check[0] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[1].addActionListener(e->{									//BUTTON OBEN MITTE
			XOButtons[1].setIcon(cross);
			check[1] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[2].addActionListener(e->{									//BUTTON OBEN RECHTS
			XOButtons[2].setIcon(cross);
			check[2] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[3].addActionListener(e->{									//BUTTON MITTE LINKS
			XOButtons[3].setIcon(cross);
			check[3] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[4].addActionListener(e->{									//BUTTON MITTE
			XOButtons[4].setIcon(cross);
			check[4] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[5].addActionListener(e->{									//BUTTON MITTE RECHTS
			XOButtons[5].setIcon(cross);
			check[5] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[6].addActionListener(e->{									//BUTTON UNTEN LINKS
			XOButtons[6].setIcon(cross);
			check[6] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		XOButtons[7].addActionListener(e->{									//BUTTON UNTEN MITTE
			XOButtons[7].setIcon(cross);
			check[7] = 2;
			if(isRunning()){
				cpuAct();
			}
			
		});
		
		XOButtons[8].addActionListener(e->{									//BUTTON UNTEN RECHTS
			XOButtons[8].setIcon(cross);
			check[8] = 2;
			if(isRunning()){
				cpuAct();
			}
		});
		
		
	}
	
	public boolean isRunning(){
		int countFull =0;
		for(int i=0; i<9; i++){
			if(check[i] != 0) countFull++; 
		}
		
		if(check[0]==2 && check[1]==2 && check[2]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[3]==2 && check[4]==2 && check[5]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[6]==2 && check[7]==2 && check[8]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[0]==2 && check[3]==2 && check[6]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[1]==2 && check[4]==2 && check[7]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[2]==2 && check[5]==2 && check[8]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[0]==2 && check[4]==2 && check[8]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(check[2]==2 && check[4]==2 && check[6]==2){
			win();
			tttWin = true;
			isRunning = false;
		}
		else if(countFull == 9){
			draw();
			isRunning=false;
					 
		}
		return isRunning;
	}
	
	public boolean tttWin(){
		return tttWin;
	}
	
	public void draw(){
		
		timer = new Timer(500, listener->{
			if(waitInt == 1){
				ImageIcon draw1 = new ImageIcon("src/Textadventure/draw1.jpg");		//BILDDATEI (Unentschieden!) LADEN
				ImageIcon draw2 = new ImageIcon("src/Textadventure/draw2.jpg");
				ImageIcon draw3 = new ImageIcon("src/Textadventure/draw3.jpg");
				draw1.setImage(draw1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				draw2.setImage(draw2.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				draw3.setImage(draw3.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				XOButtons[3].setIcon(draw1);
				XOButtons[4].setIcon(draw2);
				XOButtons[5].setIcon(draw3);
				waitInt = 0;
				timer.stop();
			}
			waitInt++;
		});
		timer.start();
	}
	
	public void win(){
		timer = new Timer(500, listener->{
			if(waitInt == 1){
				ImageIcon win1 = new ImageIcon("src/Textadventure/win1.jpg");		//BILDDATEI (Gewonnen!) LADEN
				ImageIcon win2 = new ImageIcon("src/Textadventure/win2.jpg");
				ImageIcon win3 = new ImageIcon("src/Textadventure/win3.jpg");
				win1.setImage(win1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				win2.setImage(win2.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				win3.setImage(win3.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				XOButtons[3].setIcon(win1);
				XOButtons[4].setIcon(win2);
				XOButtons[5].setIcon(win3);
				waitInt = 0;
				timer.stop();
				this.dispose();
			}
			waitInt++;	
		});
		
		timer.start();
	}
	
	public void lost(){
		
		timer = new Timer(500, listener->{
			if(waitInt == 1){
				ImageIcon lost1 = new ImageIcon("src/Textadventure/lost1.jpg");		//BILDDATEI (Verloren!) LADEN
				ImageIcon lost2 = new ImageIcon("src/Textadventure/lost2.jpg");
				ImageIcon lost3 = new ImageIcon("src/Textadventure/lost3.jpg");
				lost1.setImage(lost1.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				lost2.setImage(lost2.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				lost3.setImage(lost3.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
				XOButtons[3].setIcon(lost1);
				XOButtons[4].setIcon(lost2);
				XOButtons[5].setIcon(lost3);
				waitInt = 0;
				timer.stop();
			}
			waitInt++;	
		});	
		
		timer.start();
	}
	
	public void cpuAct(){
		circle.setImage(circle.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
		/*
		 * EIGENSIEHT VERSUCHEN
		 */
		if(check[0]==1 && check[1]==1 && check[2]==0){											//REIHE OBEN
			XOButtons[2].setIcon(circle);
			check[2]=1;
			this.lost();
		}
		else if(check[0]==1 && check[2]==1 && check[1]==0){											
			XOButtons[1].setIcon(circle);
			check[1]=1;
			this.lost();
		}
		else if(check[1]==1 && check[2]==1 && check[0]==0){											
			XOButtons[0].setIcon(circle);
			check[0]=1;
			this.lost();
		}
		
		else if(check[3]==1 && check[4]==1 && check[5]==0){											//REIHE MITTE		
			XOButtons[5].setIcon(circle);
			check[5]=1;
			this.lost();
		}
		else if(check[3]==1 && check[5]==1 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
			this.lost();
		}
		else if(check[4]==1 && check[5]==1 && check[3]==0){											
			XOButtons[3].setIcon(circle);
			check[3]=1;
			this.lost();
		}
		
		else if(check[6]==1 && check[7]==1 && check[8]==0){											//REIHE UNTEN	
			XOButtons[8].setIcon(circle);
			check[8]=1;
			this.lost();
		}
		else if(check[6]==1 && check[8]==1 && check[7]==0){											
			XOButtons[7].setIcon(circle);
			check[7]=1;
			this.lost();
		}
		else if(check[7]==1 && check[8]==1 && check[6]==0){											
			XOButtons[6].setIcon(circle);
			check[6]=1;
			this.lost();
		}
		
		else if(check[0]==1 && check[3]==1 && check[6]==0){											//SPALTE LINKS								
			XOButtons[6].setIcon(circle);
			check[6]=1;
			this.lost();
		}
		else if(check[0]==1 && check[6]==1 && check[3]==0){											
			XOButtons[3].setIcon(circle);
			check[3]=1;
			this.lost();
		}
		else if(check[3]==1 && check[6]==1 && check[0]==0){											
			XOButtons[0].setIcon(circle);
			check[0]=1;
			this.lost();
		}
		
		else if(check[1]==1 && check[4]==1 && check[7]==0){										//SPALTE MITTE				
			XOButtons[7].setIcon(circle);
			check[7]=1;
			this.lost();
		}
		else if(check[1]==1 && check[7]==1 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
			this.lost();
		}
		else if(check[4]==1 && check[7]==1 && check[1]==0){											
			XOButtons[1].setIcon(circle);
			check[1]=1;
			this.lost();
		}
		
		else if(check[2]==1 && check[5]==1 && check[8]==0){										//SPALTE RECHTS					
			XOButtons[8].setIcon(circle);
			check[8]=1;
			this.lost();
		}
		else if(check[2]==1 && check[8]==1 && check[5]==0){											
			XOButtons[5].setIcon(circle);
			check[5]=1;
			this.lost();
		}
		else if(check[5]==1 && check[8]==1 && check[2]==0){											
			XOButtons[2].setIcon(circle);
			check[2]=1;
			this.lost();
		}
		
		else if(check[0]==1 && check[4]==1 && check[8]==0){										//DIAGONALE LO-RU	
			XOButtons[8].setIcon(circle);
			check[8]=1;
			this.lost();
		}
		else if(check[0]==1 && check[8]==1 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
			this.lost();
		}
		else if(check[4]==1 && check[8]==1 && check[0]==0){											
			XOButtons[0].setIcon(circle);
			check[0]=1;
			this.lost();
		}
		
		else if(check[2]==1 && check[4]==1 && check[6]==0){										//DIAGONALE LU-RO				
			XOButtons[6].setIcon(circle);
			check[6]=1;
			this.lost();
		}
		else if(check[2]==1 && check[6]==1 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
			this.lost();
		}
		else if(check[4]==1 && check[6]==1 && check[2]==0){											
			XOButtons[2].setIcon(circle);
			check[2]=1;
			this.lost();
		}
		
		/*
		 *  GEGNERSIEG VERHINDERN
		 */
		
		else if(check[0]==2 && check[1]==2 && check[2]==0){											//REIHE OBEN
				XOButtons[2].setIcon(circle);
				check[2]=1;
			}
		else if(check[0]==2 && check[2]==2 && check[1]==0){											
			XOButtons[1].setIcon(circle);
			check[1]=1;
		}
		else if(check[1]==2 && check[2]==2 && check[0]==0){											
			XOButtons[0].setIcon(circle);
			check[0]=1;
		}
		
		else if(check[3]==2 && check[4]==2 && check[5]==0){											//REIHE MITTE		
			XOButtons[5].setIcon(circle);
			check[5]=1;
		}
		else if(check[3]==2 && check[5]==2 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
		}
		else if(check[4]==2 && check[5]==2 && check[3]==0){											
			XOButtons[3].setIcon(circle);
			check[3]=1;
		}
		
		else if(check[6]==2 && check[7]==2 && check[8]==0){											//REIHE UNTEN	
			XOButtons[8].setIcon(circle);
			check[8]=1;
		}
		else if(check[6]==2 && check[8]==2 && check[7]==0){											
			XOButtons[7].setIcon(circle);
			check[7]=1;
		}
		else if(check[7]==2 && check[8]==2 && check[6]==0){											
			XOButtons[6].setIcon(circle);
			check[6]=1;
		}
		
		else if(check[0]==2 && check[3]==2 && check[6]==0){											//SPALTE LINKS								
			XOButtons[6].setIcon(circle);
			check[6]=1;
		}
		else if(check[0]==2 && check[6]==2 && check[3]==0){											
			XOButtons[3].setIcon(circle);
			check[3]=1;
		}
		else if(check[3]==2 && check[6]==2 && check[0]==0){											
			XOButtons[0].setIcon(circle);
			check[0]=1;
		}
		
		else if(check[1]==2 && check[4]==2 && check[7]==0){										//SPALTE MITTE				
			XOButtons[7].setIcon(circle);
			check[7]=1;
		}
		else if(check[1]==2 && check[7]==2 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
		}
		else if(check[4]==2 && check[7]==2 && check[1]==0){											
			XOButtons[1].setIcon(circle);
			check[1]=1;
		}
		
		else if(check[2]==2 && check[5]==2 && check[8]==0){										//SPALTE RECHTS					
			XOButtons[8].setIcon(circle);
			check[8]=1;
		}
		else if(check[2]==2 && check[8]==2 && check[5]==0){											
			XOButtons[5].setIcon(circle);
			check[5]=1;
		}
		else if(check[5]==2 && check[8]==2 && check[2]==0){											
			XOButtons[2].setIcon(circle);
			check[2]=1;
		}
		
		else if(check[0]==2 && check[4]==2 && check[8]==0){										//DIAGONALE LO-RU	
			XOButtons[8].setIcon(circle);
			check[8]=1;
		}
		else if(check[0]==2 && check[8]==2 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
		}
		else if(check[4]==2 && check[8]==2 && check[0]==0){											
			XOButtons[0].setIcon(circle);
			check[0]=1;
		}
		
		else if(check[2]==2 && check[4]==2 && check[6]==0){										//DIAGONALE LU-RO				
			XOButtons[6].setIcon(circle);
			check[6]=1;
		}
		else if(check[2]==2 && check[6]==2 && check[4]==0){											
			XOButtons[4].setIcon(circle);
			check[4]=1;
		}
		else if(check[4]==2 && check[6]==2 && check[2]==0){											
			XOButtons[2].setIcon(circle);
			check[2]=1;
		}
		else cpuRandom();
		
		this.isRunning();
	}
	
	public void cpuRandom(){
		Random random = new Random();
		int r = random.nextInt(9);					//RANDOM NUMMER VON 0-8 
		
		while(check[r] != 0){						//WENN DIESES FELD SCHON BELEGT IST SOLANGE NEUE RANDOM NUMMER ERZEUGEN
			r = random.nextInt(9);					//BIS EIN FREIES FELD GETROFFEN WIRD
		}
													//WENN FREIES FELD GEFUNDEN
		XOButtons[r].setIcon(circle);			  	//BUTTON ALS KREIS MARKIEREN
		check[r] = 1;								//CHECK AUF CPU SETZEN
	}
	
	public void tttShow(){
		
		this.tttDlg = new JDialog();	
		this.tttDlg.setBackground(Color.BLUE);
		this.tttDlg.setAlwaysOnTop(true);		
		this.tttDlg.setSize(350,350);
		this.tttDlg.setLocation(325,125);
		this.tttDlg.setVisible(true);
		this.tttDlg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
		blank.setImage(blank.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));		//BILDGRÖßE ANPASSEN
		
		JPanel gridPnl = new JPanel();
		gridPnl.setBackground(Color.BLACK);
		gridPnl.setLayout(new GridLayout(3,3));
		
		for(int i=0; i<9; i++){
			gridPnl.add(XOButtons[i]);
		}		
		
		JPanel bottomPnl = new JPanel();
		bottomPnl.add(restartBtn);
		bottomPnl.add(quitBtn);
		
		tttDlg.add(gridPnl, BorderLayout.CENTER);
		tttDlg.add(bottomPnl, BorderLayout.SOUTH);
		
	}
	
	
}