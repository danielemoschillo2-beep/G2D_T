package VRM.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlloTastiera implements KeyListener {

    GamePanel gp;
    public boolean movimentoSu, movimentoGiu, movimentoDestra, movimentoSinistra;
    public boolean enterPressed;
    // Debug
    public boolean checkDrawTime = false;

    public ControlloTastiera(GamePanel gamePanel) {
        this.gp = gamePanel;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // Menu principale
        if (gp.gameState == gp.titleState) {

            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNum == 1) {
                    // DOPO
                }
                if (gp.ui.commandNum == 2) {
                    System.exit(0);
                }
            }
        }

        // palyState
        if (gp.gameState == gp.playState) {

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
        // PAUSA
        else if (gp.gameState == gp.pauseState) {

            if (code == KeyEvent.VK_P) {

                if (gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                }
            }

        }
        // DIALOGO
        else if (gp.gameState == gp.dialogueState) {

            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
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
        if (code == KeyEvent.VK_ENTER) {

            enterPressed = true;
        }

    }

}
