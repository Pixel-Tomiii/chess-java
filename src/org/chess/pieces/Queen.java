package org.chess.pieces;

import java.util.List;

public class Queen extends Piece {
    public Queen(int position, PieceColor color) {
        super(position, color, 9);
    }

    @Override
    public List<Integer> getMoves(Piece[] board) {
        return null;
    }
}
