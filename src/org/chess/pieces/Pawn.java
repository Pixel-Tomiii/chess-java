package org.chess.pieces;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(int position, PieceColor color) {
        super(position, color, 1);
    }

    @Override
    public List<Integer> getMoves(Piece[] board) {
        return null;
    }
}
