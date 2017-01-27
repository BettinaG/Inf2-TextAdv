package Textadventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class scoreView extends JFrame {

	private ArrayList<String> lines;
	private ArrayList<Attempts> scores;
	JList scoreList;
	private String name;
	private int min, sek;
	private File file;
	
	DecimalFormat df = new DecimalFormat("00");
	
	public scoreView(){
		
		lines  = new ArrayList<>();
		scores = new ArrayList<Attempts>();
		
		file = new File("scores.txt");
		
		scoreList = new JList();
		scoreList.setPreferredSize(new Dimension(300, 500));
		
		Font font = new Font("Lucida Console",Font.CENTER_BASELINE, 14);
		scoreList.setFixedCellHeight(30);
		scoreList.setFont(font);
		scoreList.setBackground(Color.BLACK);
		scoreList.setForeground(Color.GREEN);
		
		JPanel pnl = new JPanel();
		pnl.setBackground(Color.BLACK);
		pnl.add(Box.createVerticalStrut(40));
		
		add(pnl, BorderLayout.NORTH);
		add(scoreList);
		
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Object object = ois.readObject();
			if(object instanceof ArrayList)
			{
				scores = (ArrayList)object;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300,500);
		setLocation(450,50);
		setVisible(true);
	}
	
	public void showElements(){
		for(Attempts a: scores){
			int space = 15;
			space -= a.getName().length();
			String spaceStr = "";
			for(int i=0; i<space; i++){
				spaceStr = spaceStr+" ";
			} 
			lines.add("    "+a.getName()+spaceStr+(df.format(a.getMinutes()))+":"+(df.format(a.getSeconds())));
		}
		scoreList.setListData(lines.toArray());
	}
	
	public void addElement(int sek, int min, String name){
		scores.add(new Attempts(min,sek,name));
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(scores);
				oos.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		showElements();
	}
}
