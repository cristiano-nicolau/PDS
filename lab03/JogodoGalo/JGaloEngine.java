
public class JGaloEngine implements JGaloInterface{
    char player;
    char [][]board= new char [3][3];
    char result;
    int count;
    boolean finished;

    public JGaloEngine(){
        this('O');


    }
    public JGaloEngine(char player){
        this.player = player;
        this.result=' ';
        this.finished = false;
        board=cBoard();
    }
    
    public char[][] cBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){board[i][j] = ' ';
            }
        }
        return board;
    }
    @Override
    public char getActualPlayer(){
        return this.player;
    }

    public boolean setJogada(int lin, int col){
        if(board[lin-1][col-1] == ' '){
            board[lin-1][col-1] = this.player;
            this.count++;
            if(this.player == 'O'){
                this.player = 'X';
            }else{
                this.player = 'O';
            }
            return true;
        }else{
            return false;
        }
    }
    public char checkResult(){
        return this.result;
    }
    public boolean isFinished(){
        if(this.checkRow() || this.checkCol() || this.checkDiag() || this.count == 9){
            this.finished = true;
            return true;
        }else{
            return false;
        }
       
    }
    //checks
    public boolean checkRow(){
        for(int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                if(board[i][0] == 'O'){
                    this.result = 'O';
                    return true;
                }else if(board[i][0] == 'X'){
                    this.result = 'X';
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkCol(){
        for(int i = 0; i < 3; i++){
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                if(board[0][i] == 'O'){
                    this.result = 'O';
                    return true;
                }else if(board[0][i] == 'X'){
                    this.result = 'X';
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkDiag(){
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            if(board[0][0] == 'O'){
                this.result = 'O';
                return true;
            }else if(board[0][0] == 'X'){
                this.result = 'X';
                return true;
            }
        }else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            if(board[0][2] == 'O'){
                this.result = 'O';
                return true;
            }else if(board[0][2] == 'X'){
                this.result = 'X';
                return true;
            }
        }
        return false;
    }
}