package org.chess.board;

import org.chess.Constants;
import org.chess.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JButton {

    private final int position;
    private Piece piece;
    private final Color color;


    public Tile(int position) {
        color = (((position % 8) % 2) + ((position / 8) % 2)) == 1 ? Constants.BLACK : Constants.WHITE;
        update();

        this.position = position;
    }

    /**
     * Updates the color of the tile and adds a mouse listener to register the
     * mouse hovering over the tile.
     */
    public void update() {
        setOpaque(true);
        setBackground(color);
        setBorderPainted(false);

        // Remove all mouse listeners (including default listeners).
        for (MouseListener event:getMouseListeners()) {
            removeMouseListener(event);
        }

        // Add mouse listener for registering mouse events.
        addMouseListener(new MouseAdapter() {

            public void refresh() {
                setVisible(false);
                setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(getBackground().darker());
                refresh();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(getBackground().brighter());
                refresh();
            }
        });
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public int hashCode() {
        return position;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Tile) {
            return position == ((Tile) other).position;
        }
        return false;
    }

    /**
     * Converts the position of the tile into its string coordinate.
     * @return  String of the coordinate (e.g. e4)
     */
    public String getName() {
        int column = position / 8;
        int row = position % 8;

        return new String(new char[] {(char) (97 + column), (char) (49 + row)});
    }

    public int getPosition() {
        return position;
    }

    /**
     * Converts a string coordinate to an integer position.
     * @param name  the coordinate (e.g. e4)
     * @return  integer position of the tile.
     */
    public static int getPosition(String name) {
        char column = name.charAt(0);
        char row = name.charAt(1);

        return ((column - 97) * 8) + (row - 49);
    }
}
