package com.example.stipe.kviz;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    EditText editQuest,editAns1,editAns2,editAns3,editAns4;
    Button bttnAdd;
    DbHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        editQuest=(EditText)findViewById(R.id.editQuest);
        editAns1=(EditText)findViewById(R.id.editAns1);
        editAns2=(EditText)findViewById(R.id.editAns2);
        editAns3=(EditText)findViewById(R.id.editAns3);
        editAns4=(EditText)findViewById(R.id.editAns4);
        bttnAdd=(Button)findViewById(R.id.bttnAdd);
       helper=new DbHelper(getApplicationContext());

        bttnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkInput()) {
                    db = helper.getWritableDatabase();
                    Question newQuest = new Question(editQuest.getText().toString(), editAns1.getText().toString(), editAns2.getText().toString(), editAns3.getText().toString(), editAns4.getText().toString(), editAns4.getText().toString());
                    helper.addQuestionToDb(newQuest, db);
                    Toast.makeText(getApplicationContext(), "Pitanje dodano", Toast.LENGTH_LONG).show();
                }

            }
        });




    }

    private boolean checkInput(){

        if(editQuest.getText().toString().equals("")||editAns1.getText().toString().equals("")||editAns2.getText().toString().equals("")||editAns3.getText().toString().equals("")||editAns4.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Molimo popunite sva polja",Toast.LENGTH_LONG).show();
            return false;

        }
        if(editQuest.getText().toString().equals(editAns1.getText().toString())||editQuest.getText().toString().equals(editAns2.getText().toString())||
                editQuest.getText().toString().equals(editAns3.getText().toString())||editQuest.getText().toString().equals(editAns4.getText().toString()))
        {
            Toast.makeText(getApplicationContext(),"Polja ne smiju biti ista",Toast.LENGTH_SHORT).show();
            return false;
        }
            return true;

    }
}
