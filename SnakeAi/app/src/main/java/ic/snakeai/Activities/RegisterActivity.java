package ic.snakeai.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import ic.snakeai.Controllers.RegisterController;
import ic.snakeai.MainActivity;
import ic.snakeai.R;

public class RegisterActivity extends AppCompatActivity {

    public static Button btn_register;
    public static EditText username;
    public static EditText password;
    public static Button btn_back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        username = findViewById(R.id.edit_txt_username);
        password = findViewById(ic.snakeai.R.id.edit_txt_password);
        btn_register = findViewById(ic.snakeai.R.id.btn_register);

        btn_register.setOnClickListener(view -> {
            try {
                this.registerAction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            } catch (IncorrectLoginData incorrectLoginData) {
                incorrectLoginData.printStackTrace();
            }
        });

        btn_back.setOnClickListener(view -> {
            goToMainActivity();
        });
    }

    public void onStart() {
        super.onStart();
    }

    public void registerAction() throws InterruptedException, EmptyFieldException, IncorrectLoginData {
        RegisterController.registerAction(this);
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