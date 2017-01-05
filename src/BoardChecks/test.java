package BoardChecks;

/**
 * Created by rojones on 2017/01/05.
 */

public class test {
    private void reset(int board[][]) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = 0;
            }
        }
    }

    private void printBoard(int board[][]) {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test tester = new test();
        BoardChecker boadTester = new BoardChecker();
        int board[][] = new int[19][19];
        System.out.println("expecting false: " + boadTester.isLineVictory(board, 1));
        for (int i = 0; i < 5; i++) {
            board[i][0] = 1;
        }
        System.out.println("expecting true: " + boadTester.isLineVictory(board, 1));
        tester.reset(board);
        for (int i = 0; i < 5; i++) {
            board[0][i] = 1;
        }
        System.out.println("expecting true: " + boadTester.isLineVictory(board, 1));

        tester.reset(board);
        for (int i = 0; i < 5; i++) {
            board[i][i] = 1;
        }
        System.out.println("expecting true: " + boadTester.isLineVictory(board, 1));

        tester.reset(board);
        for (int i = 0; i < 5; i++) {
            board[8 - i][i] = 1;
        }
        System.out.println("expecting true: " + boadTester.isLineVictory(board, 1));

        tester.reset(board);
        for (int i = 0; i < 4; i++) {
            board[8 - i][i] = 1;
        }
        board[2][3] = 2;
        board[3][5] = 1;
        System.out.println("expecting false: " + boadTester.isLineVictory(board, 1));
        tester.reset(board);
        board[0][0] = 1;
        board[3][3] = 1;
        board[3][0] = 1;
        board[0][3] = 1;

        board[1][0] = 2;
        board[2][0] = 2;
        board[0][1] = 2;
        board[0][2] = 2;
        board[1][1] = 2;
        board[1][2] = 2;
        board[1][3] = 2;
        board[2][1] = 2;
        board[2][2] = 2;
        board[2][3] = 2;
        board[1][3] = 2;
        board[2][3] = 2;
        board[3][1] = 2;
        board[3][2] = 2;

        tester.printBoard(board);
        System.out.println("expecting true: " + boadTester.isCapture(board, 1, 0, 0));
        System.out.println("expecting true: " + boadTester.isCapture(board, 1, 3, 0));
        System.out.println("expecting true: " + boadTester.isCapture(board, 1, 3, 3));
        System.out.println("expecting true: " + boadTester.isCapture(board, 1, 0, 3));

    }
}