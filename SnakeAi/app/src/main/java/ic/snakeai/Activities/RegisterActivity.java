package ic.snakeai.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ic.snakeai.Exceptions.EmptyFieldException;
import ic.snakeai.Exceptions.IncorrectLoginData;
import ic.snakeai.MainActivity;
import ic.snakeai.R;

public class RegisterActivity extends AppCompatActivity {

    public EditText edit_txt_username;
    public EditText edit_txt_password;
    public Button btn_register;
    public Button btn_back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_txt_username = (EditText) findViewById(R.id.edit_txt_username);
        edit_txt_password = (EditText) findViewById(R.id.edit_txt_password);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_back = (Button) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(view -> {
            goToMainActivity();
        });
    }

    public void onStart() {
        super.onStart();
    }

    public void goToMainActivity()
    {
        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}