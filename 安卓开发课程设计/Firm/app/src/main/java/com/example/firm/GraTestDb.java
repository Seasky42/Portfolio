package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class GraTestDb extends SQLiteOpenHelper{
    public static final String graTest_db = "create table graTest_db(" +
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
    public GraTestDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(graTest_db);

        ContentValues values = new ContentValues();

        values.put("flag","0");
        values.put("word", "cautious");
        values.put("property", "adj. 谨慎的，小心的");
        values.put("example", "Experience of once pain is worth hundreds of thousands of cautions,");
        values.put("testc","adj. 谨慎的，小心的");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "reckless");
        values.put("property", "adj. 不计后果的");
        values.put("example", "Anthony is quite reckless of his own safety.");
        values.put("testc","adj. 不计后果的");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "caution");
        values.put("property", "n.小心，.谨慎，警告vt.警告");
        values.put("example", "Alan told us to proceed with caution in every step.");
        values.put("testc","null");
        values.put("teste1","道别");
        values.put("teste2","劝诫");
        values.put("teste3","失望");
        values.put("teste4","小心，.谨慎，警告");
        values.put("ans","4");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "precaution");
        values.put("property", "n.预防，警幅，防范");
        values.put("example", "The report is focusing on the lack of safety precaution.");
        values.put("testc","n.预防，警幅，防范");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "fake");
        values.put("property", "n.假货，欺骗 adj. 假的 v.伪造，厦造，捏造，假造，仿造");
        values.put("example", "n closer examination the antique was proved to be a fake.");
        values.put("testc","null");
        values.put("teste1","说谎");
        values.put("teste2","伪造，厦造，捏造");
        values.put("teste3","创造");
        values.put("teste4","打架");
        values.put("ans","2");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "disguise");
        values.put("property", " v.假装，伪装，掩饰 n.伪装");
        values.put("example", "Karen disguised herself as a man, but she couldn't disguise hervoice.");
        values.put("testc","null");
        values.put("teste1","假装，伪装，掩饰");
        values.put("teste2","借口");
        values.put("teste3","隐瞒");
        values.put("teste4","挖掘");
        values.put("ans","1");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "fabricate");
        values.put("property", "vt.制作，构成，捏造，伪造，虚构");
        values.put("example", "The gang fabricated evidence and threatened witnesses.");
        values.put("testc","vt.制作，构成，捏造，伪造，虚构");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "fabric");
        values.put("property", "n.织品，织物，布，结构，建筑物，构造");
        values.put("example", "The whole social fabric was threatened with disintegration.");
        values.put("testc","n.织品，织物，布，结构");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "forge");
        values.put("property", "v.稳步前进，铸造，伪造");
        values.put("example", "Jenny forged their manager’s signature on the cheque.");
        values.put("testc","null");
        values.put("teste1","看不见");
        values.put("teste2","建起...");
        values.put("teste3","稳步前进，铸造，伪造");
        values.put("teste4","冲刺");
        values.put("ans","3");
        db.insert("graTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "mask");
        values.put("property", "n.面具，口罩，伪装 此用面具遮住，掩饰");
        values.put("example", "Josephine's sociable manner is really a mask for a very shy nature.");
        values.put("testc","null");
        values.put("teste1","尖叫");
        values.put("teste2","烟花");
        values.put("teste3","面具，口罩");
        values.put("teste4","创造物");
        values.put("ans","3");
        db.insert("graTest_db", null, values);
        values.clear();


        Toast.makeText(mContext, "Create succeeded: graTest_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
