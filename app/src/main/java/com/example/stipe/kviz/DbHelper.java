package com.example.stipe.kviz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;



public class DbHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;

        private static final String DATABASE_NAME = "mQuizBase";


        private SQLiteDatabase dbase;
        public DbHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            dbase=db;
            String sql = "CREATE TABLE IF NOT EXISTS " + Contract.ColumnNames.TABLE_QUEST + " ( "
                    + Contract.ColumnNames.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Contract.ColumnNames.KEY_QUES
                    + " TEXT, " + Contract.ColumnNames.KEY_ANSWER+ " TEXT, "+Contract.ColumnNames.KEY_OPTA +" TEXT, "
                    +Contract.ColumnNames.KEY_OPTB +" TEXT, "+Contract.ColumnNames.KEY_OPTC +" TEXT, "+Contract.ColumnNames.KEY_OPTD +" TEXT, "
                    +Contract.ColumnNames.KEY_TOTAL +" INTEGER, "+Contract.ColumnNames.KEY_CORRECT+" INTEGER)";

            String sq2 = "CREATE TABLE IF NOT EXISTS " + Contract.Highscores.TABLE_HIGHSCORES + " ( "
                    + Contract.Highscores.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Contract.Highscores.KEY_USERNAME
                    + " TEXT, " + Contract.Highscores.KEY_SCORE+" INTEGER)";

            db.execSQL(sql);
            db.execSQL(sq2);
            addQuestions();

        }
        private void addQuestions()
        {
            Question q1=new Question(" Tko je bio Salvador Dali?  "  ,"Slikar"  ,  "Pisac"  ,  "Glumac",  "Nogometaš"  ,  "Slikar" );
            this.addQuestion(q1);
            Question q2=new Question(" Kako se zove mitološko čudovište u kojem su sjedinjeni lav i orao?  "  ,"Jednorog"  ,  "Grifon"  ,  "Minotaur",  "Kentaur"  ,  "Grifon" );
            this.addQuestion(q2);
            Question q3=new Question(" Koji je narod prvi u Europi počeo upotrebljavati željezni mač?  "  ,"Normani"  ,  "Grci"  ,  "Turci",  "Rimljani"  ,  "Rimljani" );
            this.addQuestion(q3);
            Question q4=new Question(" Kojoj državi pripada Istočna Trakija do rijeke Marice?  "  ,"Turskoj"  ,  "Grčkoj"  ,  "Italiji",  "Rusiji"  ,  "Turskoj" );
            this.addQuestion(q4);
            Question q5=new Question(" Na kojem su polju 1242. Hrvati potukli Tatare?  "  ,"Grobničkom"  ,  "Mohačkom"  ,  "Moravskom",  "Radničkom"  ,  "Grobničkom" );
            this.addQuestion(q5);
            Question q6=new Question(" Površinu kruga rješava formula R na kvadrat...?  "  ,"pi"  ,  "3.141592654"  ,  "3.142",  "3.141552652"  ,  "pi" );
            this.addQuestion(q6);
            Question q7=new Question(" Koliko godina je trajao stogodišnji rat?  "  ,"99"  ,  "100"  ,  "116",  "133"  ,  "116" );
            this.addQuestion(q7);
            Question q8=new Question(" Koliko je visok najviši vrh Dinare u Hrvatskoj?  "  ,"1718"  ,  "2012"  ,  "1831",  "2117"  ,  "1831" );
            this.addQuestion(q8);
            Question q9=new Question(" Čiji kalendar počinje 7. siječnja 3761. g. pr. n. e.?  "  ,"Julijanski"  ,  "Rimski"  ,  "Židovski",  "Kršćanski"  ,  "Židovski" );
            this.addQuestion(q9);
            Question q10=new Question(" Prvi strip Andrije Maurovića bio je:  "  ,"vjerenica mača"  ,  "Trojca u mraku"  ,  "Podzemna carica",  "Ljubavnica s Marsa"  ,  "vjerenica mača" );
            this.addQuestion(q10);

            Question q11=new Question(" Tko je bio Eusebio?  "  ,"Slikar"  ,  "Pisac"  ,  "Glumac",  "Nogometaš"  ,  "Nogometaš" );
            this.addQuestion(q11);
            Question q12=new Question("Koliko je godina spavala Trnoružica? ?  "  ,"100"  ,  "50"  ,  "10",  "200"  ,  "100" );
            this.addQuestion(q12);
            Question q13=new Question("Iz gusjenice nastaje..."  ,"Leptir"  ,  "Bubamara"  ,  "Pauk",  "Muha"  ,  "Leptir" );
            this.addQuestion(q13);
            Question q14=new Question("Kojem drvetu ne otpada lišće u zimi?  "  ,"Bor"  ,  "Lipa"  ,  "Bukva",  "Hrast"  ,  "Bor" );
            this.addQuestion(q14);
            Question q15=new Question("Između Zemlje i Sunca nalaze se koliko planeta?  "  ,"4"  ,  "5"  ,  "3",  "2"  ,  "2" );
            this.addQuestion(q15);
            Question q16=new Question("Koga su zbog oholosti bogovi osudili na vječne muke - vječnu žeđ i glad? "  ,"Sizifa"  ,  "Prometeja"  ,  "Tantala",  "Tezeja"  ,  "Tantala" );
            this.addQuestion(q16);
            Question q17=new Question("Naziv za strah od mačaka je ... "  ," Brontofobija "  ,  " Felinofobija "  ,  " Hemofobija ",  " Ofidiofobija "  ,  " Felinofobija " );
            this.addQuestion(q17);
            Question q18=new Question("Motor kojeg automobila se i dalje sastavlja ručno? "  ," Lamborghini "  ,  " Mercedes "  ,  " Mustang ",  "Rolls Royce"  ,  "Rolls Royce" );
            this.addQuestion(q18);
            Question q19=new Question("Najdulja australska rijeka je...  "  ," Ganges "  ,  " Lena "  ,  " Murray ",  " Jenisej "  ,  " Murray " );
            this.addQuestion(q19);
            Question q20=new Question("Iz njegovog najpoznatijeg romana potječu tri lika: Athos, Porthos i Aramis. On je..."  ," Miquel de Cervantes "  ,  " Carlo Goldoni "  ,  " Alexandre Dumas ",  " Georg Orwell "  ,  " Alexandre Dumas " );
            this.addQuestion(q20);

            Question q21=new Question("Gdje se nalazi labirint u ljudskom tijelu?","U uhu","  U mozgu", "U probavilu ","U plućima ","U uhu");
            this.addQuestion(q21);
            Question q22=new Question("Koji je slavni zrakoplovac prvi preletio Sredozemno more, a po njegovom imenjaku se zove turnir u tenisu?", " Joseph Melbourne ", "  Mark Atp ","Roland Garros","Frank Wimbledon ","Roland Garros");
            this.addQuestion(q22);
            Question q23=new Question("Što je bio Kafkin Gregor Samsa prije nego se preobrazio u kukca? ","Trgovački putnik","Turistički agent  ","Vozač taksija"," Ulični čistač ","Trgovački putnik");
            this.addQuestion(q23);
            Question q24=new Question("Kako se zove osoba koja jezično-stilski uređuje rukopis? "," Recenzant ","Urednik ","Mentor ","Lektor","Lektor");
            this.addQuestion(q24);
            Question q25=new Question("Kako se zove sporazum između svjetovne i crkvene vlasti?  ","Sabor ","Konkordat","Koncil  ","Povelja ","Konkordat") ;
            this.addQuestion(q25);
            Question q26=new Question("Tko je ne samo Edipova sestra nego i rođena kći?   ","Antigona","Domenika ","Helena  ","Julija ","Antigona");
            this.addQuestion(q26);
            Question q27=new Question("Čija je sestra bila Jelena, žena kralja Dmitra Zvonimira?  ","Habsburškog kralja  ","Mađarskog kralja","Austrijskog kralja","Češkog kralja   ","Mađarskog kralja");
            this.addQuestion(q27);
            Question q28=new Question("Postupak u kojem se meso i povrće prije prženja umoče u razmučena jaja, brašno i mrvice? ","Maliranje  ","Omekšavanje ","Flambiranje ","Paniranje","Paniranje");
            this.addQuestion(q28);
            Question q29=new Question("Odsječeš joj glavu, a njoj narastu dvije? ","Virnjak ","Kopljača ","Trakavica   ","Hidra","Hidra");
            this.addQuestion(q29);
            Question q30=new Question("Najmanja kost, nalazi se u uhu? ","Stremen","Čekić  ","Nakovanj "," Bubnjić ","Stremen");
            this.addQuestion(q30);


            Question q31=new Question("Kako se zove vrlo utjecajna osoba?","Krupna riba","Bijela riba", "Slana riba","Plava riba","Krupna riba");
            this.addQuestion(q31);
            Question q32=new Question("Kako glasi narodni naziv za Veneru?", "Katica", "Marica","Slavica","Danica","Danica");
            this.addQuestion(q32);
            Question q33=new Question("\"Labuđe jezero\" P.Iliča Čajkovskog je...","Simfonija","Balet","Mjuzikl","Opereta","Balet");
            this.addQuestion(q33);
            Question q34=new Question("Samurajski kodeks zove se...","Harakiri","Bushido","Kendo","Aikido","Bushido");
            this.addQuestion(q34);
            Question q35=new Question("Površina Azije zauzima 1/3 kopnene površine Zemlje bez Antarktike, a to je:","3,9 milijuna km2","11 milijuna km2","44,4 milijuna km2","105,5 milijuna km2","44,4 milijuna km2") ;
            this.addQuestion(q35);
            Question q36=new Question("Tko se izvrgava opasnosti za drugoga, taj vadi kestene iz...","Vatre","Šume","Vode","Rijeke","Vatre");
            this.addQuestion(q36);
            Question q37=new Question("Nakon odsviranog koncerta gotovo uvijek slijedi...","Cis","Dis","Fis","Bis","Bis");
            this.addQuestion(q37);
            Question q38=new Question("Drugi dio kog filmskog serijala je poznat pod nazivom \"Drumski ratnik\"?","Pobješnjeli Max","Smrtonosno oružje","Umri muški","Terminator","Pobješnjeli Max");
            this.addQuestion(q38);
            Question q39=new Question("Koje je kazalište najstarije u hrvatskoj?","Riječko","Splitsko","Hvarsko","Dubrovačko","Hvarsko");
            this.addQuestion(q39);
            Question q40=new Question("Kako se zove album Dina Dvornika iz 1993. godine?","Matematika","Zemljopis","Priroda i društvo","Tjelesni odgoj","Priroda i društvo");
            this.addQuestion(q40);



        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

            db.execSQL("DROP TABLE IF EXISTS " + Contract.ColumnNames.TABLE_QUEST);
            db.execSQL("DROP TABLE IF EXISTS " + Contract.Highscores.TABLE_HIGHSCORES);
            onCreate(db);
        }

        public void addQuestion(Question quest) {


            ContentValues values = new ContentValues();
            values.put(Contract.ColumnNames.KEY_QUES, quest.getQUESTION());
            values.put(Contract.ColumnNames.KEY_ANSWER, quest.getANSWER());
            values.put(Contract.ColumnNames.KEY_OPTA, quest.getOPTA());
            values.put(Contract.ColumnNames.KEY_OPTB, quest.getOPTB());
            values.put(Contract.ColumnNames.KEY_OPTC, quest.getOPTC());
            values.put(Contract.ColumnNames.KEY_OPTD, quest.getOPTD());

            dbase.insert(Contract.ColumnNames.TABLE_QUEST, null, values);

        }
        public ArrayList<Question> getRandomQuestions() {
            ArrayList<Question> quesList = new ArrayList<Question>();

            String selectQuery = "SELECT  * FROM " + Contract.ColumnNames.TABLE_QUEST + " ORDER BY RANDOM() LIMIT "+String.valueOf(Question.numOfQuestions);
            dbase=this.getReadableDatabase();
            Cursor cursor = dbase.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setID(cursor.getInt(0));
                    quest.setQUESTION(cursor.getString(1));
                    quest.setANSWER(cursor.getString(2));
                    quest.setOPTA(cursor.getString(3));
                    quest.setOPTB(cursor.getString(4));
                    quest.setOPTC(cursor.getString(5));
                    quest.setOPTD(cursor.getString(6));
                    quest.setCorrect(cursor.getInt(8));
                    quest.setTotal(cursor.getInt(7));
                    quesList.add(quest);
                } while (cursor.moveToNext());
            }
            cursor.close();
            return quesList;
        }

    public void addQuestionToDb(Question quest,SQLiteDatabase dbase) {


        ContentValues values = new ContentValues();
        values.put(Contract.ColumnNames.KEY_QUES, quest.getQUESTION());
        values.put(Contract.ColumnNames.KEY_ANSWER, quest.getANSWER());
        values.put(Contract.ColumnNames.KEY_OPTA, quest.getOPTA());
        values.put(Contract.ColumnNames.KEY_OPTB, quest.getOPTB());
        values.put(Contract.ColumnNames.KEY_OPTC, quest.getOPTC());
        values.put(Contract.ColumnNames.KEY_OPTD, quest.getOPTD());

        dbase.insert(Contract.ColumnNames.TABLE_QUEST, null, values);

    }



        public void addPlayer(String username,int score){

            dbase=this.getWritableDatabase();

            ContentValues values=new ContentValues();
            values.put(Contract.Highscores.KEY_USERNAME,username);
            values.put(Contract.Highscores.KEY_SCORE,score);
            dbase.insert(Contract.Highscores.TABLE_HIGHSCORES,null,values);

        }

    public ArrayList<Highscore> getAllUsers()	{
        ArrayList<Highscore> lista = new	ArrayList<Highscore>();
        dbase=getReadableDatabase();
        Cursor cursor =	dbase.rawQuery("SELECT *	FROM " +Contract.Highscores.TABLE_HIGHSCORES+" ORDER BY "+Contract.Highscores.KEY_SCORE+" DESC",null);
        cursor.moveToFirst();

        while(!	cursor.isAfterLast()) {
            Highscore user =new Highscore();
            user.setScore(cursor.getInt(2));
            user.setUsername(cursor.getString(1));

            lista.add(user);
            cursor.moveToNext();
        }

        cursor.close();

        return	lista;
    }


    public void updatePercentage(Question question){

            dbase=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Contract.ColumnNames.KEY_TOTAL,question.getTotal());
            values.put(Contract.ColumnNames.KEY_CORRECT,question.getCorrect());
            dbase.update(Contract.ColumnNames.TABLE_QUEST, values, Contract.ColumnNames.KEY_ID + " = ?",new String[]{ String.valueOf(question.getID())});


    }
}


