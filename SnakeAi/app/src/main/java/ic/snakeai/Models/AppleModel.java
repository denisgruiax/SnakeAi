package ic.snakeai.Models;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class AppleModel {
    private Bitmap bitMap;
    private int x, y;
    private Rect rect;

    public AppleModel(Bitmap bitMap, int x, int y) {
        this.bitMap = bitMap;
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitMap, x, y, null);
    }

    public void reset(int nx, int ny){
        this.x = nx;
        this.y = ny;
    }

    public Bitmap getBitMap() {
        return bitMap;
    }

    public void setBm(Bitmap bitMap) {
        this.bitMap = bitMap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rect getRect() {
        return new Rect(this.x, this.y, this.x+ GameModel.sizeElementMap, this.y+ GameModel.sizeElementMap);
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
}
