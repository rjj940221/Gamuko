package BoardChecks;

/**
 * Created by rojones on 2017/01/05.
 */
public class BoardChecker {

    private boolean checkFreeThreeVertical(int board[][], int player, int opponent, int x, int y) {
        int yIt = y;
        boolean skip = false;
        int count = 0;
        int test = 0;

        while (yIt > -1 && (board[x][yIt] == player || (board[x][yIt] == 0 && !skip)) && test < 5) {
            if (board[x][yIt] == 0)
                skip = true;
            else
                test++;
            yIt--;
        }
        if (test == 4)
            return false;
        if (yIt == -1 && board[x][0] != 0)
            return false;
        if (yIt != -1 && board[x][yIt] == opponent && board[x][yIt + 1] != 0)
            return false;
        yIt++;
        while (yIt < 19 && (board[x][yIt] == player || (board[x][yIt] == 0 && skip))) {
            if (board[x][yIt] == player)
                count++;
            else
                skip = false;
            yIt++;
        }
        return yIt != 19 && count == 3 && (board[x][yIt] == 0 || board[x][yIt - 1] == 0);
    }

    private boolean checkFreeThreeHorizantal(int board[][], int player, int opponent, int x, int y) {
        int xIt = x;
        boolean skip = false;
        int count = 0;
        int test = 0;

        while (xIt > -1 && (board[xIt][y] == player || (board[xIt][y] == 0 && !skip)) && test < 5) {
            if (board[xIt][y] == 0)
                skip = true;
            else
                test++;
            xIt--;
        }
        if (xIt == -1 && board[0][y] != 0)
            return false;
        if (xIt != -1 && board[xIt][y] == opponent && board[xIt + 1][y] != 0)
            return false;
        xIt++;
        while (xIt < 19 && (board[xIt][y] == player || (board[xIt][y] == 0 && skip))) {
            if (board[xIt][y] == player)
                count++;
            else
                skip = false;
            xIt++;
        }
        return xIt != 19 && count == 3 && (board[xIt][y] == 0 || board[xIt - 1][y] == 0);
    }

    private boolean checkFreeThreePosDiagnol(int board[][], int player, int opponent, int x, int y) {
        int xIt = x;
        int yIt = y;
        boolean skip = false;
        int count = 0;
        int test = 0;

        while ((xIt > -1 && yIt > -1) && (board[xIt][yIt] == player || (board[xIt][yIt] == 0 && !skip)) && test < 5) {
            if (board[xIt][yIt] == 0)
                skip = true;
            else
                test++;
            xIt--;
            yIt--;
        }
        if (test == 4)
            return false;
        if ((xIt == -1 || yIt == -1) && board[xIt + 1][yIt + 1] != 0)
            return false;
        if ((xIt != -1 && yIt != -1) &&board[xIt][yIt] == opponent && board[xIt + 1][yIt + 1] != 0)
            return false;
        xIt++;
        yIt++;
        while ((xIt < 19 && yIt < 19) && (board[xIt][y] == player || (board[xIt][y] == 0 && skip))) {
            if (board[xIt][y] == player)
                count++;
            else
                skip = false;
            xIt++;
            yIt++;
        }
        return xIt != 19 && yIt != 19 && count == 3 && (board[xIt][y] == 0 || board[xIt - 1][y] == 0);
    }

    private boolean checkFreeThreeNegDiagonla(int board[][], int player, int opponent, int x, int y) {
        int xIt = x;
        int yIt = y;
        boolean skip = false;
        int count = 0;
        int test = 0;

        while ((xIt > -1 && yIt < 19) && (board[xIt][yIt] == player || (board[xIt][yIt] == 0 && !skip)) && test < 5) {
            if (board[xIt][yIt] == 0)
                skip = true;
            else
                test++;
            xIt--;
            yIt++;
        }
        if (test == 4)
            return false;
        if ((xIt == -1 || yIt == 19) && board[xIt + 1][yIt - 1] != 0)
            return false;
        if ((xIt != -1 && yIt != 19) && board[xIt][y] == opponent && board[xIt + 1][yIt - 1] != 0)
            return false;
        xIt++;
        yIt--;
        while ((xIt < 19 && yIt > -1) && (board[xIt][yIt] == player || (board[xIt][yIt] == 0 && skip))) {
            if (board[xIt][yIt] == player)
                count++;
            else
                skip = false;
            xIt++;
            yIt--;
        }
        return xIt != 19 && yIt != -1 && count == 3 && (board[xIt][y] == 0 || board[xIt - 1][y] == 0);
    }

    public boolean isValidMove(int board[][], int player, int x, int y) {
        int numFreeThree = 0;
        int opponent = (player == 1) ? 2 : 1;
        if (board[x][y] != 0)
            return false;
        board[x][y] = player;
        if (checkFreeThreeVertical(board, player, opponent, x, y))
            numFreeThree++;
        if (checkFreeThreeHorizantal(board, player, opponent, x, y))
            numFreeThree++;
        if (numFreeThree < 2 && checkFreeThreePosDiagnol(board, player, opponent, x, y))
            numFreeThree++;
        if (numFreeThree < 2 && checkFreeThreeNegDiagonla(board, player, opponent, x, y))
            numFreeThree++;
        board[x][y] = 0;
        if (numFreeThree < 2)
            return true;
        return false;
    }

