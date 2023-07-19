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
import android.widget.TextView;
import android.widget.Toast;

/**
 * 初始界面
 */
public class TestC extends AppCompatActivity {
    //是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    protected boolean useStatusBarColor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView之前添加,未添加的话home键监听无效，设置窗体属性
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_testc);
        //调用实现沉浸式状态栏函数
        setStatusBar();

        //flag初始值设为0，测试词库第一条数据默认为TestE，故不存在TestC的初始化

        next();

        //获取正确答案并对各选项进行监听
        Button t1 =(Button) this.findViewById(R.id.teste1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("Range") String sans = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("ans"));
                if(sans.equals("1")){
                    if(GlobalVar.j < 5){
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(TestC.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            next();
                        }
                    }
                    else {
                        if (GlobalVar.dbnum == 1) {
                            GlobalVar.i1 = 0;
                        } else if (GlobalVar.dbnum == 2) {
                            GlobalVar.i2 = 0;
                        } else if (GlobalVar.dbnum == 3) {
                            GlobalVar.i3 = 0;
                        } else if (GlobalVar.dbnum == 4) {
                            GlobalVar.i4 = 0;
                        } else if (GlobalVar.dbnum == 5) {
                            GlobalVar.i5 = 0;
                        } else {
                            GlobalVar.i6 = 0;
                        }
                        Intent intentM = new Intent(TestC.this, Memory.class);
                        startActivity(intentM);
                    }
                }
                else{
                    @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
                    @SuppressLint("Range") String sproperty = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("property"));
                    @SuppressLint("Range") String sexample = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("example"));
                    WrongSetDb wrongSetDb = new WrongSetDb(TestC.this, "wSet_Db", null, 1);
                    SQLiteDatabase db = wrongSetDb.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("word", sword);
                    values.put("property", sproperty);
                    values.put("example", sexample);
                    db.insert("wSet_Db", null, values);
                    values.clear();
                    Intent intentS = new Intent(TestC.this, ShowRight.class);
                    startActivity(intentS);
                }
            }
        });

        Button t2 =(Button) this.findViewById(R.id.teste2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("Range") String sans = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("ans"));
                if(sans.equals("2")){
                    if(GlobalVar.j < 5){
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(TestC.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            next();
                        }
                    }
                    else {
                        if (GlobalVar.dbnum == 1) {
                            GlobalVar.i1 = 0;
                        } else if (GlobalVar.dbnum == 2) {
                            GlobalVar.i2 = 0;
                        } else if (GlobalVar.dbnum == 3) {
                            GlobalVar.i3 = 0;
                        } else if (GlobalVar.dbnum == 4) {
                            GlobalVar.i4 = 0;
                        } else if (GlobalVar.dbnum == 5) {
                            GlobalVar.i5 = 0;
                        } else {
                            GlobalVar.i6 = 0;
                        }
                        Intent intentM = new Intent(TestC.this, Memory.class);
                        startActivity(intentM);
                    }
                }
                else{
                    @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
                    @SuppressLint("Range") String sproperty = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("property"));
                    @SuppressLint("Range") String sexample = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("example"));
                    WrongSetDb wrongSetDb = new WrongSetDb(TestC.this, "wSet_Db", null, 1);
                    SQLiteDatabase db = wrongSetDb.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("word", sword);
                    values.put("property", sproperty);
                    values.put("example", sexample);
                    db.insert("wSet_Db", null, values);
                    values.clear();
                    Intent intentS = new Intent(TestC.this, ShowRight.class);
                    startActivity(intentS);
                }
            }
        });

        Button t3 =(Button) this.findViewById(R.id.teste3);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("Range") String sans = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("ans"));
                if(sans.equals("3")){
                    if(GlobalVar.j < 5){
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(TestC.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            next();
                        }
                    }
                    else {
                        if (GlobalVar.dbnum == 1) {
                            GlobalVar.i1 = 0;
                        } else if (GlobalVar.dbnum == 2) {
                            GlobalVar.i2 = 0;
                        } else if (GlobalVar.dbnum == 3) {
                            GlobalVar.i3 = 0;
                        } else if (GlobalVar.dbnum == 4) {
                            GlobalVar.i4 = 0;
                        } else if (GlobalVar.dbnum == 5) {
                            GlobalVar.i5 = 0;
                        } else {
                            GlobalVar.i6 = 0;
                        }
                        Intent intentM = new Intent(TestC.this, Memory.class);
                        startActivity(intentM);
                    }
                }
                else{
                    @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
                    @SuppressLint("Range") String sproperty = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("property"));
                    @SuppressLint("Range") String sexample = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("example"));
                    WrongSetDb wrongSetDb = new WrongSetDb(TestC.this, "wSet_Db", null, 1);
                    SQLiteDatabase db = wrongSetDb.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("word", sword);
                    values.put("property", sproperty);
                    values.put("example", sexample);
                    db.insert("wSet_Db", null, values);
                    values.clear();
                    Intent intentS = new Intent(TestC.this, ShowRight.class);
                    startActivity(intentS);
                }
            }
        });

        Button t4 =(Button) this.findViewById(R.id.teste4);
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("Range") String sans = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("ans"));
                if(sans.equals("4")){
                    if(GlobalVar.j < 5){
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(TestC.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(TestC.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                    else {
                        if (GlobalVar.dbnum == 1) {
                            GlobalVar.i1 = 0;
                        } else if (GlobalVar.dbnum == 2) {
                            GlobalVar.i2 = 0;
                        } else if (GlobalVar.dbnum == 3) {
                            GlobalVar.i3 = 0;
                        } else if (GlobalVar.dbnum == 4) {
                            GlobalVar.i4 = 0;
                        } else if (GlobalVar.dbnum == 5) {
                            GlobalVar.i5 = 0;
                        } else {
                            GlobalVar.i6 = 0;
                        }
                        Intent intentM = new Intent(TestC.this, Memory.class);
                        startActivity(intentM);
                    }
                }
                else{
                    @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
                    @SuppressLint("Range") String sproperty = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("property"));
                    @SuppressLint("Range") String sexample = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("example"));
                    WrongSetDb wrongSetDb = new WrongSetDb(TestC.this, "wSet_Db", null, 1);
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
                    Intent intentS = new Intent(TestC.this, ShowRight.class);
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
        @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
        @SuppressLint("Range") String steste1 = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("teste1"));
        @SuppressLint("Range") String steste2 = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("teste2"));
        @SuppressLint("Range") String steste3 = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("teste3"));
        @SuppressLint("Range") String steste4 = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("teste4"));
        TextView tword = (TextView) findViewById(R.id.testC);
        TextView tteste1 = (TextView) findViewById(R.id.teste1);
        TextView tteste2 = (TextView) findViewById(R.id.teste2);
        TextView tteste3 = (TextView) findViewById(R.id.teste3);
        TextView tteste4 = (TextView) findViewById(R.id.teste4);
        tword.setText(sword);
        tteste1.setText(steste1);
        tteste2.setText(steste2);
        tteste3.setText(steste3);
        tteste4.setText(steste4);
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