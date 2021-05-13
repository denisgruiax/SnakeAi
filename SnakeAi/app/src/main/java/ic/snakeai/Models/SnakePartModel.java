package ic.snakeai.Models;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class SnakePartModel {
    private Bitmap bitMap;
    private int x, y;
    private Rect rectBody, rectTop, rectBottom, rectRight, rectLeft;

    public SnakePartModel(Bitmap bitMap, int x, int y) {
        this.bitMap = bitMap;
        this.x = x;
        this.y = y;
    }

    public Bitmap getBitMap() {
        return bitMap;
    }

    public void setBitMap(Bitmap bitMap) {
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

    public Rect getRectTop() {
        return new Rect(this.x, this.y-10* ConstantsModel.SCREEN_HEIGHT/1920, this.x+ GameModel.sizeElementMap, this.y);
    }

    public void setRectTop(Rect rectTop) {
        this.rectTop = rectTop;
    }

    public Rect getRectBottom() {
        return new Rect(this.x, this.y + GameModel.sizeElementMap, this.x + GameModel.sizeElementMap, this.y + GameModel.sizeElementMap+10* ConstantsModel.SCREEN_HEIGHT/1920);
    }

    public void setRectBottom(Rect rectBottom) {
        this.rectBottom = rectBottom;
    }

    public Rect getRectRight() {
        return new Rect(this.x + GameModel.sizeElementMap, this.y, this.x + GameModel.sizeElementMap+10* ConstantsModel.SCREEN_WIDTH/1080, this.y+ GameModel.sizeElementMap);
    }

    public void setRectRight(Rect rectRight) {
        this.rectRight = rectRight;
    }

    public Rect getRectLeft() {
        return new Rect(this.x - 10* ConstantsModel.SCREEN_WIDTH/1080, this.y, this.x, this.y + GameModel.sizeElementMap);
    }

    public void setRectLeft(Rect rectLeft) {
        this.rectLeft = rectLeft;
    }

    public Rect getRectBody() {
        return new Rect(this.x, this.y, this.x + GameModel.sizeElementMap, this.y + GameModel.sizeElementMap);
    }

    public void setRectBody(Rect rectBody) {
        this.rectBody = rectBody;
    }
}
