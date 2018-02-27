package com.example.stipe.kviz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    Button bttnplay, bttnHigh, bttnAdmin;
    EditText username;
    SharedPreferences sharedPrefs;
    String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefs = this.getSharedPreferences("MyPreferences", MODE_PRIVATE);

        bttnplay = (Button) findViewById(R.id.bttnPlay);
        bttnHigh = (Button) findViewById(R.id.bttnHighscore);
        username = (EditText) findViewById(R.id.editText);
        bttnAdmin = (Button) findViewById(R.id.buttonAdmin);

        bttnplay.setOnClickListener(myListener);
        bttnAdmin.setOnClickListener(myListener);
        bttnHigh.setOnClickListener(myListener);
    }

    private boolean chckUser() {

        if (username.getText().toString().equals("")) {

            Toast.makeText(getApplicationContext(), "Molimo unesite korisnicko ime", Toast.LENGTH_LONG).show();
            return false;

        } else {
            return true;
        }
    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.buttonAdmin:
                    getDialog();
                    break;

                case R.id.bttnHighscore:

                    Intent myIntenthigh = new Intent(MainActivity.this, Lista.class);
                    startActivity(myIntenthigh);
                    break;

                case R.id.bttnPlay:
                    if (chckUser()) {
                        Intent myIntentToPlay = new Intent(MainActivity.this, Igraj.class);
                        sharedPrefs.edit().putString("username", username.getText().toString()).apply();

                        startActivity(myIntentToPlay);
                    }
                    break;
                default:
                    break;
            }
        }
    };

    private void getDialog() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Upisite lozinku");
        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                if (m_Text.equals("f+2")) {

                    Intent myIntentAdmin = new Intent(MainActivity.this, Admin.class);
                    startActivity(myIntentAdmin);

                } else {

                    Toast.makeText(getApplicationContext(), "Pogresna lozinka", Toast.LENGTH_LONG).show();

                }
            }
        });
        builder.setNegativeButton("Povratak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
