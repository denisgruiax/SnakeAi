package ic.snakeai.Controllers;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.audiofx.DynamicsProcessing;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import Exceptions.EmptyFieldException;
import Exceptions.IncorrectLoginData;
import ic.snakeai.Activities.LoginActivity;
import ic.snakeai.Models.UserModel;
import ic.snakeai.R;
import ic.snakeai.Services.UserService;

public class LoginController {

    public static void loginAction(final LoginActivity loginActivity) throws EmptyFieldException, IncorrectLoginData {

        String userName = "";
        String userPassword = "";
        Integer userMaxScore = 0;
        ListView listView;
        ArrayList<UserModel> arrayList;
        String admin_username = "admin";
        String admin_password = "admin";

        // get the reference of TextView's
        loginActivity.username = loginActivity.findViewById(R.id.edit_txt_username);
        loginActivity.password = loginActivity.findViewById(R.id.edit_txt_password);
        loginActivity.btn_login = loginActivity.findViewById(R.id.btn_login);
        loginActivity.btn_no_account = loginActivity.findViewById(R.id.btn_no_account);
        loginActivity.btn_back = loginActivity.findViewById(R.id.btn_back);

        if (TextUtils.isEmpty(loginActivity.username.getText().toString()) || TextUtils.isEmpty(loginActivity.password.getText().toString())) {
            throw new EmptyFieldException();
        } else if (loginActivity.username.getText().toString().equals(admin_username)) {
            {
                //admin login
            }
        } else {
            //login
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UserService.checkEmptyField(userName, userPassword);
        UserService.checkUsernameAlreadyExist(userName);
        UserService.checkLoginCredentials(userName, userPassword);
        arrayList = new ArrayList<>();

        try {
            JSONObject object = new JSONObject(readJSON());
            JSONArray array = object.getJSONArray("users");
            for (int i = 0; i < array.length(); i++) {

                JSONObject jsonObject = array.getJSONObject(i);
                String username = jsonObject.getString("username");
                String password = jsonObject.getString("password");
                Integer score = jsonObject.getInt("score");

                UserModel model = new UserModel();
                model.setUsername(username);
                model.setPassword(password);
                model.setMaxScore(score);
                arrayList.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String readJSON() {
        String json = null;
        try {
            Context context = null;
            AssetManager manager = context.getAssets();
            InputStream inputStream = manager.open("users.json");
            // Opening data.json file
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            // read values in the byte array
            inputStream.read(buffer);
            inputStream.close();
            // convert byte to string
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }

}