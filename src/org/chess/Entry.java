package org.chess;

import org.chess.board.Tile;

import javax.swing.*;
import java.awt.*;

public class Entry {
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.resetBoard();

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {}

        JFrame window = new JFrame("Chess");
        JPanel board = new JPanel();
        JPanel background = new JPanel();
        background.add(board);
        board.setSize(640, 640);

        GridLayout boardLayout = new GridLayout();
        boardLayout.setColumns(8);
        boardLayout.setRows(8);
        boardLayout.setHgap(0);
        boardLayout.setVgap(0);

        board.setLayout(boardLayout);
        board.setPreferredSize(new Dimension(640, 640));
        board.setMinimumSize(new Dimension(640, 640));
        // board.setBackground(Color.BLACK);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 700);

        for (Tile tile:chess.board) {
            board.add(tile);
        }
        window.add(background, BorderLayout.CENTER);

        window.setVisible(true);

    }
}
