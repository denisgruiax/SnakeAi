package ic.snakeai.Activities;
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
    }
}