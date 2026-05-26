package VRM.oggetti;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperOggetti {

    public OBJ_Door() {

        name = "door";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/VRM/res/oggetti/door.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;

    }

}
