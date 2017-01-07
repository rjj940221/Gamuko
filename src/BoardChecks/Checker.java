package BoardChecks;

public class Checker {

    private boolean checkWestEastFreeThree(int Board[][], int PlayerNo, int x, int y, int lenX, int lenY) {
        boolean skip = false;
        int found = 0;
        int tmpX = x;
        int tmpY = y - 1;
        //System.out.println("x : "+x+"y : "+y);
        //checking free three going towards the west
        while (tmpY > -1 && Board[tmpX][tmpY] == PlayerNo || tmpY > -1 && Board[tmpX][tmpY] == 0 && !skip) {
            //accounting for free three with space
            if (Board[tmpX][tmpY] == 0)
                skip = true;
            else
                found++;
            //checking for end of board
            if (tmpY - 1 < 0)
                break;
            //checking if next slot is free, to make it a free three
            if (found == 2 && Board[tmpX][tmpY-1] == 0 && y + 1 < lenX && Board[x][y+1] == 0)
                return true;
            //checking if next slot is blocked, then it is not a free three
            if (found == 2 && Board[tmpX][tmpY-1] != 0)
                break;
            tmpY--;
        }
        if (found == 1 && y + 1 < lenY && Board[x][y+1] == PlayerNo)
            return true;
        //checking free three going towards then east
        skip = false;
        found = 0;
        tmpX = x;
        tmpY = y+1;
        while (tmpY < lenY && Board[tmpX][tmpY] == PlayerNo || tmpY < lenY && Board[tmpX][tmpY] == 0 && !skip) {
            if (Board[tmpX][tmpY] == 0)
                skip = true;
            else
                found++;
            //checking for board end
            if (tmpY + 1 > lenY - 1)
                break;
            //checking if next slot is free, to make it free three
            if (found == 2 && Board[tmpX][tmpY+1] == 0 && y - 1 > -1 && Board[x][y-1] == 0)
                return true;
            //checking if next slot is blocked, then it is not a free three
            if (found == 2 && Board[tmpX][tmpY+1] != 0)
                break;
            tmpY++;
        }
        if (found == 1 && y - 1 > -1 && Board[x][y-1] == PlayerNo)
            return true;
        return false;
    }

    private boolean checkNorthSouthFreeThree(int Board[][], int PlayerNo, int x, int y, int lenX, int lenY) {
        boolean skip = false;
        int found = 0;
        int tmpX = x-1;
        int tmpY = y;
        //checking free three going towards the north
        while (tmpX > -1 && Board[tmpX][tmpY] == PlayerNo || tmpX > -1 && Board[tmpX][tmpY] == 0 && !skip) {
            //accounting for free three with space
            if (Board[tmpX][tmpY] == 0)
                skip = true;
            else
                found++;
            //checking for end of board
            if (tmpX - 1 < 0)
                break;
            //checking if next slot is free, to make it a free three
            if (found == 2 && Board[tmpX-1][tmpY] == 0 && x + 1 < lenX && Board[x+1][y] == 0)
                return true;
            //checking if next slot is blocked, then it is not a free three
            if (found == 2 && Board[tmpX-1][tmpY] != 0)
                break;
            tmpX--;
        }
        if (found == 1 && x + 1 < lenX && Board[x+1][y] == PlayerNo)
            return true;
        //checking free three going towards then east
        skip = false;
        found = 0;
        tmpX = x+1;
        tmpY = y;
        while (tmpX < lenX && Board[tmpX][tmpY] == PlayerNo || tmpX < lenX && Board[tmpX][tmpY] == 0 && !skip) {
            if (Board[tmpX][tmpY] == 0)
                skip = true;
            else
                found++;
            //checking for board end
            if (tmpX + 1 > lenX - 1)
                break;
            //checking if next slot is free, to make it free three
            if (found == 2 && Board[tmpX+1][tmpY] == 0 && x - 1 > -1 && Board[x-1][y] == 0)
                return true;
            //checking if next slot is blocked, then it is not a free three
            if (found == 2 && Board[tmpX+1][tmpY] != 0)
                break;
            tmpX++;
        }
        if (found == 1 && x - 1 < -1 && Board[x-1][y] == PlayerNo)
            return true;
        return false;
    }

    public boolean isValidMove(int Board[][], int PlayerNo, int x, int y, int lenX, int lenY) {
        int freeThree = 0;

        if (checkWestEastFreeThree(Board, PlayerNo, x, y, lenX, lenY))
            freeThree++;
        if (checkNorthSouthFreeThree(Board, PlayerNo, x, y, lenX, lenY))
            freeThree++;
        if (freeThree > 1)
            System.out.println("More than one free three at x: " + x + " y: " + y);
        return (freeThree < 2);
    }

