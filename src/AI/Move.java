package AI;

/**
 * Created by rojones on 2017/01/06.
 */
public class Move {
    public int x;
    public int y;
    private int board[][];
    public int player;
    public int opponent;
    public int value;

    public void setBoard(int[][] board) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public void setBoardPeace(int x, int y, int player){
        this.board [x][y] = player;
    }

    public int[][] getBoard() {
        return (this.board);
    }

    public int evalPlayerPosition(int player) {
        int x = 0;
        int val = 0;

        while (x < 19) {
            int y = 0;
            int rowCount = 0;
            int colCount = 0;
            while (y < 19) {
                if (board[x][y] == player) {
                    rowCount++;
                } else {
                    val += (rowCount * rowCount);
                    rowCount = 0;
                }
                if (board[y][x] == player) {
                    colCount++;
                } else {
                    val += (colCount * colCount);
                    colCount = 0;
                }
                y++;
            }
            y = 0;
            int posDiagCount = 0;
            int xIt = x;
            while ((xIt < 19 && y < 19)) {
                if (board[xIt][y] == player)
                    posDiagCount++;
                else {
                    val += posDiagCount * posDiagCount;
                    posDiagCount = 0;
                }
                y++;
                xIt++;
            }
            y = 18;
            int negDiagCount = 0;
            xIt = x;
            while ((xIt < 19 && y > -1)) {
                if (board[xIt][y] == player)
                    negDiagCount++;
                else {
                    val += negDiagCount * negDiagCount;
                    negDiagCount = 0;
                }
                y--;
                xIt++;
            }
            x++;
        }
        int y = 1;
        while (y < 18) {
            int yItPos = y;
            int yItNeg = y;
            int posCount = 0;
            int negCount = 0;
            x = 0;
            while (x < 19 && yItPos < 19) {
                if (board[x][yItPos] == player)
                    posCount++;
                else {
                    val += posCount * posCount;
                    posCount = 0;
                }
                x++;
                yItPos++;
            }

            x = 0;
            while (x < 19 && yItNeg > -1) {
                if (board[x][yItNeg] == player)
                    negCount++;
                else {
                    val += negCount * negCount;
                    negCount = 0;
                }
                x++;
                yItPos++;
            }
            y++;
        }
        return val;
    }

    public int moveValue() {
        return evalPlayerPosition(player) - evalPlayerPosition(opponent);
    }

    public void reEvalMoveValue() {
        this.value = evalPlayerPosition(player) - evalPlayerPosition(opponent);
    }

    public void changeMove(int x, int y, int player){
        if (this.x < 19 && this.x > -1 && this.y < 19 && this.y > -1)
            this.board[this.x][this.y] = 0;
        this.x = x;
        this.y = y;
        if (x < 19 && x > -1 && y < 19 && y > -1)
            this.board[x][y] = player;
        this.player = player;
        this.opponent = (player == 1) ? 2 : 1;
        this.value = moveValue();
    }

    public Move(int x, int y, int[][] board, int player) {
        this.x = x;
        this.y = y;
        this.board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                this.board[i][j] = board[i][j];
            }
        }
        if (x < 19 && x > -1 && y < 19 && y > -1)
            this.board[x][y] = player;
        this.player = player;
        this.opponent = (player == 1) ? 2 : 1;
        this.value = moveValue();

    }
}
