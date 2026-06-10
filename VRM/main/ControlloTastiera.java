package VRM.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlloTastiera implements KeyListener {

    public boolean movimentoSU, movimentoGiu, movimentoDestra, movimentoSinistra;
    // Debug
    public boolean checkDrawTime = false;

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {

            movimentoSU = true;
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

            movimentoSU = false;
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
