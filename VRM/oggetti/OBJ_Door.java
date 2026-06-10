package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

import VRM.main.GamePanel;

public class OBJ_Door extends SuperOggetti {

    GamePanel gp;

    public OBJ_Door(GamePanel gp) {

        this.gp = gp;

        name = "door";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }

}
