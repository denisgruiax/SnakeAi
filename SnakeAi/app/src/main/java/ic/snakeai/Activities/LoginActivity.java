package ic.snakeai.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        }
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
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

        //Get an instance by calling getInstance()
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

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
     * createRequest Function
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private void createRequest(){
        GoogleSignInOptions googleSignInOptions = new  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
     * signIn Function:
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private void signIn(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        //By using the android startActivityForResult() method, we can send information from one activity to another and vice-versa
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
     * onActivityResult Function:
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data); //It redirects to another activity

        if(requestCode == RC_SIGN_IN){
            Task task = GoogleSignIn.getSignedInAccountFromIntent(data); //Returns a GoogleSignInAccount present in the result data for the associated Activity started via getSignInIntent().

            try {
                GoogleSignInAccount account = (GoogleSignInAccount) task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            }catch (ApiException exception){
                Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
     * firebaseAuthWithGoogle Function:
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private void firebaseAuthWithGoogle(GoogleSignInAccount account){
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener() {
                    public void onComplete(@NonNull Task task){
                        if(task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Sorry auth failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
     * goToMainActivity Function:
     *  Redirects the user to the MainActivity if the back button is pressed while in LoginActivity
     *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public void goToMainActivity() {
        //If the back button "btn_back" is clicked, then the user should be redirected from the login view (LoginActivity) to the main view (MainActivity)
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}