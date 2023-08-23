package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class GraDb extends SQLiteOpenHelper {
    public static final String gra_db = "create table gra_db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public GraDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(gra_db);

        ContentValues values = new ContentValues();

        values.put("word", "cautious");
        values.put("property", "adj. 谨慎的，小心的");
        values.put("example", "Experience of once pain is worth hundreds of thousands of cautions,");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "reckless");
        values.put("property", "adj. 不计后果的");
        values.put("example", "Anthony is quite reckless of his own safety.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "caution");
        values.put("property", "n.小心，.谨慎，警告vt.警告");
        values.put("example", "Alan told us to proceed with caution in every step.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "precaution");
        values.put("property", "n.预防，警幅，防范");
        values.put("example", "The report is focusing on the lack of safety precaution.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "fake");
        values.put("property", "n.假货，欺骗 adj. 假的 v.伪造，厦造，捏造，假造，仿造");
        values.put("example", "n closer examination the antique was proved to be a fake.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "disguise");
        values.put("property", " v.假装，伪装，掩饰 n.伪装");
        values.put("example", "Karen disguised herself as a man, but she couldn't disguise hervoice.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "fabricate");
        values.put("property", "vt.制作，构成，捏造，伪造，虚构");
        values.put("example", "The gang fabricated evidence and threatened witnesses.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "fabric");
        values.put("property", "n.织品，织物，布，结构，建筑物，构造");
        values.put("example", "The whole social fabric was threatened with disintegration.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "forge");
        values.put("property", "v.稳步前进，铸造，伪造");
        values.put("example", "Jenny forged their manager’s signature on the cheque.");
        db.insert("gra_db", null, values);
        values.clear();

        values.put("word", "mask");
        values.put("property", "n.面具，口罩，伪装 此用面具遮住，掩饰");
        values.put("example", "Josephine's sociable manner is really a mask for a very shy nature.");
        db.insert("gra_db", null, values);
        values.clear();


        Toast.makeText(mContext, "Create succeeded: gra_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
