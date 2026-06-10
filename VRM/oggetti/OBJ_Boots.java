package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

import VRM.main.GamePanel;

public class OBJ_Boots extends SuperOggetti {

    GamePanel gp;

    public OBJ_Boots(GamePanel gp) {

        this.gp = gp;

        name = "Boots";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/boots.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
