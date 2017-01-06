package AI;

import java.util.Iterator;
import java.util.Vector;

import BoardChecks.*;

/**
 * Created by rojones on 2017/01/06.
 */
public class GomokuAI {
    private int captured;
    private int lost;
    private int range;
    private int player;
    private int opponent;
    private int depth;
    private BoardChecker checker = new BoardChecker();

    public GomokuAI(int playerNum, int depth, int range) {
        player = playerNum;
        captured = 0;
        lost = 0;
        this.depth = depth;
        opponent = (player == 2) ? 1 : 2;
        this.range = (range < 0) ? 1 : ((range < 19) ? range : 18);
    }

    private Vector<Move> generateMoves(int board[][], int player) {
        Vector<Move> re = new Vector<Move>();


        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                boolean found = false;
                int xIt = ((i - range) > -1) ? i - range : 0;
                int xbound = ((i + range + 1) < 19) ? i + range + 1 : 19;
                int ybound = ((j + range + 1) < 19) ? j + range + 1 : 19;
                while (xIt < xbound && !found) {
                    int yIt = ((j - range) > -1) ? j - range : 0;
                    while (yIt < ybound && !found) {
                        if (board[xIt][yIt] != 0)
                            found = true;
                        yIt++;
                    }
                    xIt++;
                }
                if (found && checker.isValidMove(board, player, i, j))
                    re.add(new Move(i, j, board, player));
            }

        }
        if (re.size() == 0)
            if (checker.isValidMove(board, player, 9, 9))
                re.add(new Move(9, 9, board, player));
        return re;
    }

    private Move minMax(int board[][], boolean maximiser, int depth) {
        Vector<Move> moves;
        Move bestmove = null;

        if (depth == this.depth)
            return (new Move(-1, -1, board, this.player));

        if (maximiser) {
            if (checker.isLineVictory(board, player)) {
                bestmove = new Move(-1, -1, board, this.player);
                bestmove.value = 1000;
                return (bestmove);
            }
            if (checker.isLineVictory(board, opponent)) {
                bestmove = new Move(-1, -1, board, this.player);
                bestmove.value = -1000;
                return (bestmove);
            }
            moves = generateMoves(board, player);
        } else {
            if (checker.isLineVictory(board, opponent)) {
                bestmove = new Move(-1, -1, board, this.player);
                bestmove.value = 1000;
                return (bestmove);
            }
            if (checker.isLineVictory(board, player)) {
                bestmove = new Move(-1, -1, board, this.player);
                bestmove.value = -1000;
                return (bestmove);
            }
            moves = generateMoves(board, opponent);
        }
        for (Iterator<Move> i = moves.iterator(); i.hasNext(); ) {
            Move move = (Move) i.next();
            Move branch = minMax(move.getBoard(), !maximiser, depth + 1);
            if (branch != null) {
                if (bestmove == null || branch.value > bestmove.value) {
                    bestmove = move;
                    bestmove.value = branch.value;
                }
            }
        }
        return bestmove;
    }

    public String play(int board[][]) {

        Move m = minMax(board, true, 0);
        if (m != null)
            return (m.x + "," + m.y);
        else return (null);
    }
}
