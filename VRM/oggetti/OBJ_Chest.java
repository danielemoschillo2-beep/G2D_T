package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperOggetti{


    public OBJ_Chest() {

        name = "chest";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/chest.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
