package ic.snakeai.Controllers;

import android.media.audiofx.DynamicsProcessing;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import ic.snakeai.Activities.LoginActivity;
import ic.snakeai.Models.UserModel;
import ic.snakeai.R;
import ic.snakeai.Services.UserService;

public class LoginController {

    public static void loginAction(final LoginActivity loginActivity) throws EmptyFieldException, IncorrectLoginData {

        String userName="";
        String userPassword="";
        Integer userMaxScore=0;

        String admin_username = "admin";
        String admin_password = "admin";

        // get the reference of TextView's
        loginActivity.username = loginActivity.findViewById(R.id.edit_txt_username);
        loginActivity.password = loginActivity.findViewById(R.id.edit_txt_password);
        loginActivity.btn_login = loginActivity.findViewById(R.id.btn_login);
        loginActivity.btn_no_account = loginActivity.findViewById(R.id.btn_no_account);
        loginActivity.btn_back = loginActivity.findViewById(R.id.btn_back);

        if (TextUtils.isEmpty(loginActivity.username.getText().toString()) || TextUtils.isEmpty(loginActivity.password.getText().toString()))
        {

        }
        else if (loginActivity.username.getText().toString().equals(admin_username)) {
            if (loginActivity.password.getText().toString().equals(admin_password)) {
                {

                }
            }
            } else
            {

            }

        try {
            String pathJSONFile = "users.json";
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(pathJSONFile);
            // fetch JSONObject named password
            JSONObject user = obj.getJSONObject("user");
            // get employee name, password and max score
            userName = user.getString("name");
            userPassword = user.getString("password");
            userMaxScore = user.getInt("maxScore");

            /*
            userName.setText("Name: "+ userName);
            userPassword.setText("password: "+userPassword);
            userMaxScore.setText("maxScore: "+userMaxScore);
            */
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserService.checkEmptyField(userName,userPassword);
        UserService.checkUsernameAlreadyExist(userName);
        UserService.checkLoginCredentials(userName,userPassword);
        //UserService.updateJSON(loginActivity, user);
    }
}
