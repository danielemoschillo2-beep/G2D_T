package VRM.entity;

import java.util.Random;

import VRM.main.GamePanel;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direzione = "Giu";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void setDialogue() {

        dialogues[0] = "Ciao ragazzo!";
        dialogues[1] = "Ti consiglio di esplorare il villaggio.";
        dialogues[2] = "Ci sono molti segreti da scoprire.";
        dialogues[3] = "Buona fortuna!";

    }

    public void getImage() {

        up1 = setup("/VRM/res/npc/oldman_up_1");
        up2 = setup("/VRM/res/npc/oldman_up_2");
        down1 = setup("/VRM/res/npc/oldman_down_1");
        down2 = setup("/VRM/res/npc/oldman_down_2");
        left1 = setup("/VRM/res/npc/oldman_left_1");
        left2 = setup("/VRM/res/npc/oldman_left_2");
        right1 = setup("/VRM/res/npc/oldman_right_1");
        right2 = setup("/VRM/res/npc/oldman_right_2");

    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(100) + 1; // da 1 a 100

            if (i <= 25) {
                direzione = "Su";
            }
            if (i > 25 && i <= 50) {
                direzione = "Giu";
            }
            if (i > 50 && i <= 75) {
                direzione = "Sinistra";
            }
            if (i > 75) {
                direzione = "Destra";
            }

            actionLockCounter = 0;
        }
    }

    public void speak() {

        super.speak();

    }

}
