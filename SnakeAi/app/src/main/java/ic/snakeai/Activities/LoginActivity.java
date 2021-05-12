package ic.snakeai.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import ic.snakeai.MainActivity;
import ic.snakeai.R;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*
*  The LoginActivity handles the user login in the game.
*
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class LoginActivity extends AppCompatActivity {
    public Button btn_back; //Back button from the loginActivity view
    private GoogleSignInClient googleSignInClient; //googleSignInClient object
    private static final int RC_SIGN_IN = 123;
    private FirebaseAuth firebaseAuth; //Used firebaseAuth

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
    * OnStart Function in Android:
    *   When activity start getting visible to user then onStart() will be called.
    *
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    protected void onStart(){
        super.onStart();

        //Get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //If the user is valid, start the activity
        if (user!=null){
            Intent intent = new Intent(getApplicationContext(), Profile.class);
            startActivity(intent);
        }
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * ** * * *
     *
     * onCreate(Bundle savedInstanceState) Function in Android:
     *  After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate the activity and load all data from savedInstanceState.
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Set the login view - activity_login layout
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        createRequest();

        //If the login button "btn_login" is clicked, then the user should be logged in
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }



    private void signIn(){

    }

    private void createRequest(){

    }
}