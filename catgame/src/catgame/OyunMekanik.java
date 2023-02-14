package catgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OyunMekanik extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(5, this);

    private BufferedImage kedi;
    private BufferedImage can1, can2, can3, can4, can5, can6, can7, can8, can9, can10;
    private BufferedImage buyut;
    private BufferedImage kucult;
    private BufferedImage kurukafa;

    private int kediY = 0;
    private int pixKediY = 6;
    private int kediX = 0;
    private int boy = 480;
    private int kediCan = 10;

    private int randomCan1 = (int) (Math.random() * 465);
    private int randomCan2 = (int) (Math.random() * 465);
    private int randomKuruKafa1 = (int) (Math.random() * 490);
    private int randomKuruKafa2 = (int) (Math.random() * 490);
    private int randomKuruKafa3 = (int) (Math.random() * 490);
    private int randomKuruKafa4 = (int) (Math.random() * 490);
    private int randomKucult1 = (int) (Math.random() * 530);
    private int randomKucult2 = (int) (Math.random() * 530);
    private int randomBuyut1 = (int) (Math.random() * 530);
    private int randomBuyut2 = (int) (Math.random() * 530);
    private int randomDizi1 = (int) (Math.random() * 6);
    private int randomDizi2 = (int) (Math.random() * 5 + 5);

    private int buyutKontrol = 1;
    private int gecenSure = 0;
    private float sureKontrol;
    private int hiz1 = 2;
    private int hiz2 = 3;

    ArrayList<Can> canlar = new ArrayList<>();

    Kucultme kucult1 = new Kucultme(1010, 2, randomKucult1);
    Kucultme kucult2 = new Kucultme(1510, 2, randomKucult2);
    Buyutme buyut1 = new Buyutme(1260, 2, randomBuyut1);
    Buyutme buyut2 = new Buyutme(1760, 2, randomBuyut2);
    KuruKafa kurukafa1 = new KuruKafa(1135, 2, randomKuruKafa1);
    KuruKafa kurukafa2 = new KuruKafa(1385, 2, randomKuruKafa2);
    KuruKafa kurukafa3 = new KuruKafa(1635, 2, randomKuruKafa3);
    KuruKafa kurukafa4 = new KuruKafa(1885, 2, randomKuruKafa4);
    Can can1nesne = new Can(1720, hiz2, randomCan2);

    public boolean carpisma(int carpX, int carpY, int carpWidth, int carpHeight) {
        if (new Rectangle(kediX, kediY, (kedi.getWidth() - boy), (kedi.getHeight() - (boy + 250)))
                .intersects(new Rectangle(carpX, carpY, (carpWidth), (carpHeight)))) {

            return true;
        }
        return false;
    }

    public boolean saniyeAyarla() {
        sureKontrol = gecenSure / 1000;
        if (gecenSure / sureKontrol == 1000) {
            return true;
        }
        return false;
    }

    public OyunMekanik() throws IOException {

        kedi = ImageIO.read(new FileImageInputStream(new File("kedi.png")));
        buyut = ImageIO.read(new FileImageInputStream(new File("buyut.png")));
        kucult = ImageIO.read(new FileImageInputStream(new File("kucult.png")));
        kurukafa = ImageIO.read(new FileImageInputStream(new File("kurukafa.png")));
        can1 = ImageIO.read(new FileImageInputStream(new File("can1.png")));
        can2 = ImageIO.read(new FileImageInputStream(new File("can2.png")));
        can3 = ImageIO.read(new FileImageInputStream(new File("can3.png")));
        can4 = ImageIO.read(new FileImageInputStream(new File("can4.png")));
        can5 = ImageIO.read(new FileImageInputStream(new File("can5.png")));
        can6 = ImageIO.read(new FileImageInputStream(new File("can6.png")));
        can7 = ImageIO.read(new FileImageInputStream(new File("can7.png")));
        can8 = ImageIO.read(new FileImageInputStream(new File("can8.png")));
        can9 = ImageIO.read(new FileImageInputStream(new File("can9.png")));
        can10 = ImageIO.read(new FileImageInputStream(new File("can10.png")));

        setBackground(Color.BLACK);

        timer.start();

        canlar.add(new Can(1060, hiz1, randomCan1));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // To change body of generated methods, choose Tools | Templates.
        gecenSure += 5;

        BufferedImage[] candizi = {can1, can2, can3, can4, can5, can6, can7, can8, can9, can10};
        int[] canboydizi = {8, 10, 12, 14, 16, 18, 20, 22, 24, 26};

        g.drawImage(kedi, kediX, kediY, kedi.getWidth() - boy, kedi.getHeight() - (boy + 250), this);
        g.drawImage(kucult, kucult1.getKucultX(), kucult1.getKucultY(), kucult.getWidth() / 5, kucult.getHeight() / 5,
                this);
        g.drawImage(kucult, kucult2.getKucultX(), kucult2.getKucultY(), kucult.getWidth() / 5, kucult.getHeight() / 5,
                this);
        g.drawImage(buyut, buyut1.getBuyutX(), buyut1.getBuyutY(), buyut.getWidth() / 5, buyut.getHeight() / 5, this);
        g.drawImage(buyut, buyut2.getBuyutX(), buyut2.getBuyutY(), buyut.getWidth() / 5, buyut.getHeight() / 5, this);
        g.drawImage(kurukafa, kurukafa1.getX(), kurukafa1.getY(), kurukafa.getWidth() / 7, kurukafa.getHeight() / 7,
                this);
        g.drawImage(kurukafa, kurukafa2.getX(), kurukafa2.getY(), kurukafa.getWidth() / 7, kurukafa.getHeight() / 7,
                this);
        g.drawImage(kurukafa, kurukafa3.getX(), kurukafa3.getY(), kurukafa.getWidth() / 7, kurukafa.getHeight() / 7,
                this);
        g.drawImage(kurukafa, kurukafa4.getX(), kurukafa4.getY(), kurukafa.getWidth() / 7, kurukafa.getHeight() / 7,
                this);
        g.drawImage(candizi[randomDizi2], can1nesne.getX(), can1nesne.getY(),
                candizi[randomDizi2].getWidth() / canboydizi[randomDizi2],
                candizi[randomDizi2].getHeight() / canboydizi[randomDizi2], this);

        for (Can canlist : canlar) {
            if (canlist.getX() <= -50) {
                canlar.remove(canlist);
                randomDizi1 = (int) (Math.random() * 6);
                randomCan1 = (int) (Math.random() * 465);
                canlar.add(new Can(1060, hiz1, randomCan1));

            }
        }

        for (Can canlist : canlar) {
            g.drawImage(candizi[randomDizi1], canlist.getX(), canlist.getY(),
                    candizi[randomDizi1].getWidth() / canboydizi[randomDizi1],
                    candizi[randomDizi1].getHeight() / canboydizi[randomDizi1], this);
        }

        for (Can canlist : canlar) {
            if (carpisma(canlist.getX(), canlist.getY(), candizi[randomDizi1].getWidth() / canboydizi[randomDizi1],
                    candizi[randomDizi1].getHeight() / canboydizi[randomDizi1])) {
                canlist.setX(-200);
                kediCan = kediCan + ((randomDizi1 + 1) * buyutKontrol);
            }
        }
        if (can1nesne.getX() <= -45
                || carpisma(can1nesne.getX(), can1nesne.getY(), candizi[randomDizi2].getWidth() / canboydizi[randomDizi2],
                        candizi[randomDizi2].getHeight() / canboydizi[randomDizi2])) {
            randomDizi2 = (int) (Math.random() * 5 + 5);
        }

        if (carpisma(can1nesne.getX(), can1nesne.getY(), candizi[randomDizi2].getWidth() / canboydizi[randomDizi2],
                candizi[randomDizi2].getHeight() / canboydizi[randomDizi2])) {
            kediCan = kediCan + ((randomDizi2 + 1) * buyutKontrol);
            can1nesne.setX(-45);

        }

        if (carpisma(kurukafa1.getX() + 15, kurukafa1.getY() + 10, kurukafa.getWidth() / 7,
                kurukafa.getHeight() / 7 - 15)
                || carpisma(kurukafa2.getX() + 15, kurukafa2.getY() + 10, kurukafa.getWidth() / 7,
                        kurukafa.getHeight() / 7 - 15)
                || carpisma(kurukafa3.getX() + 15, kurukafa3.getY() + 10, kurukafa.getWidth() / 7,
                        kurukafa.getHeight() / 7 - 15)
                || carpisma(kurukafa4.getX() + 15, kurukafa4.getY() + 10, kurukafa.getWidth() / 7,
                        kurukafa.getHeight() / 7 - 15)) {
            timer.stop();
            String message = "           OYUN BİTTİ";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }

        if (carpisma(buyut1.getBuyutX(), buyut1.getBuyutY(), buyut.getWidth() / 5, buyut.getHeight() / 5)) {
            buyut1.setBuyutX(1045 + kedi.getWidth() - boy);
            if (boy > 456) {
                boy = boy - 6;

            }
            if (buyutKontrol <= 4) {
                buyutKontrol += 1;

            }

        }
        if (carpisma(buyut2.getBuyutX(), buyut2.getBuyutY(), buyut.getWidth() / 5, buyut.getHeight() / 5)) {
            buyut2.setBuyutX(1045 + kedi.getWidth() - boy);
            if (boy > 456) {
                boy = boy - 6;
            }
            if (buyutKontrol <= 4) {
                buyutKontrol += 1;
            }

        }
        if (carpisma(kucult1.getKucultX(), kucult1.getKucultY(), kucult.getWidth() / 5, kucult.getHeight() / 5)) {
            kucult1.setKucultX(1045 + kedi.getWidth() - boy);
            if (boy < 504) {
                boy = boy + 6;
            }
            if (buyutKontrol > 1) {
                buyutKontrol -= 1;
            }
        }

        if (carpisma(kucult2.getKucultX(), kucult2.getKucultY(), kucult.getWidth() / 5, kucult.getHeight() / 5)) {
            kucult2.setKucultX(1045 + kedi.getWidth() - boy);
            if (boy < 504) {
                boy = boy + 6;
            }
            if (buyutKontrol > 1) {
                buyutKontrol -= 1;
            }
        }

        if (saniyeAyarla()) {
            kediCan = kediCan - 1;
            if (kediCan == -1) {
                timer.stop();
                String message = "           OYUN BİTTİ";
                JOptionPane.showMessageDialog(this, message);
                System.exit(0);

            }
        }

        if (buyut1.getBuyutX() < 2500) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString("Geçen Süre: " + gecenSure / 1000, 850, 585);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString("Kedinin Ömrü: " + kediCan, 10, 585);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString("Ömür Bonus :*" + buyutKontrol, 435, 585);
            g.drawLine(0, 566, 1010, 566);
        }

    }

    @Override
    public void repaint() {
        super.repaint(); // To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int harf = e.getKeyCode();

        if (harf == KeyEvent.VK_UP) {
            if (kediY <= 0) {
                kediY = 0;
            } else {
                kediY -= pixKediY;

            }
        } else if (harf == KeyEvent.VK_DOWN) {

            int a = kediY + kedi.getHeight() - (boy + 250);
            if (a >= 566) {
                a = 566;
            } else {
                kediY += pixKediY;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buyut1.buyutAksiyon();
        kucult1.kucultAksiyon();
        buyut2.buyutAksiyon();
        kucult2.kucultAksiyon();
        kurukafa1.kurukafaAksiyon();
        kurukafa2.kurukafaAksiyon();
        kurukafa3.kurukafaAksiyon();
        kurukafa4.kurukafaAksiyon();
        can1nesne.canAksiyon();
        for (Can canlist : canlar) {
            canlist.setX(canlist.getX() - canlist.getPixX());
        }

        repaint();
    }

}
