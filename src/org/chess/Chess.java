package org.chess;

import org.chess.board.Tile;
import org.chess.pieces.Piece;
import org.chess.pieces.PieceColor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess {
    public Tile[] board;

    public void resetBoard() {
        loadBoard("default");
    }

    public boolean loadBoard(String boardName) {
        board = new Tile[64];

        for (int pos = 0; pos < 64; pos++) {
            board[pos] = new Tile(pos);
        }

        try {
            Scanner fileReader = new Scanner(new File("assets/positions/" + boardName + ".txt"));
            String input = fileReader.nextLine();
            fileReader.close();

            int position = 0;
            int amount = 0;
            PieceColor color = null;

            for (char item:input.toCharArray()) {
                // Read number.
                if (item >= '0' && item <= '9') {
                    amount *= 10;
                    amount += item - 48;
                    System.out.println(position);
                    System.out.println(amount);
                }
                else {
                    if (item != '.') {

                        // Set the color of the piece.
                        if (color == null) {
                            color = item == 'b' ? PieceColor.BLACK : PieceColor.WHITE;
                            continue;
                        }

                        // Add the piece(s) to the board.
                        for (int offset = 0; offset < amount; offset++) {
                            board[position].setPiece(Piece.create(item, color, position));
                            board[position].setText(Character.toString(item));
                            position++;
                        }

                    // Update position.
                    } else {
                        position += amount;
                    }
                    amount = 0;
                    color = null;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
