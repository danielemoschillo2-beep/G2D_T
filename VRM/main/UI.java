package VRM.main;

import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

    GamePanel gp;
    Font arial_40;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 30);
    }

    public void draw(Graphics2D g2) {

        g2.setFont(arial_40);
        g2.setColor(java.awt.Color.white);
        g2.drawString("Chiavi: " + gp.player.hasKey, 50, 50);

    }

}
