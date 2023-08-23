package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class HighTestDb extends SQLiteOpenHelper{
    public static final String HighTest_db = "create table HighTest_db(" +
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
    public HighTestDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(HighTest_db);

        ContentValues values = new ContentValues();

        values.put("flag","1");
        values.put("word", "differentiate");
        values.put("property", "vt. 区分，区别");
        values.put("example", "A botanist can differentiate varieties of plants.");
        values.put("testc","vt. 区分，区别");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "dispatch");
        values.put("property", "vt. 派遣;分派");
        values.put("example", "These handlers should always be deployed after the dispatch phase.");
        values.put("testc","null");
        values.put("teste1","目的");
        values.put("teste2","在路上");
        values.put("teste3","派遣;分派");
        values.put("teste4","抓住...");
        values.put("ans","3");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "descent");
        values.put("property", "n. 下降;血统;袭击;vt. 除去…的气味;使…失去香味");
        values.put("example", "The authors show how this was triggered by his belief in the common descent of all humans.");
        values.put("testc","null");
        values.put("teste1","距离");
        values.put("teste2","芳香的");
        values.put("teste3","有异味");
        values.put("teste4","除去…的气味;使…失去香味");
        values.put("ans","4");
        db.insert("HighTest_db", null, values);
        values.clear();


        values.put("flag","0");
        values.put("word", "despise");
        values.put("property", "vt. 轻视，鄙视");
        values.put("example", "As to you, I despise you.");
        values.put("testc","vt. 轻视，鄙视");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "disable");
        values.put("property", "vt. 使失去能力;使残废;使无资格");
        values.put("example", "I will disable it again after the migration.");
        values.put("testc","vt. 使失去能力;使残废;使无资格");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "dilemma");
        values.put("property", "n. 困境;进退两难;两刀论法");
        values.put("example", "This creates yet another dilemma.");
        values.put("testc","n. 困境;进退两难");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "dirt");
        values.put("property", "n. 污垢，泥土;灰尘，尘土;下流话");
        values.put("example", "The windows were encrusted with dirt.");
        values.put("testc","null");
        values.put("teste1","污垢，泥土");
        values.put("teste2","干净的");
        values.put("teste3","干燥");
        values.put("teste4","午餐");
        values.put("ans","1");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "discourage");
        values.put("property", "vt. 阻止;使气馁");
        values.put("example", "Low prices discourage industry.");
        values.put("testc","vt. 阻止;使气馁");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","null");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "disperse");
        values.put("property", "vt. 分散;使散开;传播");
        values.put("example", "The police fired into the air in an attempt to disperse the crowd.");
        values.put("testc","null");
        values.put("teste1","分散;传播");
        values.put("teste2","散发传单");
        values.put("teste3","分布");
        values.put("teste4","传送");
        values.put("ans","1");
        db.insert("HighTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "disaster");
        values.put("property", "n. 灾难，灾祸;不幸");
        values.put("example", "We must act now to forestall disaster.");
        values.put("testc","null");
        values.put("teste1","幸运");
        values.put("teste2","灾难，灾祸");
        values.put("teste3","沙漠");
        values.put("teste4","甜点");
        values.put("ans","2");
        db.insert("HighTest_db", null, values);
        values.clear();

        Toast.makeText(mContext, "Create succeeded: HighTest_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}