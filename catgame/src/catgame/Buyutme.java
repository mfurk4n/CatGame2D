package catgame;

public class Buyutme {

    private int buyutX;
    private int pixbuyutX;
    private int buyutY;

    public Buyutme(int buyutX, int pixbuyutX, int buyutY) {
        this.buyutX = buyutX;
        this.pixbuyutX = pixbuyutX;
        this.buyutY = buyutY;
    }

    public void buyutAksiyon() {
        int rannum1 = (int) (Math.random() * 5300);
        this.buyutX = buyutX - pixbuyutX;
        if (buyutX <= -35) {
            buyutY = rannum1 / 10;
            buyutX = 1010;
        }
    }

    public int getBuyutX() {
        return buyutX;
    }

    public void setBuyutX(int buyutX) {
        this.buyutX = buyutX;
    }

    public int getPixbuyutX() {
        return pixbuyutX;
    }

    public void setPixbuyutX(int pixbuyutX) {
        this.pixbuyutX = pixbuyutX;
    }

    public int getBuyutY() {
        return buyutY;
    }

    public void setBuyutY(int buyutY) {
        this.buyutY = buyutY;
    }
}
