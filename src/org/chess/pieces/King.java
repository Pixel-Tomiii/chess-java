package org.chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {


    public King(int position, PieceColor color) {
        super(position, color, 99);
    }

    @Override
    public List<Integer> getMoves(Piece[] board) {
        List<Integer> moves = new ArrayList<>();
        int[] possibleMoves = {
                position - 1,
                position + 1,
                position + 7,
                position + 8,
                position + 9,
                position - 7,
                position - 8,
                position - 9,
        };

        // Check which moves are valid.
        for (int move:possibleMoves) {
            if (move >= 0 && move <= 63) {

                // Need to check for attacked squares.
                if (board[move] == null) {
                    moves.add(move);
                }
            }
        }
        return moves;
    }
}
