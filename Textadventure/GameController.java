package Textadventure;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentListener;

public class GameController {

	private menuView menu;
	private GameView gameView;
	private scoreView score;
	private GameNavi navi = null;
	private SchereSteinPapier ssp;
	private TicTacToe ttt;
	private Sudoku sudoku;
	private Saves saves;
	
	private int minutes, seconds;
	private String name;
	private boolean fire, sudokuHelp, key;
	private boolean[] maps;
	private int help;
	
	private Timer miniCheck;
	private Timer timer;
	File savegame = new File("savegame.txt");
	
	boolean gameWait, sudokuWon, sspWon, tttWon;
	
	public GameController(menuView menu, SchereSteinPapier ssp, TicTacToe ttt, Sudoku sudoku){
		
		
		this.gameWait = false;
		
		ImageIcon sudokuHelpIcon = new ImageIcon("src/Textadventure/sudokuHelp.jpg");
		ImageIcon fireIcon = new ImageIcon("src/Textadventure/fire.jpg");
		ImageIcon sspIcon = new ImageIcon("src/Textadventure/ssp.jpg");
		ImageIcon keyIcon = new ImageIcon("src/Textadventure/key.jpg");
		sudokuHelpIcon.setImage(sudokuHelpIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		fireIcon.setImage(fireIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		sspIcon.setImage(sspIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		keyIcon.setImage(keyIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		ImageIcon[] mapFilesA = new ImageIcon[12];
		ImageIcon[] mapFilesB = new ImageIcon[12];
		
		for(int i=0; i<12;i++){
			mapFilesA[i] = new ImageIcon("src/Textadventure/maps/m"+i+"A.jpg");
			mapFilesA[i].setImage(mapFilesA[i].getImage().getScaledInstance(130, 100, Image.SCALE_DEFAULT));
			mapFilesB[i] = new ImageIcon("src/Textadventure/maps/m"+i+"B.jpg");
			mapFilesB[i].setImage(mapFilesB[i].getImage().getScaledInstance(130, 100, Image.SCALE_DEFAULT));
		}
				
		this.menu = menu;
		setupMenuView();
		
		this.maps = new boolean[12];
			for(int i=0; i<12; i++){
				maps[i] = false;
			}
		this.fire 		= false;
		this.sudokuHelp = false;
		
		/*
		 *  TIMER FÜR DIE SPIELZEIT (SCORE)
		 */
		timer = new Timer(1000, null);
		timer.addActionListener(e->{
			if(seconds < 59){
				seconds++;
				gameView.setSeconds(seconds);
			} else {
				seconds = 00;
				minutes++;
				gameView.setSeconds(seconds);
				gameView.setMinutes(minutes);
			}
		});
		
		/*
		 * TIMER FÜR SPIELSTARTCHECKS
		 */
		
		miniCheck = new Timer(500,null);
		miniCheck.addActionListener(e->{
			
			try{
				for(int i=0; i<12; i++){
					if(maps[i]) gameView.setMap(i, mapFilesA[i]);
				}
				if(maps[7]) gameView.setMap(6, mapFilesA[6]);
				
				if(navi.getPos().equals("l1A")){											//MAP POSITION AKTUALISIEREN
					maps[0]=true;
					gameView.setMap(0, mapFilesB[0]);
				}
				else if(navi.getPos().equals("l2A")){							
					maps[1]=true;
					gameView.setMap(1, mapFilesB[1]);
				}
				else if(navi.getPos().equals("l4A")){							
					maps[2]=true;
					gameView.setMap(2, mapFilesB[2]);
				}
				else if(navi.getPos().equals("l3A")){							
					maps[3]=true;
					gameView.setMap(3, mapFilesB[3]);
				}
				else if(navi.getPos().equals("f1")){							
					maps[4]=true;
					gameView.setMap(4, mapFilesB[4]);
				}
				else if(navi.getPos().equals("f2")){							
					maps[5]=true;
					gameView.setMap(5, mapFilesB[5]);
				}
				else if(navi.getPos().equals("f3")){							
					maps[7]=true;
					gameView.setMap(7, mapFilesB[7]);
				}
				else if(navi.getPos().equals("r1A")){							
					maps[8]=true;
					gameView.setMap(8, mapFilesB[8]);
				}
				else if(navi.getPos().equals("r2A")){							
					maps[9]=true;
					gameView.setMap(9, mapFilesB[9]);
				}
				else if(navi.getPos().equals("r4A")){							
					maps[10]=true;
					gameView.setMap(10, mapFilesB[10]);
				}
				else if(navi.getPos().equals("r3A")){							
					maps[11]=true;
					gameView.setMap(11, mapFilesB[11]);
				}
				
				if(navi.getInput().equals("ok")) timer.start();
				
				if(gameView.getGameText().getText().contains(navi.versteckText)){		//SUDOKU HILFE GEFUNDEN
					sudokuHelp = true;
					navi.sudokuHelp = true;
					gameView.getItemBtn1().setIcon(sudokuHelpIcon);
				}
				
				if(navi.sudokuHelp == true) gameView.getItemBtn1().setIcon(sudokuHelpIcon);
				
				if(navi.key == true)gameView.getItemBtn2().setIcon(keyIcon);
				
				if(navi.ssp == true)gameView.getItemBtn3().setIcon(sspIcon);
				
				if(navi.fire == true) gameView.getItemBtn1().setIcon(fireIcon);
				
				if(navi.getPos().equals("l1A")){										//SUDOKU STARTEN AM SAFE
					if(navi.getInput().equals("safe")){
						if(!gameWait){
							if(!sudokuWon){
								gameWait = true;
								this.sudoku = new Sudoku();
								this.sudoku.sudokuShow();
								this.sudoku.getExitBtn().addActionListener(ac->{
									if(this.sudoku.sudokuWin()) {
										sudokuWon = true;
										navi.sudokuWon = true;
										this.key = true;
									}
									gameWait = false;
									navi.setPos("l1A");
									if(sudokuWon) navi.setInput("safe");
									else navi.setInput("");
									navi.play(navi.getPos());
								});
								
							}
						}
					}
				}
				else if(navi.getPos().equals("l4A")){									//SCHERE STEIN PAPIER STARTEN
					if(navi.getInput().equals("cornwall")){
						if(!sspWon){
							if(!gameWait){
								if(navi.ssp){
									gameWait = true;
									this.ssp = new SchereSteinPapier();
									this.ssp.sspShow();
								}
							}
							else if(gameWait){
								if(this.ssp.sspWin()){
									sspWon = true;
									navi.sspWon = true;
									navi.setInput("cornwall");
									this.ssp.dispose();
									navi.play(navi.getPos());
									gameWait = false;
								}
							}
						}
						
					}
				}
				else if(navi.getPos().equals("l2B")){									//TIC TAC TOE STARTEN
					if(navi.getInput().equals("dynamit")){
						if(!tttWon){
							if(!gameWait){
								gameWait = true;
								this.ttt = new TicTacToe();
									this.ttt.tttShow();
							}
							else if(gameWait){
								if(this.ttt.tttWin()){
									tttWon = true;
									this.ttt.dispose();
									gameView.setGameText(navi.convertToMultiline("Du entfachst dein Feuerzeug und führst es an das Ende der Zündschnur. Sie entflammt sofort und das Feuer rast der riesigen Maschinerie entgegen.\n3...\n2...\n1...\n"));
									navi.isRunning = false;
									navi.isRunning = false;
									timer.stop();
									score = new scoreView();
									score.addElement(seconds, minutes, name);
									miniCheck.stop();
								}
							}
						}
					}
				}
				}catch(NullPointerException exception){}	
			miniCheck.start();
		});
		
		
		miniCheck.start();		
	}
	
	public void setupGameView(){
		gameView.getSaveBtn().addActionListener(e->{				//SAFE BUTTON
			this.saves = new Saves(navi.key, navi.fire, navi.ssp, sudokuHelp, navi.getPos(), maps, help, minutes, seconds, name);
			try(FileOutputStream fos = new FileOutputStream(savegame);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(saves);
				oos.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			gameView.dispose();
			this.menu = new menuView();
			setupMenuView();
		});		
	}
	
	public void setupMenuView(){
				
		menu.getNewGameBtn().addActionListener(e->{
			menu.dispose();
			gameView = new GameView();
			this.navi = new GameNavi(gameView);
			setupGameView();
			Random r = new Random();
			this.help = r.nextInt(7)+1;
			navi.help = this.help;
			this.name = JOptionPane.showInputDialog(null, 
					"Bitte gib deinen Namen ein:");
			navi.setPos("start");
			navi.play("");
			navi.setupAction();
			navi.hideHelp();
		});
		
		menu.getContBtn().addActionListener(e->{
			menu.dispose();
			gameView = new GameView();
			try(FileInputStream fis = new FileInputStream(savegame);
					ObjectInputStream ois = new ObjectInputStream(fis)){
				Object object = ois.readObject();
				if(object instanceof Saves)
				{
					this.navi = new GameNavi(gameView);
					navi.key = ((Saves) object).key;
					navi.ssp = ((Saves) object).ssp;
					navi.fire = ((Saves) object).fire;
					sudokuHelp = ((Saves) object).sudokuHelp;
					navi.setPos(((Saves) object).pos);
					name = ((Saves) object).name;
					minutes = ((Saves) object).minutes;
					seconds = ((Saves) object).seconds;
					maps = ((Saves) object).maps;
					navi.help = ((Saves) object).help;
					help = ((Saves) object).help;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			navi.hideHelp();
			setupGameView();
			navi.setText();
			navi.setupAction();
			timer.start();
		});
		
		menu.getScoreBtn().addActionListener(e->{
			score = new scoreView();
			score.showElements();
		});
		
	}
	
}
