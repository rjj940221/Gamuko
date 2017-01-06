package AI;

/**
 * Created by rojones on 2017/01/06.
 */
public class Move {
    public int x;
    public int y;
    public int board[][] = new int [19][19];
    public int player;
    public int value;

    public Move(int x, int y, int[][] board, int player, int value) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.player = player;
        this.value = value;
    }
}
