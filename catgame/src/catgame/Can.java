package catgame;

public class Can {

    private int x;
    private int pixX;
    private int y;

    public Can(int x, int pixX, int y) {
        this.x = x;
        this.pixX = pixX;
        this.y = y;
    }

    public void canAksiyon() {
        int rannum = (int) (Math.random() * 465);
        this.x = x - pixX;
        if (x <= -50) {

            y = rannum;
            x = 1720;

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
