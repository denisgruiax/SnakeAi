package ic.snakeai.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import ic.snakeai.R;


public class ProfileActivity extends AppCompatActivity {


    TextView name, mail;
    Button logout, playgame;
    ImageView image_profile;
    Bitmap bmImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        playgame=findViewById(R.id.playgame);
        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        image_profile=findViewById(R.id.profile_image);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);

        if(signInAccount != null){
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());

            /*URL url = null;
            try {
                url = new URL(signInAccount.getPhotoUrl().toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                bmImage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            image_profile.setImageBitmap(bmImage);*/
            Log.d("ImageURL: ", signInAccount.getPhotoUrl().toString());
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intent);
            }
        });
    }
}
