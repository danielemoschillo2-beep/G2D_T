package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

import VRM.main.GamePanel;

public class OBJ_Key extends SuperOggetti {

    GamePanel gp;

    public OBJ_Key(GamePanel gp) {

        this.gp = gp;

        name = "Key";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
