package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 建立六级词库的类
 */
public class CET6db extends SQLiteOpenHelper {
    public static final String CET6_db = "create table CET6_db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public CET6db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CET6_db);

        ContentValues values = new ContentValues();

        values.put("word", "amplify");
        values.put("property", "vt. 放大，扩大;增强;详述");
        values.put("example", "This landscape seemed to trap and amplify sounds.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "adjacent");
        values.put("property", "adj. 邻近的，毗连的");
        values.put("example", "He sat in an adjacent room and waited.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "adjust");
        values.put("property", "vt. 调整，使…适合;校准");
        values.put("example", "We have been preparing our fighters to adjust themselves to civil society.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "adolescent");
        values.put("property", "adj. 青春期的;未成熟的; n. 青少年");
        values.put("example", "He led the adolescent side of the study.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "abolish");
        values.put("property", "vt. 废除，废止;取消，革除");
        values.put("example", "I asked them not to abolish AmeriCorps, as they had threatened to do.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "ambitious");
        values.put("property", "adj. 野心勃勃的;有雄心的;热望的;炫耀的");
        values.put("example", "Chris is so ambitious, so determined to do it all.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "accessory");
        values.put("property", "n. 配件;附件;[法] 从犯");
        values.put("example", "It also has a good range of accessories, including sunglasses, handbags and belts.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "accent");
        values.put("property", "n. 口音;重音;强调;特点;重音符号;vt. 强调;重读;带…口音讲话");
        values.put("example", "He has a strong American accent.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "physical");
        values.put("property", "adj. 身体的；物理的    n. 体格检查");
        values.put("example", "Physical exercise is good for your body and mind.");
        db.insert("CET6_db", null, values);
        values.clear();

        values.put("word", "advent");
        values.put("property", "n. 到来;出现;基督降临;基督降临节");
        values.put("example", "The advent of the computer has brought this sort of task within the bounds of possibility.");
        db.insert("CET6_db", null, values);
        values.clear();

        Toast.makeText(mContext, "Create succeeded: CET6_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
