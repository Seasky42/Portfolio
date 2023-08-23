package com.example.firm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ComTestDb extends SQLiteOpenHelper{
    public static final String comTest_db = "create table comTest_db(" +
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
    public ComTestDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(comTest_db);

        ContentValues values = new ContentValues();

        values.put("flag","1");
        values.put("word", "over");
        values.put("property", " adv. 结束，越过prep. 在……之上，越过 adj. 上面的");
        values.put("example", "例句：Let us read over this article.");
        values.put("testc","adv. 结束，越过prep. 在……之上，越过 ");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "overhear");
        values.put("property", " vt. 无意中听到，偷听");
        values.put("example", "例句：I overheard them saying they were unhappy with me.");
        values.put("testc","null");
        values.put("teste1","无意中听到，偷听");
        values.put("teste2","在上面");
        values.put("teste3","漏听");
        values.put("teste4","绘画");
        values.put("ans","1");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "oven");
        values.put("property", " n. 烤箱，烤炉，灶");
        values.put("example", "例句：The cook went to see after the cake left in the oven.");
        values.put("testc","null");
        values.put("teste1","烤箱，烤炉，灶");
        values.put("teste2","热水器");
        values.put("teste3","壁炉");
        values.put("teste4","水龙头");
        values.put("ans","1");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "overtake");
        values.put("property", " vt. 赶上，追上，(暴风雨、麻烦等)突然来袭，压倒");
        values.put("example", "例句：Carina put on an impressive tum of speed to overtake the others.");
        values.put("testc","vt. 赶上，追上，(暴风雨、麻烦等)突然来袭，压倒");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "overt");
        values.put("property", " adj. 明显的，公然的，公开的");
        values.put("example", "例句：I know only Simon's overt reasons for refusing; he may have others.");
        values.put("testc","null");
        values.put("teste1","隐蔽的");
        values.put("teste2","明显的，公然的，公开的");
        values.put("teste3","昏暗的");
        values.put("teste4","有希望的");
        values.put("ans","2");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","1");
        values.put("word", "overcome");
        values.put("property", " vt. 战胜，克服，胜过，征服 vi. 得胜");
        values.put("example", "例句：There will be no difficulty in the world that I cannot overcome.");
        values.put("testc","null");
        values.put("teste1","失败");
        values.put("teste2","攀爬");
        values.put("teste3","战胜，克服，胜过，征服");
        values.put("teste4","驯服");
        values.put("ans","3");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "overflow");
        values.put("property", " n. 溢出，超值，泛滥，充满v. (使)泛滥，(使)充溢");
        values.put("example", "例句：Patients overflowed the hospital and they lay on the floors and inthe corridors.");
        values.put("testc","null");
        values.put("teste1","贬值");
        values.put("teste2","破坏");
        values.put("teste3","下降");
        values.put("teste4","溢出，超值，泛滥，充满");
        values.put("ans","4");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "overthrow");
        values.put("property", " n. 推翻，打倒vt.打倒，推翻，颠覆");
        values.put("example", "例句：Their attempt to overthrow the government ended in nothing.");
        values.put("testc","n. 推翻，打倒vt.打倒，推翻，颠覆");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "overwhelm");
        values.put("property", " vt. 淹没，覆没，受打击，制服，压倒");
        values.put("example", "例句：The village was overwhelmed when the floods came.");
        values.put("testc","vt. 淹没，覆没，受打击，制服，压倒");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("comTest_db", null, values);
        values.clear();

        values.put("flag","0");
        values.put("word", "legal");
        values.put("property", " adj. 法律的，法定的，合法");
        values.put("example", "例句：Warren is the only legal heir of the rich man.");
        values.put("testc","adj. 法律的，法定的，合法");
        values.put("teste1","null");
        values.put("teste2","null");
        values.put("teste3","null");
        values.put("teste4","null");
        values.put("ans","0");
        db.insert("comTest_db", null, values);
        values.clear();


        Toast.makeText(mContext, "Create succeeded: comTest_db", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
