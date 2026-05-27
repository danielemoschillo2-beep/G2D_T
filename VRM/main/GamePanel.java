package VRM.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import VRM.entity.Player;
import VRM.oggetti.SuperOggetti;
import VRM.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // sreen settings

    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // impostazioni world

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    // FPS
    int FPS = 60;

    // Timer
    public long gameStartTime = 0;
    public boolean isGameRunning = false;

    // Sistema
    TileManager tileM = new TileManager(this);
    ControlloTastiera keyH = new ControlloTastiera();
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    // entità e oggetti

    public Player player = new Player(this, keyH);
    public SuperOggetti obj[] = new SuperOggetti[10]; // numero di oggetti che possiamo avere

    // giocatore in posizione base (ci seerviva prima per vedere
    // se funzionava (prima della creazione delle mappe di gioco))

    // int playerX = 100;
    // int playerY = 100;
    // double playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setupGame() { // lo chiamiamo prima che il gameThred cominci

        aSetter.setObject();

        playMusic(0);
        startTimer();

    }

    public void startTimer() {
        gameStartTime = System.currentTimeMillis();
        isGameRunning = true;
    }

    public void stopTimer() {
        isGameRunning = false;
    }

    public long getElapsedTime() {
        if (!isGameRunning) return 0;
        return (System.currentTimeMillis() - gameStartTime) / 1000;
    }

    public void StartGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    // public void run() {

    // double drawInterval = 1000000000 / FPS;
    // double nextDrawTime = System.nanoTime() + drawInterval;

    // while (gameThread != null) {

    // update();
    // System.out.println(playerX);
    // System.out.println(playerY);

    // repaint();

    // try {
    // double remainingTime = nextDrawTime - System.nanoTime();
    // remainingTime = remainingTime / 1000000;

    // if (remainingTime < 0) {
    // remainingTime = 0;
    // }

    // Thread.sleep((long) remainingTime);

    // nextDrawTime += drawInterval;

    // } catch (InterruptedException e) {

    // e.printStackTrace();
    // }
    // }

    // }

    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {

                update();
                repaint();
                delta--;
                drawCount++;

            }

            if (timer >= 1000000000) {

                // System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;

            }

        }

    }

    public void update() {

        player.update();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // tile prima del player così non disegniamo sopra al personaggio
        tileM.draw(g2);

        // Oggetti
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) { // ci serve sapere se abbiamo uno slot oggetti vuoto oppure no
                obj[i].draw(g2, this);
            }
        }

        // giocatore
        player.draw(g2);

        // UI
        ui.draw(g2);

        g2.dispose();

    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();

    }

    public void stopMusic() {

        music.stop();

    }

    public void playSE(int i) {

        se.setFile(i);
        se.play();

    }

}
