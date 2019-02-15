package ml.zarkmedia.heapptrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
Button btnUser;
    private FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btnUser=(Button)findViewById(R.id.button_herbaluser);
    }





    public void btnUserclick(View v){

        //CHECK IF THE USER IS LOGGED IN
        firebaseAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public  void  onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(MainActivity.this, MainActivityUser.class);
                    startActivity(intent);
                   // Toast.makeText( "You are Welcome"+String.user,Toast.LENGTH_SHORT).show();
                   // finish();
                }
                else{
                    Intent i=new Intent(MainActivity.this, MainActivityUserLogin.class);
                    startActivity(i);
                }
            }
        };
        //checking the logged in user stops here

    }
}
