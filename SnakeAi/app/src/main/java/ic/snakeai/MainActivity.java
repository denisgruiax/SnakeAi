package ic.snakeai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ic.snakeai.Activities.ClassicGame;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void classicGame(View view){
        Intent classicGameActivity = new Intent(this, ClassicGame.class);
        startActivity(classicGameActivity);
        this.onPause();
    }

    public void aiGame(View view){

    }
}