package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ComDb extends SQLiteOpenHelper {
    public static final String com_db = "create table com_db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public ComDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(com_db);

        ContentValues values = new ContentValues();

        values.put("word", "over");
        values.put("property", " adv. 结束，越过prep. 在……之上，越过 adj. 上面的");
        values.put("example", "例句：Let us read over this article.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overhear");
        values.put("property", " vt. 无意中听到，偷听");
        values.put("example", "例句：I overheard them saying they were unhappy with me.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "oven");
        values.put("property", " n. 烤箱，烤炉，灶");
        values.put("example", "例句：The cook went to see after the cake left in the oven.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overtake");
        values.put("property", " vt. 赶上，追上，(暴风雨、麻烦等)突然来袭，压倒");
        values.put("example", "例句：Carina put on an impressive tum of speed to overtake the others.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overt");
        values.put("property", " adj. 明显的，公然的，公开的");
        values.put("example", "例句：I know only Simon's overt reasons for refusing; he may have others.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overcome");
        values.put("property", " vt. 战胜，克服，胜过，征服 vi. 得胜");
        values.put("example", "例句：There will be no difficulty in the world that I cannot overcome.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overflow");
        values.put("property", " n. 溢出，超值，泛滥，充满v. (使)泛滥，(使)充溢");
        values.put("example", "例句：Patients overflowed the hospital and they lay on the floors and in the corridors.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overthrow");
        values.put("property", " n. 推翻，打倒vt.打倒，推翻，颠覆");
        values.put("example", "例句：Their attempt to overthrow the government ended in nothing.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "overwhelm");
        values.put("property", " vt. 淹没，覆没，受打击，制服，压倒");
        values.put("example", "例句：The village was overwhelmed when the floods came.");
        db.insert("com_db", null, values);
        values.clear();

        values.put("word", "legal");
        values.put("property", " adj. 法律的，法定的，合法");
        values.put("example", "例句：Warren is the only legal heir of the rich man.");
        db.insert("com_db", null, values);
        values.clear();

        Toast.makeText(mContext, "Create succeeded: com_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}