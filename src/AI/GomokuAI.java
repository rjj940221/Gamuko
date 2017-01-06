package AI;

/**
 * Created by rojones on 2017/01/06.
 */
public class GomokuAI {
    private int captured;
    private int lost;
    private int player;
    private int depth;

    public GomokuAI(int playerNum, int depth) {
        player = playerNum;
        captured = 0;
        lost = 0;
        this.depth = depth;
    }

    private Move minMax(int board[][], boolean maximiser, int depth) {
        //if (depth == this.depth)
            return (new Move(-1,-1,board,this.player, 0));
    }

    public String play(int board[][]) {
        Move m = minMax(board, true, 0);
        return (m.x + "," + m.y);
    }
}
