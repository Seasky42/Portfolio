package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 建立高考词库的类
 */
public class HighDb extends SQLiteOpenHelper {
    public static final String gaokao_db = "create table gaokao_db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public HighDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(gaokao_db);

        ContentValues values = new ContentValues();

        values.put("word", "differentiate");
        values.put("property", "vt. 区分，区别");
        values.put("example", "A botanist can differentiate varieties of plants.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "dispatch");
        values.put("property", "vt. 派遣;分派");
        values.put("example", "These handlers should always be deployed after the dispatch phase.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "descent");
        values.put("property", "n. 下降;血统;袭击;vt. 除去…的气味;使…失去香味");
        values.put("example", "The authors show how this was triggered by his belief in the common descent of all humans.");
        db.insert("gaokao_db", null, values);
        values.clear();


        values.put("word", "despise");
        values.put("property", "vt. 轻视，鄙视");
        values.put("example", "As to you, I despise you.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "disable");
        values.put("property", "vt. 使失去能力;使残废;使无资格");
        values.put("example", "I will disable it again after the migration.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "dilemma");
        values.put("property", "n. 困境;进退两难;两刀论法");
        values.put("example", "This creates yet another dilemma.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "dirt");
        values.put("property", "n. 污垢，泥土;灰尘，尘土;下流话");
        values.put("example", "The windows were encrusted with dirt.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "discourage");
        values.put("property", "vt. 阻止;使气馁");
        values.put("example", "Low prices discourage industry.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "disperse");
        values.put("property", "vt. 分散;使散开;传播");
        values.put("example", "The police fired into the air in an attempt to disperse the crowd.");
        db.insert("gaokao_db", null, values);
        values.clear();

        values.put("word", "disaster");
        values.put("property", "n. 灾难，灾祸;不幸");
        values.put("example", "We must act now to forestall disaster.");
        db.insert("gaokao_db", null, values);
        values.clear();

        Toast.makeText(mContext, "Create succeeded: gaokao_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
