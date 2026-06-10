package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

import VRM.main.GamePanel;

public class OBJ_Chest extends SuperOggetti {

    GamePanel gp;

    public OBJ_Chest(GamePanel gp) {

        this.gp = gp;

        name = "chest";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/chest.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
