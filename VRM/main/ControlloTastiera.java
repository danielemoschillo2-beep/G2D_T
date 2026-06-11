package VRM.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlloTastiera implements KeyListener {

    GamePanel gp;
    public boolean movimentoSu, movimentoGiu, movimentoDestra, movimentoSinistra;
    // Debug
    public boolean checkDrawTime = false;

    public ControlloTastiera(GamePanel gamePanel) {
        this.gp = gamePanel;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {

            movimentoSu = true;
        }
        if (code == KeyEvent.VK_S) {

            movimentoGiu = true;
        }
        if (code == KeyEvent.VK_A) {

            movimentoSinistra = true;
        }
        if (code == KeyEvent.VK_D) {

            movimentoDestra = true;
        }
        if (code == KeyEvent.VK_P) {

            if (gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }

        // Debug
        if (code == KeyEvent.VK_T) {
            if (checkDrawTime == false) {
                checkDrawTime = true;
            } else if (checkDrawTime == true) {
                checkDrawTime = false;
            }
        }

    }

    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {

            movimentoSu = false;
        }
        if (code == KeyEvent.VK_S) {

            movimentoGiu = false;
        }
        if (code == KeyEvent.VK_A) {

            movimentoSinistra = false;
        }
        if (code == KeyEvent.VK_D) {

            movimentoDestra = false;
        }

    }

}
