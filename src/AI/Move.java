package AI;

import BoardChecks.*;

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
    private BoardChecker checker = new BoardChecker();

    public void setBoard(int[][] board) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public void setBoardPeace(int x, int y, int player) {
        this.board[x][y] = player;
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
            boolean row = false;
            int colCount = 0;
            boolean col = false;
            while (y < 19) {
                if (board[x][y] == player) {
                    rowCount++;
                    if (y - 1 > -1 && board[x][y - 1] == 0)
                        row = true;
                } else {
                    if (row || board[x][y] == 0)
                        val += (rowCount * rowCount);
                    row = false;
                    rowCount = 0;
                }
                if (board[y][x] == player) {
                    colCount++;
                    if (y - 1 > -1 && board[y - 1][x] == 0)
                        col = true;
                } else {
                    if (col || board[y][x] == 0)
                        val += (colCount * colCount);
                    col = false;
                    colCount = 0;
                }
                y++;
            }
            y = 0;
            boolean posDiag = false;
            int posDiagCount = 0;
            int xIt = x;
            while ((xIt < 19 && y < 19)) {
                if (board[xIt][y] == player) {
                    posDiagCount++;
                    if (xIt > 0 && y > 0 && board[xIt][y] == 0)
                        posDiag = true;
                } else {
                    if (posDiag || board[xIt][y] == 0)
                        val += posDiagCount * posDiagCount;
                    posDiag = false;
                    posDiagCount = 0;
                }
                y++;
                xIt++;
            }
            y = 18;
            boolean negDiag = false;
            int negDiagCount = 0;
            xIt = x;
            while ((xIt < 19 && y > -1)) {
                if (board[xIt][y] == player) {
                    negDiagCount++;
                    if (xIt > 0 && y < 18 && board[xIt - 1][y + 1] == 0)
                        negDiag = true;
                } else {
                    if (negDiag || board[xIt][y] == 0)
                        val += negDiagCount * negDiagCount;
                    negDiag = false;
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

    private void removeCaps(String[] caps){
        int xDir = 0;
        int yDir = 0;
        for (String cap: caps) {
            switch (cap) {
                case "1":
                    xDir = 1;
                    yDir = -1;
                    break;
                case "2":
                    xDir = 1;
                    yDir = 0;
                    break;
                case "3":
                    xDir = 1;
                    yDir = 1;
                    break;
                case "4":
                    xDir = 0;
                    yDir = 1;
                    break;
                case "5":
                    xDir = -1;
                    yDir = 1;
                    break;
                case "6":
                    xDir = -1;
                    yDir = 0;
                    break;
                case "7":
                    xDir = -1;
                    yDir = -1;
                    break;
                case "8":
                    xDir = 0;
                    yDir = -1;
                    break;
            }
            board[x + xDir][y + yDir] = 0;
            board[x + (xDir * 2)][y + (yDir * 2)] = 0;
        }
    }
    
    public int moveValue() {
        int capVal = 0;
        if (x > -1 && x < 19 && y > -1 && y < 19) {
            String capls = checker.isCapture(this.board, player, x, y);
            if (!capls.equals("")) {
                String[] caps = capls.split(",");
                capVal = (int) Math.pow((caps.length * 2), 2);
                removeCaps(caps);
            }
        }

        return (evalPlayerPosition(player) + capVal) - evalPlayerPosition(opponent);
    }

    public void reEvalMoveValue() {
        this.value = evalPlayerPosition(player) - evalPlayerPosition(opponent);
    }

    public void changeMove(int x, int y, int player) {
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
