
package lab03.ex1; // you may change this package
import java.util.Arrays;
public class JGaloImplementation implements JGaloInterface {

	private char player1;
	private char player2;
	private char[][] grid;
	private int nplays;
	private char winner;
	
	public JGaloImplementation() {
		this.player1='X';
		this.player2='O';
		this.winner=' ';
		this.grid = new char[3][3];
		Arrays.stream(grid).forEach(a -> Arrays.fill(a, '.'));
		this.nplays=0;
	}

	public char getActualPlayer(){// 'O' or 'X'
		if (nplays%2 == 0) {
			return player1;
		}else{
			return player2;
		}
			
		
	} 
	public boolean setJogada(int lin, int col){
		if (grid[lin-1][col-1] == '.') {
			grid[lin-1][col-1]=this.getActualPlayer();
			nplays++;
			return true;
		}
		return false;
		
	}
	public boolean isFinished(){// someone wons, or no empty positions


		if(checkLines())
			return true;
		
		if(checkColumn())
			return true;
		
		if(checkDiagonal(0))//diagonal direita esquerda
			return true;

		if(checkDiagonal(2))//diagonal esquerda direita 
			return true;


		if (nplays==9) {
			return true;
		}

		return false;

	}   


	private boolean checkDiagonal(int index){
		String diagonal="";
		for (int j = 0; j < grid.length; j++) {
			
			diagonal=diagonal+grid[j][Math.abs(j-index )];//index 0 no caso da diagonal esquerda direita e index 2 na oposta 
		}
		String auxd= diagonal;
		if (auxd.chars().allMatch(c -> c == auxd.charAt(0)) && auxd.charAt(0)!='.')  {//verifica se a string tem todos os chars iguals e sao diferentes de '.' vazio
			this.winner=auxd.charAt(0);
			return true;
		}
		return false;
	}



	private boolean checkLines(){
		for (char[] cl : grid) {//check by line
			String str = new String(cl);
			if (str.chars().allMatch(c -> c == str.charAt(0)) && str.charAt(0)!='.') {//verifica se a string tem todos os chars iguals e sao diferentes de '.' vazio
				this.winner=str.charAt(0);
				return true;
			}
		}
		return false;
	}

	private boolean checkColumn(){
		int i =0;
		for (char k : grid[0]){
			String colunm="";
			for (char[] row : grid) {
				colunm=colunm+row[i];
				if (colunm.length()==3) {//quando a string tiver todos os 3 valores da coluna verifica
					String aux= colunm;
					if (aux.chars().allMatch(c -> c == aux.charAt(0)) && aux.charAt(0)!='.')  {
						this.winner=aux.charAt(0);
						return true;
					}
				}
			}
			i++;
		}
		return false;
	}


	public char checkResult(){// who wons?
		return winner;
	}	
		
		
}