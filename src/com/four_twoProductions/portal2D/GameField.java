package com.four_twoProductions.portal2D;

import com.four_twoProductions.portal2D.entities.*;
import com.four_twoProductions.portal2D.obstacles.*;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameField extends JPanel {

    public  static final int HORIZONTAL = 750;
    public static final int VERTICAL = 500;
    private Block[][] field;
    private int width;
    private int height;
    private int blockSize;
    public Player p;
    private static JFrame frame;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Block[width][height];
        blockSize = Math.min((HORIZONTAL - 50) / width, (VERTICAL - 45) / height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect( 10,10, blockSize * width, blockSize * height);

        for (int x = 0; x < this.field.length; x++) {
            for (int y = 0; y < this.field[0].length; y++) {
                if (field[x][y] != null) {
                    switch (field[x][y].getID()) {
                        case 1:
                            g.setColor(Color.black);
                            g.fillRect(x * blockSize + 10, y * blockSize + 10, blockSize, blockSize);
                            break;
                        case 2:
                            g.setColor(Color.black);
                            g.fillOval(x * blockSize + 10, y * blockSize + 10, blockSize, blockSize);
                            break;

                    }
                }
            }
        }

        if (this.p != null) {
            g.drawRect((int) (p.getX() * blockSize + 10), (int) (p.getY() * blockSize + 10), blockSize, blockSize);
            g.setColor(Color.red);
            g.fillRect((int) (p.getX() * blockSize + 10), (int) (p.getY() * blockSize + 10), blockSize, blockSize); // Spieler platzieren
        }
    }

    public void addObstacle(int x, int y, int ID) {
        switch (ID) {
            case 1:
                field[x][y] = new Wall(x, y);
                break;
            case 2:
                field[x][y] = new Pit(x,y);
                break;
        }
    }

    public void addPlayer(Player p){
        this.p = p;
    }
}

/*public KeyListener keyListener = new KeyListener() {
        @Override
        public void keyPressed(KeyEvent e) {
            String key = Character.toString(e.getKeyChar());
            if (key.equals("w")) p.move(0,-0.1);
            if (key.equals("a")) p.move(-0.1,0);
            if (key.equals("s")) p.move(0,0.1);
            if (key.equals("d")) p.move(0.1,0);
            e.getComponent().repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    };
*/