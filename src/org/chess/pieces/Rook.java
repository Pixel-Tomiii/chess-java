package org.chess.pieces;

import java.util.List;

public class Rook extends Piece {
    public Rook(int position, PieceColor color) {
        super(position, color, 5);
    }

    @Override
    public List<Integer> getMoves(Piece[] board) {
        return null;
    }
}
