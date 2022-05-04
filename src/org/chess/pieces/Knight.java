package org.chess.pieces;

import java.util.List;

public class Knight extends Piece {
    public Knight(int position, PieceColor color) {
        super(position, color, 3);
    }

    @Override
    public List<Integer> getMoves(Piece[] board) {
        return null;
    }
}
