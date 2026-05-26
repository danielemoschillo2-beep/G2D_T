package VRM.entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import VRM.main.ControlloTastiera;
import VRM.main.GamePanel;

public class Player extends Entity {

    GamePanel gp;
    ControlloTastiera keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public Player(GamePanel gp, ControlloTastiera keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direzione = "Giu";

    }

    public void getPlayerImage() {

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/VRM/res/player/boy_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // public void getPlayerImage() {

    // try {

    // File f1 = new File("./src/player/boy_up_1.png");
    // File f2 = new File("./src/player/boy_up_2.png");

    // File f3 = new File("./src/player/boy_down_1.png");
    // File f4 = new File("./src/player/boy_down_2.png");

    // File f5 = new File("./src/player/boy_left_1.png");
    // File f6 = new File("./src/player/boy_left_2.png");

    // File f7 = new File("./src/player/boy_right_1.png");
    // File f8 = new File("./src/player/boy_right_2.png");

    // up1 = ImageIO.read(f1);
    // up2 = ImageIO.read(f2);

    // down1 = ImageIO.read(f3);
    // down2 = ImageIO.read(f4);

    // left1 = ImageIO.read(f5);
    // left2 = ImageIO.read(f6);

    // right1 = ImageIO.read(f7);
    // right2 = ImageIO.read(f8);

    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    public void update() {

        if (keyH.movimentoSU == true || keyH.movimentoDestra == true ||
                keyH.movimentoGiu == true || keyH.movimentoSinistra == true) {

            if (keyH.movimentoSU == true) {
                direzione = "SU";

            } else if (keyH.movimentoGiu == true) {
                direzione = "Giu";

            } else if (keyH.movimentoDestra == true) {
                direzione = "Destra";

            } else if (keyH.movimentoSinistra == true) {
                direzione = "Sinistra";

            }
            // vede se sbatte contro qualcosa
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // vede se sbattimo contro oggetti
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // se la collsione è false il giocatore non deve potersi muovere
            if (collisionOn == false) {
                switch (direzione) {
                    case "SU":
                        worldY -= speed;
                        break;
                    case "Giu":
                        worldY += speed;
                        break;
                    case "Destra":
                        worldX += speed;
                        break;
                    case "Sinistra":
                        worldX -= speed;
                        break;
                }

            }

            spriteCounter++;
            if (spriteCounter > 13) { // fa cambiare l'immagine
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

    }

    public void pickUpObject(int i) {
        if (i != 999) {

            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("Hai trovato una chiave! Ora ne hai " + hasKey);
                    break;
                case "door":
                    if (hasKey > 0) {
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    System.out.println("Hai " + hasKey + " chiavi!");
                    break;
                case "Boots":
                    gp.playSE(2);
                    speed += 2;
                    gp.obj[i] = null;
                    System.out.println("Hai trovato degli stivali! Ora la tua velocità è " + speed);
                    break;
            }

        }
    }

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.WHITE);

        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direzione) {
            case "SU":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "Giu":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "Destra":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "Sinistra":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

}
