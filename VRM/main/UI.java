package VRM.main;

import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    GamePanel gp;
    Font arial_40;
    Font arial_30;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 30);
        arial_30 = new Font("Arial", Font.BOLD, 28);
    }

    public void draw(Graphics2D g2) {

        g2.setFont(arial_40);
        g2.setColor(java.awt.Color.white);
        g2.drawString("Chiavi: " + gp.player.hasKey, 50, 50);

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
