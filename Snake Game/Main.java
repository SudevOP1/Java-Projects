import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


class GameFrame extends JFrame {

    public GameFrame() {

        this.add(new GamePanel());
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}

class GamePanel extends JPanel implements ActionListener {

    JButton restartButton;

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = SCREEN_WIDTH * SCREEN_HEIGHT / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    public GamePanel() {

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
            // for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
            //     g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            //     g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            // }
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i=0; i<bodyParts; i++) {
                if(i==0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.RED);
            g.setFont(new Font("Consolas", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString(
                "Score: "+applesEaten,
                (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2,
                g.getFont().getSize()
            );
        }
        else {
            gameOver(g);
        }

    }
    public void newApple() {
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move() {
        for (int i = bodyParts; i>0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
        }
    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollision() {
        for(int i=bodyParts; i>0; i--) {
            // If body collides with the head
            if((x[0]==x[i]) && (y[0]==y[i])){
                running = false;
            }
            // If head collides with the left border
            else if(x[0]<0) {
                running = false;
            }
            // If head collides with the right border
            else if(x[0]>SCREEN_WIDTH) {
                running = false;
            }
            // If head collides with the top border
            else if(y[0]<0) {
                running = false;
            }
            // If head collides with the bottom border
            else if(y[0]>SCREEN_HEIGHT) {
                running = false;
            }
            if(!running) {
                timer.stop();
            }
        }
    }
    public void gameOver(Graphics g) {

        g.setColor(Color.RED);
        g.setFont(new Font("Consolas", Font.BOLD, 100));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString(
            "Game Over",
            (SCREEN_WIDTH - metrics1.stringWidth("Game Over"))/2,
            SCREEN_HEIGHT/2
            );

        g.setColor(Color.RED);
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString(
            "Your Score was: "+applesEaten,
            (SCREEN_WIDTH - metrics2.stringWidth("Your Score was: "+applesEaten))/2,
            140
        );

        restartButton = new JButton("Restart");
        restartButton.setBounds(200, 400, 200, 50);
        restartButton.setFont(new Font("Consolas", Font.BOLD, 30));
        restartButton.setBackground(Color.RED);
        restartButton.setFocusable(false);
        restartButton.addActionListener(this);
        this.add(restartButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(running) {
            move();
            checkApple();
            checkCollision();
        }
        repaint();

        if(e.getSource() == restartButton) {
            this.remove(restartButton);
            this.revalidate();
            this.repaint();
            new GameFrame();
        }

    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    } break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    } break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    } break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    } break;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        new GameFrame();
    }
}