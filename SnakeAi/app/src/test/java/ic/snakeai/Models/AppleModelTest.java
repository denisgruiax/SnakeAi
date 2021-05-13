package ic.snakeai.Models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import org.junit.Test;

import ic.snakeai.R;

import static org.junit.Assert.assertEquals;

public class AppleModelTest {

    AppleModel apple = new AppleModel(null, 100,200);
    @Test
    public void getXTest(){
        assertEquals(100, apple.getX());
    }

    @Test
    public void getYTest(){
        assertEquals(200, apple.getY());
    }
}
