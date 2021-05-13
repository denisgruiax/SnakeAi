package ic.snakeai.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ic.snakeai.Models.GameModel;
import ic.snakeai.Models.ConstantsModel;
import ic.snakeai.R;

public class GameActivity extends AppCompatActivity {
    public static Dialog dialogScore;
    private GameModel game_model;
    public static TextView txt_score, txt_best_score, txt_dialog_score, txt_dialog_best_score;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        ConstantsModel.SCREEN_WIDTH = dm.widthPixels;
        ConstantsModel.SCREEN_HEIGHT = dm.heightPixels;
        setContentView(R.layout.activity_game);
        game_model =(GameModel) findViewById(R.id.game_model);
        txt_score = (TextView) findViewById(R.id.txt_score);
        txt_best_score = (TextView) findViewById(R.id.txt_best_score);
        dialogScore();
    }

    private void dialogScore(){
        int bestScore = 0;
        SharedPreferences sp = this.getSharedPreferences("gamesetting", Context.MODE_PRIVATE);
        if(sp!=null){
            bestScore = sp.getInt("bestscore",0);
        }
        GameActivity.txt_best_score.setText(bestScore + " ");
        dialogScore = new Dialog(this);
        dialogScore.setContentView(R.layout.dialog_view);
        txt_dialog_score = dialogScore.findViewById(R.id.txt_dialog_score);
        txt_dialog_best_score = dialogScore.findViewById(R.id.txt_dialog_best_score);
        txt_dialog_best_score.setText(bestScore + "");
        dialogScore.setCanceledOnTouchOutside(false);
        RelativeLayout rl_start = dialogScore.findViewById(R.id.rl_start);
        rl_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game_model.reset();
                dialogScore.dismiss();
            }
        });
        dialogScore.show();
    }
}
