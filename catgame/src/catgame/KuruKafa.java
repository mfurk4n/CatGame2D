package catgame;

public class KuruKafa {

    private int x;
    private int pixX;
    private int y;

    public KuruKafa(int x, int pixX, int y) {
        this.x = x;
        this.pixX = pixX;
        this.y = y;
    }

    public void kurukafaAksiyon() {
        int rannumk = (int) (Math.random() * 4900);
        this.x = x - pixX;
        if (x <= -35) {

            y = rannumk / 10;
            x = 1010;

        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getPixX() {
        return pixX;
    }

    public void setPixX(int pixX) {
        this.pixX = pixX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
