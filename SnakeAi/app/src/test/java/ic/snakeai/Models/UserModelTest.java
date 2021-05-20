package ic.snakeai.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserModelTest {
    UserModel user = new UserModel("denis", "123", (Integer)100);
    @Test
    public void testUsername(){
        assertEquals("denis", user.getUsername());
    }
    @Test
    public void testPassword(){
        assertEquals("123", user.getPassword());
    }
    @Test
    public void testMaxscore(){
        assertEquals((Integer)100, user.getMaxScore());
    }
}