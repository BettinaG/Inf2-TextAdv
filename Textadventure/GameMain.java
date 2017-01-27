package Textadventure;

public class GameMain {

	public static void main(String[] args) {
		
		menuView menu = new menuView();
		SchereSteinPapier ssp = new SchereSteinPapier();
		TicTacToe ttt = new TicTacToe();
		Sudoku sudoku = new Sudoku();
		
		Texte texte = new Texte();
		
		new GameController(menu, ssp, ttt, sudoku);
	}
}
