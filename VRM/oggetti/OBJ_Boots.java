package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperOggetti {

    public OBJ_Boots() {

        name = "Boots";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/boots.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
