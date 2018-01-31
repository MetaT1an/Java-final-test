package one.model;

import javafx.scene.image.Image;

public class Queen {
    private int x;
    private int y;
    private Image image;

    public Queen(int x,int y){
        this.x = x;
        this.y = y;
        this.image = new Image("one/picture/blackQueen.png");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
