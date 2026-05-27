package VRM.main;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import VRM.oggetti.OBJ_Key;

public class UI {

    GamePanel gp;
    Font arial_40, arial_80B;
    Font arial_30;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 30);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        arial_30 = new Font("Arial", Font.BOLD, 28);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        if (gameFinished == true) {

            g2.setFont(arial_40);
            g2.setColor(java.awt.Color.white);

            String text;
            int x;
            int y;
            int textLength;

            text = "bravo hai finito sei forte!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(java.awt.Color.white);
            text = "GOAT!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight / 2 + (gp.tileSize * 3);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        } else {

            g2.setFont(arial_40);
            g2.setColor(java.awt.Color.white);

            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString(" x " + gp.player.hasKey, 58, 65);

            // messaggio
            if (messageOn == true) {

                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
                messageCounter++;
                if (messageCounter > 100) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

        }

        // Timer in alto a destra
        drawTimer(g2);

    }

    private void drawTimer(Graphics2D g2) {
        long elapsedSeconds = gp.getElapsedTime();
        long minutes = elapsedSeconds / 60;
        long seconds = elapsedSeconds % 60;

        String timerText = String.format("%02d:%02d", minutes, seconds);

        g2.setFont(arial_30);
        g2.setColor(java.awt.Color.yellow);

        // Calcola la posizione per allinearlo a destra
        int timerWidth = g2.getFontMetrics().stringWidth(timerText);
        int x = gp.screenWidth - timerWidth - 30;
        int y = 50;

        g2.drawString(timerText, x, y);
    }

}
