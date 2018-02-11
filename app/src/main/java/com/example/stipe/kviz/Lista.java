package com.example.stipe.kviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        DbHelper helper=new DbHelper(getApplicationContext());
        DataStorageUser.allUsersList=helper.getAllUsers();
        ListView listaUsera=(ListView)findViewById(R.id.listview);
        listaUsera.setAdapter(new ListAdapter(getApplicationContext()));

    }
}
