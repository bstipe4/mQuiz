package com.example.stipe.kviz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.facebook.CallbackManager;

import com.facebook.FacebookSdk;

import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Kraj extends AppCompatActivity {

    Button bttnPlay;
    Button bttnMenu;
    TextView user,t;
    SharedPreferences sharedPrefs;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    int score;
    ShareButton shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kraj);


        t = (TextView) findViewById(R.id.txtResult);
        user=(TextView)findViewById(R.id.txtUser);
        bttnPlay=(Button)findViewById(R.id.bttnPlay);
        bttnMenu=(Button)findViewById(R.id.bttnMenu);
        shareButton = (ShareButton)findViewById(R.id.shareBttn);
        sharedPrefs=this.getSharedPreferences("MyPreferences",MODE_PRIVATE);
        DbHelper db=new DbHelper(this);
        Bundle b = getIntent().getExtras();
        score = b.getInt("score");
        String username =sharedPrefs.getString("username",null);

        user.setText(username);
        t.setText("Ostvaren rezultat: "+String.valueOf(score));
        db.addPlayer(username,score);

        shareOnFb();
        bttnMenu.setOnClickListener(myListener);
        bttnPlay.setOnClickListener(myListener);


    }

    private View.OnClickListener myListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.bttnPlay:
                    Intent myIntentPlay=new Intent(Kraj.this,Igraj.class);

                    startActivity(myIntentPlay);
                    finish();
                    break;

                case R.id.bttnMenu:
                    Intent myIntentMenu=new Intent(Kraj.this,MainActivity.class);
                    startActivity(myIntentMenu);
                    finish();
                    break;

                    default:
                        break;

            }
        }
    };

    public void shareOnFb() {

        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        shareDialog = new ShareDialog(this);


        //Bitmap image=BitmapFactory.decodeResource(getResources(),R.drawable.logo);

        //SharePhoto photo = new SharePhoto.Builder().setCaption("Imam ostvarenih "+String.valueOf(score)+" bodova na mQuiz! Pridruzite se i vi ovoj zabavnoj igrici!").setBitmap(image).build();

        //SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();


        ShareLinkContent content = new ShareLinkContent.Builder()
                .setQuote("Imam ostvarenih "+String.valueOf(score)+" bodova na mQuiz! Pridruzite se i vi ovoj zabavnoj igrici!")
                .setContentUrl(Uri.parse("https://image.ibb.co/mdd9MS/logo.png"))
                .build();


        shareButton.setShareContent(content);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}

