package org.chess.pieces;

import java.util.List;

public abstract class Piece {
    protected int position;
    protected final int value;
    protected final PieceColor color;

    public Piece(int position, PieceColor color, int value) {
        this.position = position;
        this.value = value;
        this.color = color;
    }

    public abstract List<Integer> getMoves(Piece[] board);

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public PieceColor getColor() {
        return color;
    }

    public static Piece create(char type, PieceColor color, int position) {
        return switch (type) {
            case 'p' -> new Pawn(position, color);
            case 'n' -> new Knight(position, color);
            case 'b' -> new Bishop(position, color);
            case 'r' -> new Rook(position, color);
            case 'q' -> new Queen(position, color);
            case 'k' -> new King(position, color);
            default -> null;
        };
    }
}
