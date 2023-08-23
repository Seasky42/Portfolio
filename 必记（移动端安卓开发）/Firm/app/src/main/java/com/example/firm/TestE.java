package com.example.firm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 初始界面
 */
public class TestE extends AppCompatActivity {
    //是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    protected boolean useStatusBarColor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView之前添加,未添加的话home键监听无效，设置窗体属性
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_teste);
        //调用实现沉浸式状态栏函数
        setStatusBar();

        /*从对应的数据库中获取数据*/
        if(GlobalVar.dbnum == 1 && GlobalVar.opT1 == 0){
            PrimaryTestDb pTestDb = new PrimaryTestDb(this, "PrimaryTest_db", null, 1);
            pTestDb.getWritableDatabase();
            GlobalVar.j = 0;
            GlobalVar.cursorT = pTestDb.getReadableDatabase().query("PrimaryTest_db",null,null,null,null,null,null);
            GlobalVar.opT1 = 1;
        }
        else if(GlobalVar.dbnum == 2 && GlobalVar.opT2 == 0){
            HighTestDb hTestDb = new HighTestDb(this, "HighTest_db", null, 1);
            hTestDb.getWritableDatabase();
            GlobalVar.j = 0;
            GlobalVar.cursorT = hTestDb.getReadableDatabase().query("HighTest_db",null,null,null,null,null,null);
            GlobalVar.opT2 = 1;
        }
        else if(GlobalVar.dbnum == 3 && GlobalVar.opT3 == 0){
            CET4Testdb cTestDb = new CET4Testdb(this, "CET4Test_db", null,1);
            cTestDb.getWritableDatabase();
            GlobalVar.j = 0;
            GlobalVar.cursorT = cTestDb.getWritableDatabase().query("CET4Test_db", null, null, null, null, null, null);
            GlobalVar.opT3 = 1;
        }
        else if(GlobalVar.dbnum == 4 && GlobalVar.opT4 == 0){
            CET6Testdb cTestDb = new CET6Testdb(this, "CET6Test_db", null, 1);
            cTestDb.getWritableDatabase();
            GlobalVar.j = 0;
            GlobalVar.cursorT = cTestDb.getReadableDatabase().query("CET6Test_db",null,null,null,null,null,null);
            GlobalVar.opT4 = 1;
        }
        else if(GlobalVar.dbnum == 5 && GlobalVar.opT5 == 0){
            GraTestDb gTestDb = new GraTestDb(this, "graTest_db", null, 1);
            gTestDb.getWritableDatabase();
            GlobalVar.j = 0;
            GlobalVar.cursorT = gTestDb.getWritableDatabase().query("graTest_db", null, null, null, null, null, null);
            GlobalVar.opT5 = 1;
        }
        else if(GlobalVar.dbnum == 6 && GlobalVar.opT6 == 0){
            ComTestDb cTestDb = new ComTestDb(this, "comTest_db", null, 1);
            cTestDb.getWritableDatabase();
            GlobalVar.j = 0;
            GlobalVar.cursorT = cTestDb.getWritableDatabase().query("comTest_db", null, null, null, null, null, null);
            GlobalVar.opT6 = 1;
        }

        next();

        //获取正确答案并对"确定"按钮进行监听
        @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
        Button btnOk = (Button) this.findViewById(R.id.ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cin = (EditText) findViewById(R.id.input);
                if(cin.getText().toString().equals(sword)){
                    if(GlobalVar.j < 5){
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(TestE.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(TestE.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                    else{
                        if(GlobalVar.dbnum == 1){
                            GlobalVar.i1 = 0;
                        }
                        else if(GlobalVar.dbnum == 2){
                            GlobalVar.i2 = 0;
                        }
                        else if(GlobalVar.dbnum == 3){
                            GlobalVar.i3 = 0;
                        }
                        else if(GlobalVar.dbnum == 4){
                            GlobalVar.i4 = 0;
                        }
                        else if(GlobalVar.dbnum == 5){
                            GlobalVar.i5 = 0;
                        }
                        else{
                            GlobalVar.i6 = 0;
                        }
                        Intent intentM = new Intent(TestE.this, Memory.class);
                        startActivity(intentM);
                    }
                }
                else {
                    @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
                    @SuppressLint("Range") String sproperty = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("property"));
                    @SuppressLint("Range") String sexample = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("example"));
                    WrongSetDb wrongSetDb = new WrongSetDb(TestE.this, "wSet_Db", null, 1);
                    SQLiteDatabase db = wrongSetDb.getWritableDatabase();
                    Cursor cursor = wrongSetDb.getReadableDatabase().query("wSet_Db", new String[]{"word"},"word=?",new String[]{sword},null,null,null);
                    if(cursor.getCount() == 0){
                        ContentValues values = new ContentValues();
                        values.put("word", sword);
                        values.put("property", sproperty);
                        values.put("example", sexample);
                        db.insert("wSet_Db", null, values);
                        values.clear();
                    }
                    Intent intentS = new Intent(TestE.this, ShowRight.class);
                    startActivity(intentS);
                }
            }
        });
    }

    /*显示下一个单词*/
    protected void next(){
        GlobalVar.cursorT.moveToNext();
        GlobalVar.j = GlobalVar.j + 1;
        @SuppressLint("Range") String sflag = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("flag"));
        if(sflag.equals("0")){
            GlobalVar.flag = 0;
        }
        else{
            GlobalVar.flag = 1;
        }
        @SuppressLint("Range") String stestc = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("testc"));
        TextView ttestc = (TextView) findViewById(R.id.testE);
        ttestc.setText(stestc);
    }

    //监听返回，数据回溯
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if(GlobalVar.cursorT.moveToPrevious()){
            GlobalVar.j = GlobalVar.j - 1;
            @SuppressLint("Range") String sflag = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("flag"));
            if(sflag.equals("0")){
                GlobalVar.flag = 0;
            }
            else{
                GlobalVar.flag = 1;
            }
        }
        else{
            GlobalVar.flag = 0;
        }
    }

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.teal_200));//设置状态栏背景色
            } else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);//透明
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        } else {
            Toast.makeText(this, "低于4.4的android系统版本不存在沉浸式状态栏", Toast.LENGTH_SHORT).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && useStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}