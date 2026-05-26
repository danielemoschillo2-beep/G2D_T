package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperOggetti {

    public OBJ_Key() {

        name = "Key";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/key.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
