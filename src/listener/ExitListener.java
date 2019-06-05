package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExitListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }
}
