package com.example.stipe.kviz;


import android.provider.BaseColumns;

public class Contract {

    public static class ColumnNames implements BaseColumns {
        public static final String TABLE_QUEST = "quest";

        public static final String KEY_ID = "id";
        public static final String KEY_QUES = "question";
        public static final String KEY_ANSWER = "answer";
        public static final String KEY_OPTA= "opta";
        public static final String KEY_OPTB= "optb";
        public static final String KEY_OPTC= "optc";
        public static final String KEY_OPTD= "optd";
        public static final String KEY_TOTAL="total";
        public static final String KEY_CORRECT="correct";
    }

    public static class Highscores implements BaseColumns {

        public static final String TABLE_HIGHSCORES = "highscores";
        public static final String KEY_ID = "id";
        public static final String KEY_USERNAME = "username";
        public static final String KEY_SCORE = "score";

    }


}
