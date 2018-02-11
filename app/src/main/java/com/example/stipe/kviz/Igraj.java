package com.example.stipe.kviz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Igraj extends AppCompatActivity {

    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion,txtQuestionNum,textPercentage;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;
    float percentage;
    int corr,tot;
    DbHelper db;
    RadioGroup grp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igraj);
        db=new DbHelper(this);
        DataStorageQuestions.allQuestionsList=db.getRandomQuestions();
        currentQ=DataStorageQuestions.allQuestionsList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView2);
        txtQuestionNum=(TextView)findViewById(R.id.textView);
        rda=(RadioButton)findViewById(R.id.radioButton);
        rdb=(RadioButton)findViewById(R.id.radioButton2);
        rdc=(RadioButton)findViewById(R.id.radioButton3);
        rdd=(RadioButton)findViewById(R.id.radioButton4);
        butNext=(Button)findViewById(R.id.bttnNext);
        textPercentage=(TextView)findViewById(R.id.textPercentage);

        setQuestionView();
        setNextQuestion();

    }

    private void missedAnswer(){

        tot=currentQ.getTotal();
        currentQ.setTotal(++tot);
        db.updatePercentage(currentQ);
        qid++;
        if (qid < Question.numOfQuestions) {
            currentQ = DataStorageQuestions.allQuestionsList.get(qid);
            setQuestionView();

        } else {
            Intent intent = new Intent(Igraj.this, Kraj.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }

    }

    private void setQuestionView()
    {

        percentage=(float)currentQ.getCorrect()/currentQ.getTotal();
        if(percentage<=0.3){

            textPercentage.setText("Tesko pitanje");

        }
        else if(percentage>0.3&&percentage<0.7){

            textPercentage.setText("Srednje tesko pitanje");
        }
        else{

            textPercentage.setText("Lagano pitanje");

        }
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        txtQuestionNum.setText(String.valueOf(qid+1)+"/"+String.valueOf(Question.numOfQuestions));


    }

    private void setNextQuestion(){


        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grp=(RadioGroup)findViewById(R.id.radioGroup);
                int grpId=grp.getCheckedRadioButtonId();

                if(grpId==-1){

                    missedAnswer();

                }
                else {
                    RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                    grp.clearCheck();
                    if (currentQ.getANSWER().equals(answer.getText())){
                        Toast.makeText(getApplicationContext(),"Tocno!",Toast.LENGTH_SHORT).show();
                        score++;
                        corr=currentQ.getCorrect();
                        currentQ.setCorrect(++corr);
                    }
                    else{

                        Toast.makeText(getApplicationContext(),"Krivo! Tocan odgovor je "+currentQ.getANSWER().toString(),Toast.LENGTH_SHORT).show();
                    }

                   missedAnswer();

                }

            }
        });


    }

}
