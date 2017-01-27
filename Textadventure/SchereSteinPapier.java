package Textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SchereSteinPapier extends JFrame{

	private JDialog SSPDlg;
	private String playerAction,npcAction;

	private JLabel anweisungLbl,punkteLbl, actionP,actionNPC, actionDots;
	private JButton schereBtn, steinBtn, papierBtn, restartBtn;
	
	private boolean sspWin;
	private int playerPoints, npcPoints;
	
	
	public SchereSteinPapier(){
		
		schereBtn  = new JButton();
		steinBtn   = new JButton();
		papierBtn  = new JButton();
		restartBtn = new JButton("Neu");
		sspWin = false;
		
		schereBtn.addActionListener(e->{
			playerAction = "Schere";
			play();
		});
		
		steinBtn.addActionListener(e->{
			playerAction = "Stein";
			play();
		});
		
		papierBtn.addActionListener(e->{
			playerAction = "Papier";
			play();
		});
		
		restartBtn.addActionListener(e->{
			this.playerPoints = 0;
			this.npcPoints = 0;
			setPoints(playerPoints, npcPoints);
			actionDots.setText(" : ");
			actionP.setText("");
			actionNPC.setText("");
		});
	}
	
	public void sspShow() {
		this.SSPDlg = new JDialog();
		this.SSPDlg.setAlwaysOnTop(true);
		this.SSPDlg.setVisible(true);
		this.SSPDlg.setSize(400,250);
		this.SSPDlg.setLayout(new BorderLayout());
		this.SSPDlg.setBackground(new Color(130,210,245));
		
		anweisungLbl = new JLabel("Wähle deine Waffe!",JLabel.CENTER);
		anweisungLbl.setPreferredSize(new Dimension(400,50));
		
		ImageIcon schereIcon = new ImageIcon("src/Textadventure/schere.jpg");
		ImageIcon steinIcon = new ImageIcon("src/Textadventure/stein.jpg");
		ImageIcon papierIcon = new ImageIcon("src/Textadventure/papier.jpg");
		schereIcon.setImage(schereIcon.getImage().getScaledInstance(130, 70, Image.SCALE_DEFAULT));
		steinIcon.setImage(steinIcon.getImage().getScaledInstance(130, 70, Image.SCALE_DEFAULT));
		papierIcon.setImage(papierIcon.getImage().getScaledInstance(130, 70, Image.SCALE_DEFAULT));
		schereBtn.setIcon(schereIcon);
		steinBtn.setIcon(steinIcon);
		papierBtn.setIcon(papierIcon);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new GridLayout(1,3));
		
		btnPnl.add(schereBtn);
		btnPnl.add(steinBtn);
		btnPnl.add(papierBtn);
		
		JPanel actionPnl = new JPanel();
		actionPnl.setLayout(new BorderLayout());						//ÜBERPANEL
		JPanel actionPnl2 = new JPanel();								//UNTERPANEL FÜR AKTIONSZEILE
		actionPnl2.setPreferredSize(new Dimension(380,80));						
		JPanel actionPnl3 = new JPanel();
		
		JLabel action1 = new JLabel("Du");								//NAMEN
		action1.setFont(action1.getFont().deriveFont(20f));
		JLabel action2 = new JLabel("Cornwall");
		action2.setFont(action2.getFont().deriveFont(20f));
		
		JPanel mPnl = new JPanel();
		actionDots = new JLabel(" : ");
		actionDots.setFont(actionDots.getFont().deriveFont(20f));
		
		actionP = new JLabel();
		actionP.setFont(actionP.getFont().deriveFont(20f));
		actionNPC = new JLabel();
		actionNPC.setFont(actionNPC.getFont().deriveFont(20f));
		mPnl.add(Box.createVerticalStrut(72));
		mPnl.add(actionP);
		mPnl.add(actionDots);
		mPnl.add(actionNPC);
		
		actionPnl2.setLayout(new BorderLayout());
		actionPnl2.add(action1, BorderLayout.WEST);
		actionPnl2.add(mPnl,BorderLayout.CENTER);
		actionPnl2.add(action2, BorderLayout.EAST);
		
		punkteLbl = new JLabel("Du 0:0 Cornwall",JLabel.CENTER);
		punkteLbl.setFont(punkteLbl.getFont().deriveFont(15f));
		
		actionPnl3.add(punkteLbl);
		actionPnl3.add(Box.createHorizontalStrut(50));
		actionPnl3.add(restartBtn, BorderLayout.EAST);
		
		actionPnl.add(actionPnl2, BorderLayout.CENTER);
		actionPnl.add(actionPnl3, BorderLayout.SOUTH);
		
		
		this.SSPDlg.add(anweisungLbl,BorderLayout.NORTH);
		this.SSPDlg.add(btnPnl,BorderLayout.CENTER);
		this.SSPDlg.add(actionPnl, BorderLayout.SOUTH);
		
		this.playerPoints = 0;
		this.npcPoints = 0;
	}
	
	public void play(){
				
		Random ran = new Random();
		int npc;
		
		npc = ran.nextInt(3);
							
			if	   (npc == 0) npcAction = "Schere";
			else if(npc == 1) npcAction = "Stein";
			else 		 	  npcAction = "Papier";
			
			this.setText(playerAction, npcAction);
			
			if(playerAction.equals("Schere")){
				if(npcAction.equals("Stein")) npcPoints++;
				else if(npcAction.equals("Papier")) playerPoints++;
			}
			else if(playerAction.equals("Stein")){
				if(npcAction.equals("Papier")) npcPoints++;
				else if(npcAction.equals("Schere")) playerPoints++;
			}
			else{
				if(npcAction.equals("Schere")) npcPoints++;
				else if(npcAction.equals("Stein")) playerPoints++;
			}
			
			this.setPoints(playerPoints, npcPoints);
			
			winCheck();	
	}
	
	public void winCheck(){
		
		if(npcPoints == 5) {
			actionP.setText("");
			actionNPC.setText("");
			actionDots.setText("Verloren!");
		}
		else if(playerPoints == 5) {
			actionP.setText("");
			actionNPC.setText("");
			actionDots.setText("Gewonnen");
			sspWin = true;
		}
	}
	
	public boolean sspWin(){
		return sspWin;
	}
	
	public void setText(String player, String npc){
		actionP.setText(player);
		actionNPC.setText(npc);
	}
	
	public void setPoints(int player, int npc){
		punkteLbl.setText("Du "+player+" : "+npc+" Cornwall");
	}
}
