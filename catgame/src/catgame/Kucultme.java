package catgame;

public class Kucultme {

    private int kucultX;
    private int pixkucultX;
    private int kucultY;

    public Kucultme(int kucultX, int pixkucultX, int kucultY) {
        this.kucultX = kucultX;
        this.pixkucultX = pixkucultX;
        this.kucultY = kucultY;
    }

    public void kucultAksiyon() {
        int rannum2 = (int) (Math.random() * 5300);
        this.kucultX = kucultX - pixkucultX;

        if (kucultX <= -35) {
            kucultY = rannum2 / 10;
            kucultX = 1010;
        }
    }

    public int getKucultX() {
        return kucultX;
    }

    public void setKucultX(int kucultX) {
        this.kucultX = kucultX;
    }

    public int getPixkucultX() {
        return pixkucultX;
    }

    public void setPixkucultX(int pixkucultX) {
        this.pixkucultX = pixkucultX;
    }

    public int getKucultY() {
        return kucultY;
    }

    public void setKucultY(int kucultY) {
        this.kucultY = kucultY;
    }

}
