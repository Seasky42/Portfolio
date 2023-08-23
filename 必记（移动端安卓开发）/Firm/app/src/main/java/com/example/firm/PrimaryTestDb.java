package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class PrimaryTestDb extends SQLiteOpenHelper{
    public static final String PrimaryTest_db = "create table PrimaryTest_db(" +
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
    public PrimaryTestDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(PrimaryTest_db);

        ContentValues values = new ContentValues();

        values.put("flag","1");
        values.put("word", "compliment");
        values.put("property", "n. 恭维;称赞;问候;致意;道贺");
        values.put("example", "Compliment her often.");
        values.put("testc","n. 恭维;称赞;问候");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "dedicate");
        values.put("property", "vt. 致力;献身;题献");
        values.put("example", "To her I dedicate this book.");
        values.put("testc","null");
        values.put("teste1","努力");
        values.put("teste2","创造");
        values.put("teste3","探索");
        values.put("teste4","致力;献身;题献");
        values.put("ans","4");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "compile");
        values.put("property", "vt. 编译;编制;编辑;[图情] 汇编");
        values.put("example", "Compile and run this job in the designer.");
        values.put("testc","vt. 编译;编制;编辑");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "concert");
        values.put("property", "vt. 使协调;协同安排");
        values.put("example", "We are queuing up to buy tickets for the concert.");
        values.put("testc","vt. 使协调;协同安排");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "cynical");
        values.put("property", "adj. 愤世嫉俗的;冷嘲的");
        values.put("example", "He was so cynical that he sneered at everything that made life worth living.");
        values.put("testc","null");
        values.put("teste1","发光的");
        values.put("teste2","燃烧的");
        values.put("teste3","愤世嫉俗的;冷嘲的");
        values.put("teste4","不高兴的");
        values.put("ans","3");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "compensate");
        values.put("property", "vt. 补偿，赔偿;付报酬");
        values.put("example", "So how will they compensate me?");
        values.put("testc","vt. 补偿，赔偿;付报酬");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "complication");
        values.put("property", "n. 并发症;复杂;复杂化;混乱");
        values.put("example", "So this is a complication in any stage theory.");
        values.put("testc","n. 并发症;复杂;复杂化");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "departure");
        values.put("property", "n. 离开;出发;违背");
        values.put("example", "The secretary's sudden departure disorganized the whole company.");
        values.put("testc","null");
        values.put("teste1","分别");
        values.put("teste2","离开;出发;违背");
        values.put("teste3","感到压力");
        values.put("teste4","有温度");
        values.put("ans","2");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "deficit");
        values.put("property", "n. 赤字;不足额");
        values.put("example", "And so -- but we do have to deal with the deficit.");
        values.put("testc","null");
        values.put("teste1","赤字;不足额");
        values.put("teste2","困难");
        values.put("teste3","分割");
        values.put("teste4","不同之处");
        values.put("ans","1");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "damp");
        values.put("property", "vt. 使潮湿;使阻尼;使沮丧，抑制");
        values.put("example", "Damp gunpowder will not fire.");
        values.put("testc","null");
        values.put("teste1","使沮丧，抑制");
        values.put("teste2","饺子");
        values.put("teste3","下坠");
        values.put("teste4","悬崖");
        values.put("ans","1");
        db.insert("PrimaryTest_db", null, values);
        values.clear();

        Toast.makeText(mContext, "Create succeeded: PrimaryTest_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
