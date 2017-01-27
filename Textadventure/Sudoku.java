package Textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Sudoku extends JFrame{

	private JTextField[] emptys = new JTextField[21];
	private int[] key = new int[21];
	private JLabel[] filledLbls = new JLabel[60];
	private boolean isRunning;
	private boolean sudokuWin;
	
	private JButton checkBtn, exitBtn;
	
	private JDialog sudokuDlg;
	
	public Sudoku(){
		
		checkBtn = new JButton("Check");
		sudokuWin = false;
		isRunning = false;
		
		checkBtn.addActionListener(e->{
			
			if(!isRunning()){
				
				for(int i=0; i<21; i++){
					emptys[i].setBackground(Color.WHITE);
				}
				filledLbls[22].setText("G");
				filledLbls[22].setBackground(Color.RED);
				filledLbls[23].setText("E");
				filledLbls[23].setBackground(Color.RED);
				emptys[8].setText("W");
				emptys[8].setBackground(Color.RED);
				filledLbls[28].setText("O");
				filledLbls[28].setBackground(Color.RED);
				filledLbls[29].setText("N");
				filledLbls[29].setBackground(Color.RED);
				emptys[11].setText("N");
				emptys[11].setBackground(Color.RED);
				emptys[13].setText("E");
				emptys[13].setBackground(Color.RED);
				filledLbls[35].setText("N");
				filledLbls[35].setBackground(Color.RED);
				filledLbls[36].setText("!");
				filledLbls[36].setBackground(Color.RED);
				
			}
			else {
				for(int i=0; i<21; i++){
				
					try {
						if(key[i] != Integer.parseInt(emptys[i].getText()) ){
							emptys[i].setBackground(Color.RED);
						}
						else emptys[i].setBackground(Color.WHITE);
					
			            }
					catch (NumberFormatException exception) { 
			            	emptys[i].setBackground(Color.RED);
			        }
				}
			}
		});		
	}
	
	public boolean isRunning(){
		int count = 0;
		for(int i=0; i<21; i++){			
			try {
				if(key[i] == Integer.parseInt(emptys[i].getText()) ){
					count++;
				}			
	            }
			catch (NumberFormatException exception) { 
	            	
	        }
		}
		
		if(count==21){
			isRunning = false;
			sudokuWin = true;
		}
		
		return isRunning;
		
	}
	
	public boolean sudokuWin(){
		return sudokuWin;
	}
	
	public void sudokuShow(){
		
		isRunning = true;

		this.sudokuDlg = new JDialog();	
		this.sudokuDlg.setBackground(Color.BLUE);
		this.sudokuDlg.setAlwaysOnTop(true);		
		this.sudokuDlg.setSize(500,500);
		this.sudokuDlg.setLocation(870,125);
		this.sudokuDlg.setVisible(true);
		this.sudokuDlg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		Border border = LineBorder.createGrayLineBorder();
		
		JPanel[] cells = new JPanel[9];
		JPanel gamePnl = new JPanel();
		gamePnl.setLayout(new GridLayout(3,3));
		gamePnl.setOpaque(true);
		
		for(int i=0; i<9; i++){															//QUADRATPANELS
			JPanel pnl = new JPanel();
			cells[i] = pnl;
			cells[i].setOpaque(true);
			cells[i].setBackground(new Color(50,50,50));
			cells[i].setLayout(new GridLayout(3,3));
			cells[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		}
		
		for(int i=0; i<60; i++){														//VORGEFÜLLTE FELDER
			JLabel lbl = new JLabel("0",SwingConstants.CENTER);
			filledLbls[i] = lbl;
			filledLbls[i].setBorder(border);
			filledLbls[i].setOpaque(true);
			filledLbls[i].setFont(new Font(filledLbls[i].getFont().getName(), Font.PLAIN, 28));
		}
		
		for(int i=0; i<21; i++){
			JTextField area = new JTextField();
			emptys[i] = area;
			emptys[i].setBorder(border);
			emptys[i].setHorizontalAlignment(emptys[i].CENTER);
			emptys[i].setFont(new Font(filledLbls[i].getFont().getName(), Font.PLAIN, 28));
		}
		
		filledLbls[0].setText("3");
		filledLbls[1].setText("7");
		filledLbls[2].setText("1");
		filledLbls[3].setText("2");
		filledLbls[4].setText("8");
		filledLbls[5].setText("9");
		filledLbls[6].setText("1");
		filledLbls[7].setText("6");
		filledLbls[8].setText("8");
		filledLbls[9].setText("9");
		filledLbls[10].setText("3");
		filledLbls[11].setText("4");
		filledLbls[12].setText("7");
		filledLbls[13].setText("4");
		filledLbls[14].setText("9");
		filledLbls[15].setText("8");
		filledLbls[16].setText("3");
		filledLbls[17].setText("7");
		filledLbls[18].setText("2");
		filledLbls[19].setText("5");
		filledLbls[20].setText("8");
		filledLbls[21].setText("3");
		filledLbls[22].setText("2");
		filledLbls[23].setText("4");
		filledLbls[24].setText("9");
		filledLbls[25].setText("5");
		filledLbls[26].setText("5");
		filledLbls[27].setText("4");
		filledLbls[28].setText("6");
		filledLbls[29].setText("3");
		filledLbls[30].setText("2");
		filledLbls[31].setText("1");
		filledLbls[32].setText("8");
		filledLbls[33].setText("2");
		filledLbls[34].setText("9");
		filledLbls[35].setText("8");
		filledLbls[36].setText("7");
		filledLbls[37].setText("6");
		filledLbls[38].setText("4");
		filledLbls[39].setText("3");
		filledLbls[40].setText("1");
		filledLbls[41].setText("8");
		filledLbls[42].setText("3");
		filledLbls[43].setText("2");
		filledLbls[44].setText("4");
		filledLbls[45].setText("9");
		filledLbls[46].setText("6");
		filledLbls[47].setText("3");
		filledLbls[48].setText("9");
		filledLbls[49].setText("1");
		filledLbls[50].setText("5");
		filledLbls[51].setText("7");
		filledLbls[52].setText("2");
		filledLbls[53].setText("9");
		filledLbls[54].setText("2");
		filledLbls[55].setText("7");
		filledLbls[56].setText("6");
		filledLbls[57].setText("4");
		filledLbls[58].setText("3");
		filledLbls[59].setText("1");
		
		key[0] = 5;
		key[1] = 4;
		key[2] = 6;
		key[3] = 2;
		key[4] = 5;
		key[5] = 6;
		key[6] = 1;
		key[7] = 6;
		key[8] = 1;
		key[9] = 7;
		key[10] = 7;
		key[11] = 9;
		key[12] = 1;
		key[13] = 5;
		key[14] = 7;
		key[15] = 5;
		key[16] = 6;
		key[17] = 4;
		key[18] = 8;
		key[19] = 5;
		key[20] = 8;
			
		for(int i=0; i<6; i++){
			if(i==0) cells[0].add(emptys[0]);
			if(i==4) cells[0].add(emptys[1]);
			if(i==5) cells[0].add(emptys[2]);
			cells[0].add(filledLbls[i]);
		}
		for(int i=6; i<13; i++){
			if(i==7) cells[1].add(emptys[3]);
			if(i==10) cells[1].add(emptys[4]);
			cells[1].add(filledLbls[i]);
		}
		for(int i=13; i<20; i++){
			if(i==18) {
				cells[2].add(emptys[5]);
				cells[2].add(emptys[6]);
			}
			cells[2].add(filledLbls[i]);
		}
		for(int i=20; i<26; i++){
			if(i==20) cells[3].add(emptys[7]);
			if(i==24) cells[3].add(emptys[8]);
			if(i==25) cells[3].add(emptys[9]);
			cells[3].add(filledLbls[i]);
		}
		for(int i=26; i<33; i++){
			if(i==26) cells[4].add(emptys[10]);
			if(i==30) cells[4].add(emptys[11]);
			cells[4].add(filledLbls[i]);
		}
		for(int i=33; i<40; i++){
			if(i==34) cells[5].add(emptys[12]);
			if(i==35) cells[5].add(emptys[13]);
			cells[5].add(filledLbls[i]);
		}
		for(int i=40; i<46; i++){
			if(i==40) cells[6].add(emptys[14]);
			if(i==43) cells[6].add(emptys[15]);
			cells[6].add(filledLbls[i]);
			if(i==45) cells[6].add(emptys[16]);
		}
		for(int i=46; i<53; i++){
			if(i==46) cells[7].add(emptys[17]);
			if(i==49) cells[7].add(emptys[18]);
			cells[7].add(filledLbls[i]);
		}
		for(int i=53; i<60; i++){
			if(i==54) cells[8].add(emptys[19]);
			if(i==58) cells[8].add(emptys[20]);
			cells[8].add(filledLbls[i]);
		}
		
		
		for(int i=0; i<9; i++){
			gamePnl.add(cells[i]);
		}
		
		exitBtn = new JButton("Verlassen");
		JPanel btnPnl = new JPanel();
		btnPnl.add(exitBtn);
		btnPnl.add(checkBtn);
		
		sudokuDlg.add(gamePnl);
		sudokuDlg.add(btnPnl, BorderLayout.SOUTH);
	}
	
	public JButton getExitBtn() {
		return exitBtn;
	}
	
}
