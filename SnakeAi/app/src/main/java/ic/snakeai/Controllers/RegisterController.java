package ic.snakeai.Controllers;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import ic.snakeai.Activities.LoginActivity;
import ic.snakeai.Activities.RegisterActivity;
import ic.snakeai.R;
import ic.snakeai.Services.UserService;

public class RegisterController {

    public static String username;
    public static String password;

    public static void registerAction(final RegisterActivity RegisterActivity) throws EmptyFieldException, IncorrectLoginData {

            String userName="";
            String userPassword="";

            // get the reference of TextView's
            RegisterActivity.username = RegisterActivity.findViewById(R.id.edit_txt_username);
            RegisterActivity.password = RegisterActivity.findViewById(R.id.edit_txt_password);
            RegisterActivity.btn_register = RegisterActivity.findViewById(R.id.btn_no_account);
            //btn_back = findViewById(ic.snakeai.R.id.btn_back);

            //change to write
            try {
                String pathJSONFile = "users.json";
                // get JSONObject from JSON file
                JSONObject obj = new JSONObject(pathJSONFile);
                // fetch JSONObject named password
                JSONObject user = obj.getJSONObject("user");
                // get employee name, password and max score
                userName = user.getString("name");
                userPassword = user.getString("password");

            /*
            // set employee name and salary in TextView's
            userName.setText("Name: "+ userName);
            userPassword.setText("password: "+userPassword);
            userMaxScore.setText("maxScore: "+userMaxScore);
            */
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
                //Toast.makeText(RegisterActivity.this, "Invalid credentials", Toast.LENGTH_LONG).show();

            UserService.checkEmptyField(userName,userPassword);
            UserService.checkUsernameAlreadyExist(userName);
            UserService.checkLoginCredentials(userName,userPassword);
                //ic.snakeai.Controllers.LoginController.updateJSON(loginActivity, user);
        }
}
