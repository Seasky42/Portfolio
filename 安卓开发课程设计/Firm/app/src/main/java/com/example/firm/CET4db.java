package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CET4db extends SQLiteOpenHelper {
    public static final String CET4_db = "create table CET4_db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public CET4db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CET4_db);

        ContentValues values = new ContentValues();

        values.put("word", "derive");
        values.put("property", "v. 得自，起源");
        values.put("example", "All unconsciously the ideas they derive from the printed page arestored up.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "deprive");
        values.put("property", " vt. 剥夺，使丧失");
        values.put("example", "The big trees outside the windows deprive the house of light.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "strive");
        values.put("property", " v. 努力，奋斗，力争，斗争");
        values.put("example", "The scientists strive for a breakthrough in heart diseases research.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "thrive");
        values.put("property", " v. 兴旺，繁荣，茁壮成长，旺盛");
        values.put("example", "It is said that a business cannot thrive without good management.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "contrive");
        values.put("property", " v. 发明，设计，图谋，设法做到");
        values.put("example", "The couple contrived to bring up their daughter on a small income.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", " horror");
        values.put("property", " n.惊骇.恐怖，惨事，极端厌恶");
        values.put("example", " This horror film freaked Alice out.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "horrible");
        values.put("property", " adj. 可怕的，恐怖的，讨厌的");
        values.put("example", "Betty's first attempt at a chocolate cake tasted horrible.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "nightmare");
        values.put("property", " n.梦魇，噩梦，可怕的事物");
        values.put("example", "I have a nightmare about falling off a cliff and it waked me up.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "dismay");
        values.put("property", " n. 沮丧，惊慌 v.使沮丧，使惊慌");
        values.put("example", "It dismayed Daisy that the project had been canceled.");
        db.insert("CET4_db", null, values);
        values.clear();

        values.put("word", "awful");
        values.put("property", " adj. 可怕的，威严的");
        values.put("example", " It would be awful if Bill found out the truth that we cheated onhim.");
        db.insert("CET4_db", null, values);
        values.clear();

        Toast.makeText(mContext, "Create succeeded: CET4_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
