package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 建立六级词库的类
 */
public class WrongSetDb extends SQLiteOpenHelper {
    public static final String wSet_Db = "create table wSet_Db(" +
            "id integer primary key autoincrement," +
            "word text," +
            "property text," +
            "example text)";

    private Context mContext;

    //构造方法：第一个参数Context，第二个参数数据库名，第三个参数cursor允许我们在查询数据的时候返回一个自定义的光标位置，一般传入的都是null，第四个参数表示目前库的版本号（用于对库进行升级）
    public WrongSetDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(wSet_Db);

        Toast.makeText(mContext, "Create succeeded: wSet_Db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