    public boolean isLineVictory(int board[][], int player) {
        int count = 0;
        int y = 0;
        int x;

        while (y < 19) {
            x = 0;
            while (x < 19) {
                while (x < 19 && board[x][y] == player) {
                    count++;
                    x++;
                }
                if (count > 4)
                    return true;
                count = 0;
                while (x < 19 && board[x][y] != player)
                    x++;
            }
            y++;
        }
        x = 0;
        while (x < 19) {
            y = 0;
            while (y < 19) {
                while (y < 19 && board[x][y] == player) {
                    count++;
                    y++;
                }
                if (count > 4)
                    return true;
                count = 0;
                while (y < 19 && board[x][y] != player)
                    y++;
            }
            x++;
        }

        x = 0;
        while (x < 19) {
            int xIt = x;
            int yIt = 0;
            while (xIt < 19 && yIt < 19) {
                while ((xIt < 19 && yIt < 19) && board[xIt][yIt] == player) {
                    count++;
                    xIt++;
                    yIt++;
                }
                if (count > 4)
                    return true;
                count = 0;
                while ((xIt < 19 && yIt < 19) && board[xIt][yIt] != player) {
                    xIt++;
                    yIt++;
                }
            }

            xIt = x;
            yIt = 18;
            while (xIt < 19 && yIt > -1) {
                while ((xIt < 19 && yIt > -1) && board[xIt][yIt] == player) {
                    ++count;
                    xIt++;
                    yIt--;
                }
                if (count > 4)
                    return true;
                count = 0;
                while ((xIt < 19 && yIt > -1) && board[xIt][yIt] != player) {
                    xIt++;
                    yIt--;
                }
            }
            x++;
        }

        y = 0;
        while (y < 19) {
            int xIt = 0;
            int yIt = y;
            while (xIt < 19 && yIt < 19) {
                while ((xIt < 19 && yIt < 19) && board[xIt][yIt] == player) {
                    count++;
                    xIt++;
                    yIt++;
                }
                if (count > 4)
                    return true;
                count = 0;
                while ((xIt < 19 && yIt < 19) && board[xIt][yIt] != player) {
                    xIt++;
                    yIt++;
                }
            }
            xIt = 0;
            yIt = y;
            while (xIt < 19 && yIt > -1) {
                while ((xIt < 19 && yIt > -1) && board[xIt][yIt] == player) {
                    ++count;
                    xIt++;
                    yIt--;
                }
                if (count > 4)
                    return true;
                count = 0;
                while ((xIt < 19 && yIt > -1) && board[xIt][yIt] != player) {
                    xIt++;
                    yIt--;
                }
            }
            y++;
        }
        return false;
    }

    public String isCapture(int board[][], int player, int x, int y) {
        int opponent = (player == 1) ? 2 : 1;
        String re = "";
        int iter;

        //x increace y decreace
        iter = 1;
        while ((x + iter < 19 && y - iter > -1) && iter < 3 && board[x + iter][y - iter] == opponent)
            iter++;
        if ((x + iter < 19 && y - iter > -1) && iter == 3 && board[x + iter][y - iter] == player)
            re += "1,";
        //x increace
        iter = 1;
        while (x + iter < 19 && iter < 3 && board[x + iter][y] == opponent)
            iter++;
        if (x + iter < 19 && iter == 3 && board[x + iter][y] == player)
            re += "2,";
        //x and y increace
        iter = 1;
        while ((x + iter < 19 && y + iter < 19) && iter < 3 && board[x + iter][y + iter] == opponent)
            iter++;
        if ((x + iter < 19 && y + iter < 19) && iter == 3 && board[x + iter][y + iter] == player)
            re += "3,";
        //y increces
        iter = 1;
        while (y + iter < 19 && iter < 3 && board[x][y + iter] == opponent)
            iter++;
        if (y + iter < 19 && iter == 3 && board[x][y + iter] == player)
            re += "4,";
        //x decreace y increace
        iter = 1;
        while ((x - iter > -1 && y + iter < 19) && iter < 3 && board[x - iter][y + iter] == opponent)
            iter++;
        if ((x - iter > -1 && y + iter < 19) && iter == 3 && board[x - iter][y + iter] == player)
            re += "5,";
        //x decreeces
        iter = 1;
        while (x - iter > -1 && iter < 3 && board[x - iter][y] == opponent)
            iter++;
        if (x - iter > -1 && iter == 3 && board[x - iter][y] == player)
            re += "6,";
        // x and y decreace
        iter = 1;
        while ((x - iter > -1 && y - iter > -1) && iter < 3 && board[x - iter][y - iter] == opponent)
            iter++;
        if ((x - iter > -1 && y - iter > -1) && iter == 3 && board[x - iter][y - iter] == player)
            re += "7,";
        //y decreces
        iter = 1;
        while (y - iter > -1 && iter < 3 && board[x][y - iter] == opponent)
            iter++;
        if (y - iter > -1 && iter == 3 && board[x][y - iter] == player)
            re += "8,";

        if (!re.equals(""))
            re = re.substring(0, re.length() - 1);
        return re;
    }
}
