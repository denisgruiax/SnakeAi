package ic.snakeai.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import ic.snakeai.Controllers.LoginController;
import ic.snakeai.MainActivity;
import ic.snakeai.R;

public class LoginActivity extends AppCompatActivity {

    public EditText username;
    public EditText password;
    public Button btn_no_account;
    public Button btn_login;
    public Button btn_back;

    String admin_username = "admin";
    String admin_password = "admin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login=(Button) findViewById(R.id.btn_login);
        btn_no_account=(Button) findViewById(R.id.btn_no_account);
        btn_back=(Button) findViewById(R.id.btn_back);

        btn_login.setOnClickListener(view -> {
            try {
                loginAction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            } catch (IncorrectLoginData incorrectLoginData) {
                incorrectLoginData.printStackTrace();
            }
         });

        btn_no_account.setOnClickListener(view -> {
             goToRegisterActivity();
        });

        btn_back.setOnClickListener(view -> {
            goToMainActivity();
        });
    }

    public void loginAction() throws InterruptedException, EmptyFieldException, IncorrectLoginData {
        LoginController.loginAction(this);
    }

    public void goToRegisterActivity()
    {
        btn_no_account.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
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