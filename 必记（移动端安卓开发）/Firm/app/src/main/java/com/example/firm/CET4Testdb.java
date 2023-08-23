package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CET4Testdb extends SQLiteOpenHelper{
    public static final String CET4Test_db = "create table CET4Test_db(" +
            "id integer primary key autoincrement," +
            "flag text," +
            "word text," +
            "property text," +
            "example text," +
            "testc text," +
            "teste1 text," +
            "teste2 text," +
            "teste3 text," +
            "teste4 text," +
            "ans text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public CET4Testdb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CET4Test_db);

        ContentValues values = new ContentValues();

        values.put("flag","1");
        values.put("word", "derive");
        values.put("property", "v. 得自，起源");
        values.put("example", "All unconsciously the ideas they derive from the printed page arestored up.");
        values.put("testc","v. 得自，起源");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "deprive");
        values.put("property", " vt. 剥夺，使丧失");
        values.put("example", "The big trees outside the windows deprive the house of light.");
        values.put("testc","null");
        values.put("teste1","切割");
        values.put("teste2","剥夺，使丧失");
        values.put("teste3","下降");
        values.put("teste4","潜入");
        values.put("ans","2");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "strive");
        values.put("property", " v. 努力，奋斗，力争，斗争");
        values.put("example", "The scientists strive for a breakthrough in heart diseases research.");
        values.put("testc","null");
        values.put("teste1","恐惧");
        values.put("teste2","饥饿");
        values.put("teste3","努力，奋斗，力争，斗争");
        values.put("teste4","咀嚼");
        values.put("ans","3");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "thrive");
        values.put("property", " v. 兴旺，繁荣，茁壮成长，旺盛");
        values.put("example", "It is said that a business cannot thrive without good management.");
        values.put("testc","v. 兴旺，繁荣，茁壮成长，旺盛");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "contrive");
        values.put("property", " v. 发明，设计，图谋，设法做到");
        values.put("example", "The couple contrived to bring up their daughter on a small income.");
        values.put("testc","v. 发明，设计，图谋，设法做到");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", " horror");
        values.put("property", " n.惊骇.恐怖，惨事，极端厌恶");
        values.put("example", " This horror film freaked Alice out.");
        values.put("testc","null");
        values.put("teste1","惊骇.恐怖，惨事");
        values.put("teste2","尊重");
        values.put("teste3","有力量");
        values.put("teste4","射箭");
        values.put("ans","1");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "horrible");
        values.put("property", " adj. 可怕的，恐怖的，讨厌的");
        values.put("example", "Betty's first attempt at a chocolate cake tasted horrible.");
        values.put("testc","adj. 可怕的，恐怖的，讨厌的");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "nightmare");
        values.put("property", " n.梦魇，噩梦，可怕的事物");
        values.put("example", "I have a nightmare about falling off a cliff and it waked me up.");
        values.put("testc","n.梦魇，噩梦，可怕的事物");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "dismay");
        values.put("property", " n. 沮丧，惊慌 v.使沮丧，使惊慌");
        values.put("example", "It dismayed Daisy that the project had been canceled.");
        values.put("testc","null");
        values.put("teste1","沉迷");
        values.put("teste2","破坏");
        values.put("teste3","使沮丧，使惊慌");
        values.put("teste4","思考");
        values.put("ans","3");
        db.insert("CET4Test_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "awful");
        values.put("property", " adj. 可怕的，威严的");
        values.put("example", " It would be awful if Bill found out the truth that we cheated onhim.");
        values.put("testc","null");
        values.put("teste1","豪放的");
        values.put("teste2","可怕的，威严的");
        values.put("teste3","糟糕的");
        values.put("teste4","绝望的");
        values.put("ans","3");
        db.insert("CET4Test_db", null, values);
        values.clear();


        Toast.makeText(mContext, "Create succeeded: CET4Test_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
