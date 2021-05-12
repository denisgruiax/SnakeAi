package ic.snakeai.Activities;
import ic.snakeai.MainActivity;
import ic.snakeai.R;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*
*  The LoginActivity handles the user login in the game.
*
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class LoginActivity extends AppCompatActivity {
    //Back button from the loginActivity view
    public Button btn_back;

    /* * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * * *
     *
    * OnStart Function in Android:
    *   When activity start getting visible to user then onStart() will be called.
    *
    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    protected void onStart(){
        super.onStart();
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