package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 建立中考词库类
 */
public class PrimaryDb extends SQLiteOpenHelper {
    public static final String zhongkao_db = "create table zhongkao_db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public PrimaryDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(zhongkao_db);

        ContentValues values = new ContentValues();

        values.put("word", "compliment");
        values.put("property", "n. 恭维;称赞;问候;致意;道贺");
        values.put("example", "Compliment her often.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "dedicate");
        values.put("property", "vt. 致力;献身;题献");
        values.put("example", "To her I dedicate this book.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "compile");
        values.put("property", "vt. 编译;编制;编辑;[图情] 汇编");
        values.put("example", "Compile and run this job in the designer.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "concert");
        values.put("property", "vt. 使协调;协同安排");
        values.put("example", "We are queuing up to buy tickets for the concert.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "cynical");
        values.put("property", "adj. 愤世嫉俗的;冷嘲的");
        values.put("example", "He was so cynical that he sneered at everything that made life worth living.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "compensate");
        values.put("property", "vt. 补偿，赔偿;付报酬");
        values.put("example", "So how will they compensate me?");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "complication");
        values.put("property", "n. 并发症;复杂;复杂化;混乱");
        values.put("example", "So this is a complication in any stage theory.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "departure");
        values.put("property", "n. 离开;出发;违背");
        values.put("example", "The secretary's sudden departure disorganized the whole company.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "deficit");
        values.put("property", "n. 赤字;不足额");
        values.put("example", "And so -- but we do have to deal with the deficit.");
        db.insert("zhongkao_db", null, values);
        values.clear();

        values.put("word", "damp");
        values.put("property", "vt. 使潮湿;使阻尼;使沮丧，抑制");
        values.put("example", "Damp gunpowder will not fire.");
        db.insert("zhongkao_db", null, values);
        values.clear();


        Toast.makeText(mContext, "Create succeeded: zhongkao_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}