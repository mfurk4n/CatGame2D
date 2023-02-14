package catgame;

import java.io.IOException;
import javax.swing.JFrame;

public class OyunPanel extends JFrame {

    public static void main(String[] args) throws IOException {
        JFrame ekran = new JFrame();
        ekran.setTitle("TEKİR");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setLocation(250, 100);
        ekran.setSize(1000, 630);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OyunMekanik oyun = new OyunMekanik();
        oyun.requestFocus();
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        ekran.add(oyun);
        ekran.setVisible(true);

    }
}
