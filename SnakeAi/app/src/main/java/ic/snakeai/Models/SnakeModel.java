package ic.snakeai.Models;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import ic.snakeai.Models.SnakePartModel;

import java.util.ArrayList;

public class SnakeModel {
    private Bitmap bitMap, bmHeadDown, bmHeadLeft, bmHeadRight, bmHeadUp,
            bmBodyVertical, bmBodyHorizontal, bmBodyBottomLeft, bmBodyBottomRight, bmBodyTopLeft, bmBodyTopRight,
            bmTailUp, bmTailDown, bmTailRight, bmTailLeft;

    private ArrayList<SnakePartModel> arrPartSnake = new ArrayList<>();
    private int length;
    private boolean moveLeft, moveRight, moveUp, moveDown;

    public SnakeModel(Bitmap bitMap, int x, int y, int length) {
        this.bitMap = bitMap;
        this.length = length;
        bmBodyBottomLeft = Bitmap.createBitmap(bitMap, 0, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmBodyBottomRight = Bitmap.createBitmap(bitMap, bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmBodyHorizontal = Bitmap.createBitmap(bitMap, 2* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmBodyTopLeft = Bitmap.createBitmap(bitMap, 3* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmBodyTopRight = Bitmap.createBitmap(bitMap, 4* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmBodyVertical = Bitmap.createBitmap(bitMap, 5* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmHeadDown = Bitmap.createBitmap(bitMap, 6* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmHeadLeft = Bitmap.createBitmap(bitMap, 7* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmHeadRight = Bitmap.createBitmap(bitMap, 8* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmHeadUp = Bitmap.createBitmap(bitMap, 9* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmTailUp = Bitmap.createBitmap(bitMap, 10* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmTailRight = Bitmap.createBitmap(bitMap, 11* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmTailLeft = Bitmap.createBitmap(bitMap, 12* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        bmTailDown = Bitmap.createBitmap(bitMap, 13* bitMap.getWidth()/14, 0, bitMap.getWidth()/14, bitMap.getHeight());
        setMoveRight(true);
        arrPartSnake.add(new SnakePartModel(bmHeadRight, x, y));
        for (int i = 1; i < length-1; i++){
            this.arrPartSnake.add(new SnakePartModel(bmBodyHorizontal, this.arrPartSnake.get(i-1).getX()- GameModel.sizeElementMap, y));
        }
        arrPartSnake.add(new SnakePartModel(bmTailRight, arrPartSnake.get(length-2).getX()- GameModel.sizeElementMap, arrPartSnake.get(length-2).getY()));
    }

    public void update(){
        for(int i = length-1; i > 0; i--){
            arrPartSnake.get(i).setX(arrPartSnake.get(i-1).getX());
            arrPartSnake.get(i).setY(arrPartSnake.get(i-1).getY());
        }
        if(moveRight){
            arrPartSnake.get(0).setX(arrPartSnake.get(0).getX()+ GameModel.sizeElementMap);
            arrPartSnake.get(0).setBitMap(bmHeadRight);
        }else if(moveDown){
            arrPartSnake.get(0).setY(arrPartSnake.get(0).getY()+ GameModel.sizeElementMap);
            arrPartSnake.get(0).setBitMap(bmHeadDown);
        }else if(moveUp){
            arrPartSnake.get(0).setY(arrPartSnake.get(0).getY()- GameModel.sizeElementMap);
            arrPartSnake.get(0).setBitMap(bmHeadUp);
        }else{
            arrPartSnake.get(0).setX(arrPartSnake.get(0).getX()- GameModel.sizeElementMap);
            arrPartSnake.get(0).setBitMap(bmHeadLeft);
        }
        for (int i = 1; i < length - 1; i++){
            if(arrPartSnake.get(i).getRectLeft().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectBottom().intersect(arrPartSnake.get(i-1).getRectBody())
                    ||arrPartSnake.get(i).getRectBottom().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectLeft().intersect(arrPartSnake.get(i-1).getRectBody())){
                arrPartSnake.get(i).setBitMap(bmBodyBottomLeft);
            }else if (arrPartSnake.get(i).getRectLeft().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectTop().intersect(arrPartSnake.get(i-1).getRectBody())
                    ||arrPartSnake.get(i).getRectLeft().intersect(arrPartSnake.get(i-1).getRectBody())
                    &&arrPartSnake.get(i).getRectTop().intersect(arrPartSnake.get(i+1).getRectBody())){
                arrPartSnake.get(i).setBitMap(bmBodyTopLeft);
            }else if (arrPartSnake.get(i).getRectRight().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectTop().intersect(arrPartSnake.get(i-1).getRectBody())
                    ||arrPartSnake.get(i).getRectRight().intersect(arrPartSnake.get(i-1).getRectBody())
                    &&arrPartSnake.get(i).getRectTop().intersect(arrPartSnake.get(i+1).getRectBody())) {
                arrPartSnake.get(i).setBitMap(bmBodyTopRight);
            }else if(arrPartSnake.get(i).getRectRight().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectBottom().intersect(arrPartSnake.get(i-1).getRectBody())
                    ||arrPartSnake.get(i).getRectRight().intersect(arrPartSnake.get(i-1).getRectBody())
                    &&arrPartSnake.get(i).getRectBottom().intersect(arrPartSnake.get(i+1).getRectBody())){
                arrPartSnake.get(i).setBitMap(bmBodyBottomRight);
            }else if(arrPartSnake.get(i).getRectLeft().intersect(arrPartSnake.get(i-1).getRectBody())
                    &&arrPartSnake.get(i).getRectRight().intersect(arrPartSnake.get(i+1).getRectBody())
                    ||arrPartSnake.get(i).getRectLeft().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectRight().intersect(arrPartSnake.get(i-1).getRectBody())){
                arrPartSnake.get(i).setBitMap(bmBodyHorizontal);
            }else if(arrPartSnake.get(i).getRectTop().intersect(arrPartSnake.get(i-1).getRectBody())
                    &&arrPartSnake.get(i).getRectBottom().intersect(arrPartSnake.get(i+1).getRectBody())
                    ||arrPartSnake.get(i).getRectTop().intersect(arrPartSnake.get(i+1).getRectBody())
                    &&arrPartSnake.get(i).getRectBottom().intersect(arrPartSnake.get(i-1).getRectBody())){
                arrPartSnake.get(i).setBitMap(bmBodyVertical);
            }else{
                if(moveRight){
                    arrPartSnake.get(i).setBitMap(bmBodyHorizontal);
                }else if(moveDown){
                    arrPartSnake.get(i).setBitMap(bmBodyVertical);
                }else if(moveUp){
                    arrPartSnake.get(i).setBitMap(bmBodyVertical);
                }else{
                    arrPartSnake.get(i).setBitMap(bmBodyHorizontal);
                }
            }
        }
        if(arrPartSnake.get(length-1).getRectRight().intersect(arrPartSnake.get(length-2).getRectBody())){
            arrPartSnake.get(length-1).setBitMap(bmTailRight);
        }else if(arrPartSnake.get(length-1).getRectLeft().intersect(arrPartSnake.get(length-2).getRectBody())){
            arrPartSnake.get(length-1).setBitMap(bmTailLeft);
        }else if(arrPartSnake.get(length-1).getRectBottom().intersect(arrPartSnake.get(length-2).getRectBody())){
            arrPartSnake.get(length-1).setBitMap(bmTailDown);
        }else{
            arrPartSnake.get(length-1).setBitMap(bmTailUp);
        }
    }

    public void drawSnake(Canvas canvas){
        for(int i = length-1; i >= 0; i--){
            canvas.drawBitmap(arrPartSnake.get(i).getBitMap(), arrPartSnake.get(i).getX(), arrPartSnake.get(i).getY(), null);
        }
    }

    public Bitmap getBitMap() {
        return bitMap;
    }

    public void setBitMap(Bitmap bitMap) {
        this.bitMap = bitMap;
    }

    public Bitmap getBmHeadDown() {
        return bmHeadDown;
    }

    public void setBmHeadDown(Bitmap bmHeadDown) {
        this.bmHeadDown = bmHeadDown;
    }

    public Bitmap getBmHeadLeft() {
        return bmHeadLeft;
    }

    public void setBmHeadLeft(Bitmap bmHeadLeft) {
        this.bmHeadLeft = bmHeadLeft;
    }

    public Bitmap getBmHeadRight() {
        return bmHeadRight;
    }

    public void setBmHeadRight(Bitmap bmHeadRight) {
        this.bmHeadRight = bmHeadRight;
    }

    public Bitmap getBmHeadUp() {
        return bmHeadUp;
    }

    public void setBmHeadUp(Bitmap bmHeadUp) {
        this.bmHeadUp = bmHeadUp;
    }

    public Bitmap getBmBodyVertical() {
        return bmBodyVertical;
    }

    public void setBmBodyVertical(Bitmap bmBodyVertical) {
        this.bmBodyVertical = bmBodyVertical;
    }

    public Bitmap getBmBodyHorizontal() {
        return bmBodyHorizontal;
    }

    public void setBmBodyHorizontal(Bitmap bmBodyHorizontal) {
        this.bmBodyHorizontal = bmBodyHorizontal;
    }

    public Bitmap getBmBodyBottomLeft() {
        return bmBodyBottomLeft;
    }

    public void setBmBodyBottomLeft(Bitmap bmBodyBottomLeft) {
        this.bmBodyBottomLeft = bmBodyBottomLeft;
    }

    public Bitmap getBmBodyBottomRight() {
        return bmBodyBottomRight;
    }

    public void setBmBodyBottomRight(Bitmap bmBodyBottomRight) {
        this.bmBodyBottomRight = bmBodyBottomRight;
    }

    public Bitmap getBmBodyTopLeft() {
        return bmBodyTopLeft;
    }

    public void setBmBodyTopLeft(Bitmap bmBodyTopLeft) {
        this.bmBodyTopLeft = bmBodyTopLeft;
    }

    public Bitmap getBmBodyTopRight() {
        return bmBodyTopRight;
    }

    public void setBmBodyTopRight(Bitmap bmBodyTopRight) {
        this.bmBodyTopRight = bmBodyTopRight;
    }

    public Bitmap getBmTailUp() {
        return bmTailUp;
    }

    public void setBmTailUp(Bitmap bmTailUp) {
        this.bmTailUp = bmTailUp;
    }

    public Bitmap getBmTailDown() {
        return bmTailDown;
    }

    public void setBmTailDown(Bitmap bmTailDown) {
        this.bmTailDown = bmTailDown;
    }

    public Bitmap getBmTailRight() {
        return bmTailRight;
    }

    public void setBmTailRight(Bitmap bmTailRight) {
        this.bmTailRight = bmTailRight;
    }

    public Bitmap getBmTailLeft() {
        return bmTailLeft;
    }

    public void setBmTailLeft(Bitmap bmTailLeft) {
        this.bmTailLeft = bmTailLeft;
    }

    public ArrayList<SnakePartModel> getArrPartSnake() {
        return arrPartSnake;
    }

    public void setArrPartSnake(ArrayList<SnakePartModel> arrPartSnake) {
        this.arrPartSnake = arrPartSnake;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.setup();
        this.moveLeft = moveLeft;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.setup();
        this.moveRight = moveRight;
    }

    public boolean isMoveUp() {
        return moveUp;
    }

    public void setMoveUp(boolean moveUp) {
        this.setup();
        this.moveUp = moveUp;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.setup();
        this.moveDown = moveDown;
    }

    public void setup(){
        this.moveRight = false;
        this.moveDown = false;
        this.moveLeft = false;
        this.moveUp = false;
    }

    public void addPart() {
        SnakePartModel p = this.arrPartSnake.get(length-1);
        this.length += 1;
        if(p.getBitMap()== bmTailRight){
            this.arrPartSnake.add(new SnakePartModel(bmTailRight, p.getX()- GameModel.sizeElementMap, p.getY()));
        }else if(p.getBitMap()== bmTailLeft){
            this.arrPartSnake.add(new SnakePartModel(bmTailLeft, p.getX()+ GameModel.sizeElementMap, p.getY()));
        }else if(p.getBitMap()== bmTailUp){
            this.arrPartSnake.add(new SnakePartModel(bmTailUp, p.getX(), p.getY()+ GameModel.sizeElementMap));
        }else if(p.getBitMap()== bmTailDown){
            this.arrPartSnake.add(new SnakePartModel(bmTailUp, p.getX(), p.getY()- GameModel.sizeElementMap));
        }
    }
}

