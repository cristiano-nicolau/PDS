package lab03.Jogo_Do_Galo; // you may change this package

public interface JGaloInterface {
	public char getActualPlayer(); // 'O' or 'X'
	public boolean setJogada(int lin, int col);
	public boolean isFinished();   // someone wons, or no empty positions
	public char checkResult();	// who wons?
}