    /****************** Capture Checks *********************/
    private boolean isCaptureWest(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x][y - 1] == opp && b[x][y - 2] == opp && b[x][y - 3] == num)
            return true;
        return false;
    }

    private boolean isCaptureEast(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x][y + 1] == opp && b[x][y + 2] == opp && b[x][y + 3] == num)
            return true;
        return false;
    }

    private boolean isCaptureNorth(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x - 1][y] == opp && b[x - 2][y] == opp && b[x - 3][y] == num)
            return true;
        return false;
    }

    private boolean isCaptureSouth(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x + 1][y] == opp && b[x + 2][y] == opp && b[x + 3][y] == num)
            return true;
        return false;
    }

    private boolean isCaptureNorthWest(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x - 1][y - 1] == opp && b[x - 2][y - 2] == opp && b[x - 3][y - 3] == num)
            return true;
        return false;
    }

    private boolean isCaptureNorthEast(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x - 1][y + 1] == opp && b[x - 2][y + 2] == opp && b[x - 3][y + 3] == num)
            return true;
        return false;
    }

    private boolean isCaptureSouthWest(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x + 1][y - 1] == opp && b[x + 2][y - 2] == opp && b[x + 3][y - 3] == num)
            return true;
        return false;
    }

    private boolean isCaptureSouthEast(int b[][], int num, int x, int y) {
        int opp = (num == 1) ? 2 : 1;
        if (b[x + 1][y + 1] == opp && b[x + 2][y + 2] == opp && b[x + 3][y + 3] == num)
            return true;
        return false;
    }

    public String checkCapture(int b[][], int num, int x, int y, int lenX, int lenY) {
        /*
         * the "-3" checks to see if there is a 3rd slot OR end of the board
         */
        if (y - 3 > -1 && isCaptureWest(b, num, x, y))
            return "west";
        if (y - 3 > -1 && x + 3 < lenY && isCaptureSouthWest(b, num, x, y))
            return "southwest";
        if (x + 3 < lenY && isCaptureSouth(b, num, x, y))
            return "south";
        if (y + 3 < lenX && x + 3 < lenY && isCaptureSouthEast(b, num, x, y))
            return "southeast";
        if (y + 3 < lenX && isCaptureEast(b, num, x, y))
            return "east";
        if (y + 3 < lenX && x - 3 > -1 && isCaptureNorthEast(b, num, x, y))
            return "northeast";
        if (x - 3 > -1 && isCaptureNorth(b, num, x, y))
            return "north";
        if (y - 3 > -1 && x - 3 > -1 && isCaptureNorthWest(b, num, x, y))
            return "northwest";
        return null;
    }

    /********************5 PIECE IN LINE WIN **************/

    private String isLeftDiagonalWin(int b[][], int num, int x, int y, int lenX, int lenY) {
        int startX;
        int startY;
        int found = 0;

        while (b[x][y] == num) {
            if (x == 0 || y == 0)
                break;
            x--;
            y--;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            x++;
            y++;
        }
        startX = x;
        startY = y;
        while (b[x][y] == num) {
            found++;
            if (found == 5 || x == lenX - 1 || y == lenY - 1)
                break;
            x++;
            y++;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            x--;
            y--;
        }
        if (found == 5)
            return "leftdia," + startX + "," + startY + "," + x + "," + y;
        return null;
    }

    private String isRighttDiagonalWin(int b[][], int num, int x, int y, int lenX, int lenY) {
        int startX;
        int startY;
        int found = 0;

        while (b[x][y] == num) {
            if (x == 0 || y == lenY - 1)
                break;
            x--;
            y++;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            x++;
            y--;
        }
        startX = x;
        startY = y;
        while (b[x][y] == num) {
            found++;
            if (found == 5 || x == lenX - 1 || y == 0)
                break;
            x++;
            y--;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            x--;
            y++;
        }
        if (found == 5)
            return "rightdia," + startX + "," + startY + "," + x + "," + y;
        return null;
    }

    private String isVerticalWin(int b[][], int num, int x, int y, int lenX, int lenY) {
        int startX;
        int startY;
        int found = 0;

        while (b[x][y] == num) {
            if (x == 0)
                break;
            x--;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            x++;
        }
        startX = x;
        startY = y;
        while (b[x][y] == num) {
            found++;
            if (found == 5 || x == lenX - 1)
                break;
            x++;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            x--;
        }
        if (found == 5)
            return "vert," + startX + "," + startY + "," + x + "," + y;
        return null;
    }

    private String isHorizontalWin(int b[][], int num, int x, int y, int lenX, int lenY) {
        int startX;
        int startY;
        int found = 0;

        while (b[x][y] == num) {
            if (y == 0)
                break;
            y--;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            y++;
        }
        startX = x;
        startY = y;
        while (b[x][y] == num) {
            found++;
            if (found == 5 || y == lenY - 1)
                break;
            y++;
        }
        //to prevent any skip made by above loop
        if (b[x][y] != num) {
            y--;
        }
        if (found == 5)
            return "horizon," + startX + "," + startY + "," + x + "," + y;
        return null;
    }

    public String   isLineWin(int b[][], int num, int x, int y, int lenX, int lenY){
        String tmp;

        if ((tmp = isLeftDiagonalWin(b, num, x, y, lenX, lenY)) != null)
            return tmp;
        if ((tmp = isVerticalWin(b, num, x, y, lenX, lenY)) != null)
            return tmp;
        if ((tmp = isHorizontalWin(b, num, x, y, lenX, lenY)) != null)
            return tmp;
        if ((tmp = isRighttDiagonalWin(b, num, x, y, lenX, lenY)) != null)
            return tmp;
        return null;
    }
}
