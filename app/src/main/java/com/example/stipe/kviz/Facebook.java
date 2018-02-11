package com.example.stipe.kviz;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.Share;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class Facebook extends AppCompatActivity {

    Button bttnShare;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    LoginManager login;
    Bitmap image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        setupFacebookShareIntent();


    }
    public void setupFacebookShareIntent() {
       callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        shareDialog = new ShareDialog(this);


        image=BitmapFactory.decodeResource(getResources(),R.drawable.logo);

        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).setCaption("Imam ostvarenih ").build();


            SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();

            shareDialog.show(content);
        }

  /*  public void setupFacebookShareIntent() {
        callbackManager = CallbackManager.Factory.create();
        FacebookSdk.sdkInitialize(getApplicationContext());
        shareDialog = new ShareDialog(this);


        image=BitmapFactory.decodeResource(getResources(),R.drawable.hajduk);

        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).setCaption("Imam ostvarenih ").build();


        SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();

        shareDialog.show(content);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
