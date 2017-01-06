package AI;

/**
 * Created by rojones on 2017/01/06.
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
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] = new int[19][19];
        test tester = new test();
        Move move;
        GomokuAI ai = new GomokuAI(1, 3, 3);
        move = new Move(0, 0, board, 1);
        System.out.println("making the move 0,0 on an empty board: " + move.value);
        move.setBoardPeace(1, 1, 1);
        move.changeMove(0, 0, 1);
        System.out.println("player 1 making the move 0,0 on a board with a peace(1) at(1,1): " + move.value);
        move.setBoardPeace(1, 1, 0);
        move.setBoardPeace(2, 2, 1);
        move.changeMove(0, 0, 1);
        System.out.println("player 1 making the move 0,0 on a board with a peace(1) at(2,2): " + move.value);
        board[0][0] = 1;
        board[2][2] = 1;
        move = new Move(1, 1, board, 1);
        System.out.println("player 1 making the move 1,1 on a board with a peace(1) at(2,2) and (0,0): " + move.value);
        move = new Move(3, 3, board, 1);
        System.out.println("player 1 making the move 3,3 on a board with a peace(1) at(2,2) and (0,0): " + move.value);
        move = new Move(1, 2, board, 1);
        System.out.println("player 1 making the move 1,2 on a board with a peace(1) at(2,2) and (0,0): " + move.value);
        long startTime = System.nanoTime();
        String moveMade = ai.play(board);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 10000000;

        System.out.println(moveMade);
        System.out.println("time (milliseconds): "+ duration);
        board[1][1] = 1;
        tester.printBoard(board);
    }
}
