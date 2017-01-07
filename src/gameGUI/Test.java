package gameGUI;

import BoardChecks.Checker;

public class Test {
    public Checker checker;

    public Test(){
        checker = new Checker();
    }

    public void printBoard(int b[][]){
        for(int x = 0; x < 7; x++){
            for (int y = 0; y < 7; y++){
                System.out.print(b[x][y]+" ");
            }
            System.out.println();
        }
    }

    public void  FreeThreeHorVerTest1() {
        boolean expect = true;
        int board[][] = {
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 0,6, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  FreeThreeHorVerTest2() {
        boolean expect = false;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 3,3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  FreeThreeHorVerTest3() {
        boolean expect = true;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 2, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 4,3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  FreeThreeHorVerTest4() {
        boolean expect = false;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 4,3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  FreeThreeHorVerTest5() {
        boolean expect = false;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 3,2, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  FreeThreeHorVerTest6() {
        boolean expect = false;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 4,3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  FreeThreeHorVerTest7() {
        boolean expect = false;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        boolean val = checker.isValidMove(board, 1, 3,3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest1() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {2, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 3, 2, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest2() {
        String expect = "west";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 3, 4, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest3() {
        String expect = "east";
        int board[][] = {
                {0, 0, 0, 2, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 0, 2, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest4() {
        String expect = "north";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 4, 4, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest5() {
        String expect = "south";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 2, 6, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest6() {
        String expect = "northwest";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 5, 4, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest7() {
        String expect = "northeast";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 3, 3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest8() {
        String expect = "southwest";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 2, 3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest9() {
        String expect = "southeast";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 0, 0, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest10() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 3, 1, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest11() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 3, 0, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }
    public void  captureTest12() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 6, 1, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }
    public void  captureTest13() {
        String expect = "west";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0},
                {1, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 5, 3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  captureTest14() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 0, 0, 0},
                {0, 0, 1, 0, 2, 0, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.checkCapture(board, 1, 3, 2, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin1() {
        String expect = "leftdia";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 0, 0},
                {0, 0, 2, 2, 1, 0, 0},
                {0, 0, 1, 0, 2, 1, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 3, 3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin2() {
        String expect = "leftdia";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 2, 0, 1, 0, 0, 0},
                {0, 0, 2, 2, 1, 0, 0},
                {0, 0, 1, 0, 2, 1, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 5, 5, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin3() {
        String expect = "rightdia";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 2, 0, 1, 0, 0, 0},
                {0, 0, 1, 2, 0, 0, 0},
                {0, 1, 0, 0, 2, 1, 0},
                {1, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 6, 0, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin4() {
        String expect = "rightdia";
        int board[][] = {
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 2, 0, 0, 0},
                {0, 0, 1, 0, 2, 0, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 1, 3, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin5() {
        String expect = "vert";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 2, 0, 0, 0, 0, 0},
                {1, 0, 0, 2, 0, 0, 0},
                {1, 0, 0, 0, 2, 1, 0},
                {1, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 4, 0, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin6() {
        String expect = "vert";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 2, 0, 0, 0, 0, 1},
                {0, 0, 2, 2, 1, 0, 1},
                {0, 0, 1, 0, 2, 1, 1},
                {0, 0, 2, 0, 0, 0, 1}
        };
        String val = checker.isLineWin(board, 1, 2, 6, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin7() {
        String expect = "horizon";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 1, 0, 0},
                {0, 0, 1, 0, 2, 1, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 2, 1, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin8() {
        String expect = "horizon";
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 1, 0, 0},
                {0, 0, 1, 0, 2, 1, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 1, 0, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin9() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 2, 1, 0, 0, 0, 0},
                {0, 0, 2, 2, 1, 0, 0},
                {1, 0, 1, 0, 2, 1, 0},
                {0, 0, 2, 0, 0, 0, 0}
        };
        String val = checker.isLineWin(board, 1, 3, 2, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public void  lineWin10() {
        String expect = null;
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 2},
                {0, 2, 0, 0, 0, 0, 1},
                {0, 0, 2, 2, 1, 0, 1},
                {0, 0, 1, 0, 2, 1, 0},
                {0, 0, 2, 1, 1, 1, 1}
        };
        String val = checker.isLineWin(board, 1, 6, 6, 7, 7);
        printBoard(board);
        if (val == expect)
            System.out.println("Passed Test: "+val+" Expected: "+expect);
        else
            System.out.println("Failed Test: "+val+" Expected: "+expect);
    }

    public static void main(String args[]){
        Test UnitTest = new Test();

        System.out.println("/****************************************************/");
        System.out.println("FREE THREES UNIT TEST!!!");
        UnitTest.FreeThreeHorVerTest1();
        UnitTest.FreeThreeHorVerTest2();
        UnitTest.FreeThreeHorVerTest3();
        UnitTest.FreeThreeHorVerTest4();
        UnitTest.FreeThreeHorVerTest5();
        UnitTest.FreeThreeHorVerTest6();
        UnitTest.FreeThreeHorVerTest7();
        System.out.println("/****************************************************/");
        System.out.println("CAPTURE PIECES UNIT TEST!!!");
        UnitTest.captureTest1();
        UnitTest.captureTest2();
        UnitTest.captureTest3();
        UnitTest.captureTest4();
        UnitTest.captureTest5();
        UnitTest.captureTest6();
        UnitTest.captureTest7();
        UnitTest.captureTest8();
        UnitTest.captureTest9();
        UnitTest.captureTest10();
        UnitTest.captureTest11();
        UnitTest.captureTest12();
        UnitTest.captureTest13();
        UnitTest.captureTest14();
        System.out.println("/****************************************************/");
        System.out.println("5 IN LINE WIN UNIT TEST!!!");
        UnitTest.lineWin1();
        UnitTest.lineWin2();
        UnitTest.lineWin3();
        UnitTest.lineWin4();
        UnitTest.lineWin5();
        UnitTest.lineWin6();
        UnitTest.lineWin7();
        UnitTest.lineWin8();
        UnitTest.lineWin9();
        UnitTest.lineWin10();
    }
}
