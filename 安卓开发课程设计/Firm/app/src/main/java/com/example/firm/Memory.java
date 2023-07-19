package com.example.firm;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

/**
 * 记忆界面
 */
public class Memory extends AppCompatActivity {
    //是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    protected boolean useStatusBarColor = true;
    protected PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView之前添加,未添加的话home键监听无效，设置窗体属性
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_memory);
        //调用实现沉浸式状态栏函数
        setStatusBar();

        /*创建对应的词库*/
        if(GlobalVar.dbnum == 1 && GlobalVar.opM1 == 0){
            PrimaryDb primarydb = new PrimaryDb(this, "zhongkao_db", null, 1);
            primarydb.getWritableDatabase();
            GlobalVar.cursorM1 = primarydb.getReadableDatabase().query("zhongkao_db",null,null,null,null,null,null);
            GlobalVar.opM1 = 1;
        }
        else if(GlobalVar.dbnum == 2 && GlobalVar.opM2 == 0){
            HighDb highdb = new HighDb(this, "gaokao_db", null, 1);
            highdb.getWritableDatabase();
            GlobalVar.cursorM2 = highdb.getReadableDatabase().query("gaokao_db",null,null,null,null,null,null);
            GlobalVar.opM2 = 1;
        }
        else if(GlobalVar.dbnum == 3 && GlobalVar.opM3 == 0){
            CET4db cet4db = new CET4db(this, "CET4_db", null, 1);
            cet4db.getWritableDatabase();
            GlobalVar.cursorM3 = cet4db.getWritableDatabase().query("CET4_db", null,null, null, null, null, null);
            GlobalVar.opM3 = 1;
        }
        else if(GlobalVar.dbnum == 4 && GlobalVar.opM4 == 0){
            CET6db cet6db = new CET6db(this, "CET6_db", null, 1);
            cet6db.getWritableDatabase();
            GlobalVar.cursorM4 = cet6db.getReadableDatabase().query("CET6_db",null,null,null,null,null,null);
            GlobalVar.opM4 = 1;
        }
        else if(GlobalVar.dbnum == 5 && GlobalVar.opM5 == 0){
            GraDb graDb = new GraDb(this, "gra_db",null, 1);
            graDb.getWritableDatabase();
            GlobalVar.cursorM5 = graDb.getWritableDatabase().query("gra_db", null, null, null, null, null, null);
            GlobalVar.opM5 = 1;
        }
        else if(GlobalVar.dbnum == 6 && GlobalVar.opM6 == 0){
            ComDb comDb = new ComDb(this, "com_db", null, 1);
            comDb.getWritableDatabase();
            GlobalVar.cursorM6 = comDb.getWritableDatabase().query("com_db", null, null, null, null, null, null);
            GlobalVar.opM6 = 1;
        }

        next();

        /*对next按钮进行监听*/
        Button nt = (Button) this.findViewById(R.id.next);
        nt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(GlobalVar.dbnum == 1){
                    if(GlobalVar.i1 < 5){
                        next();
                    }
                    else{
                        GlobalVar.j = 0;
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(Memory.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(Memory.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                }
                else if(GlobalVar.dbnum == 2){
                    if(GlobalVar.i2 < 5){
                        next();
                    }
                    else{
                        GlobalVar.j = 0;
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(Memory.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(Memory.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                }
                else if(GlobalVar.dbnum == 3){
                    if(GlobalVar.i3 < 5){
                        next();
                    }
                    else{
                        GlobalVar.j = 0;
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(Memory.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(Memory.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                }
                else if(GlobalVar.dbnum == 4){
                    if(GlobalVar.i4 < 5){
                        next();
                    }
                    else{
                        GlobalVar.j = 0;
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(Memory.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(Memory.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                }
                else if(GlobalVar.dbnum == 5){
                    if(GlobalVar.i5 < 5){
                        next();
                    }
                    else{
                        GlobalVar.j = 0;
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(Memory.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(Memory.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                }
                else{
                    if(GlobalVar.i6 < 5){
                        next();
                    }
                    else{
                        GlobalVar.j = 0;
                        if(GlobalVar.flag == 0){
                            Intent intentE = new Intent(Memory.this, TestE.class);
                            startActivity(intentE);
                        }
                        else{
                            Intent intentC = new Intent(Memory.this, TestC.class);
                            startActivity(intentC);
                        }
                    }
                }
            }
        });

        /*对last按钮进行监听*/
        Button lt = (Button) this.findViewById(R.id.last);
        lt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                last();
            }
        });

        /*对menu建立监听*/
        MaterialButton menu = (MaterialButton) this.findViewById(R.id.menu);
        getIconcenter(menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPopupWindow();
                popupWindow.showAtLocation(menu, Gravity.LEFT,0,0);
            }
        });
    }

    /*显示下一个单词*/
    protected void next(){
        if(GlobalVar.dbnum == 1){
            if(GlobalVar.cursorM1.moveToNext()){
                GlobalVar.i1 = GlobalVar.i1 + 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM1.getString(GlobalVar.cursorM1.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM1.getString(GlobalVar.cursorM1.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM1.getString(GlobalVar.cursorM1.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                Toast.makeText(Memory.this, "恭喜你已经背完中考词库啦！", Toast.LENGTH_SHORT).show();
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText("初出茅庐");
                tproperty.setText("达成成就");
                texmeple.setText("");
            }
        }
        else if(GlobalVar.dbnum == 2){
            if(GlobalVar.cursorM2.moveToNext()){
                GlobalVar.i2 = GlobalVar.i2 + 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM2.getString(GlobalVar.cursorM2.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM2.getString(GlobalVar.cursorM2.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM2.getString(GlobalVar.cursorM2.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                Toast.makeText(Memory.this, "恭喜你已经背完高考词库啦！", Toast.LENGTH_SHORT).show();
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText("衣带渐宽");
                tproperty.setText("达成成就");
                texmeple.setText("");
            }

        }
        else if(GlobalVar.dbnum == 3){
            if(GlobalVar.cursorM3.moveToNext()){
                GlobalVar.i3 = GlobalVar.i3 + 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM3.getString(GlobalVar.cursorM3.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM3.getString(GlobalVar.cursorM3.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM3.getString(GlobalVar.cursorM3.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                Toast.makeText(Memory.this, "恭喜你已经背完四级词库啦！", Toast.LENGTH_SHORT).show();
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText("独上高楼");
                tproperty.setText("达成成就");
                texmeple.setText("");
            }
        }
        else if(GlobalVar.dbnum == 4){
            if(GlobalVar.cursorM4.moveToNext()){
                GlobalVar.i4 = GlobalVar.i4 + 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM4.getString(GlobalVar.cursorM4.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM4.getString(GlobalVar.cursorM4.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM4.getString(GlobalVar.cursorM4.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                Toast.makeText(Memory.this, "恭喜你已经背完六级词库啦！", Toast.LENGTH_SHORT).show();
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText("蓦然回首");
                tproperty.setText("达成成就");
                texmeple.setText("");
            }
        }
        else if(GlobalVar.dbnum == 5){
            if(GlobalVar.cursorM5.moveToNext()){
                GlobalVar.i5 = GlobalVar.i5 + 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM5.getString(GlobalVar.cursorM5.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM5.getString(GlobalVar.cursorM5.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM5.getString(GlobalVar.cursorM5.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                Toast.makeText(Memory.this, "恭喜你已经背完考研词库啦！", Toast.LENGTH_SHORT).show();
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText("一代宗师");
                tproperty.setText("达成成就");
                texmeple.setText("");
            }

        }
        else{
            if(GlobalVar.cursorM6.moveToNext()){
                GlobalVar.i6 = GlobalVar.i6 + 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM6.getString(GlobalVar.cursorM6.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM6.getString(GlobalVar.cursorM6.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM6.getString(GlobalVar.cursorM6.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                Toast.makeText(Memory.this, "恭喜你已经可以出国啦！", Toast.LENGTH_SHORT).show();
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText("扫地僧");
                tproperty.setText("达成成就");
                texmeple.setText("");
            }

        }
    }

    /*显示上一个单词*/
    protected void last(){
        if(GlobalVar.dbnum == 1){
            if(GlobalVar.cursorM1.moveToPrevious()){
                GlobalVar.i1 = GlobalVar.i1 - 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM1.getString(GlobalVar.cursorM1.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM1.getString(GlobalVar.cursorM1.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM1.getString(GlobalVar.cursorM1.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                GlobalVar.cursorM1.moveToNext();
                Toast.makeText(Memory.this, "想要从头再来？你已经回到起点啦！", Toast.LENGTH_SHORT).show();
            }

        }
        else if(GlobalVar.dbnum == 2){
            if(GlobalVar.cursorM2.moveToPrevious()){
                GlobalVar.i2 = GlobalVar.i2 - 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM2.getString(GlobalVar.cursorM2.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM2.getString(GlobalVar.cursorM2.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM2.getString(GlobalVar.cursorM2.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                GlobalVar.cursorM2.moveToNext();
                Toast.makeText(Memory.this, "想要从头再来？你已经回到起点啦！", Toast.LENGTH_SHORT).show();
            }

        }
        else if(GlobalVar.dbnum == 3){
            if(GlobalVar.cursorM3.moveToPrevious()){
                GlobalVar.i3 = GlobalVar.i3 - 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM3.getString(GlobalVar.cursorM3.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM3.getString(GlobalVar.cursorM3.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM3.getString(GlobalVar.cursorM3.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                GlobalVar.cursorM3.moveToNext();
                Toast.makeText(Memory.this, "想要从头再来？你已经回到起点啦！", Toast.LENGTH_SHORT).show();
            }
        }
        else if(GlobalVar.dbnum == 4){
            if(GlobalVar.cursorM4.moveToPrevious()){
                GlobalVar.i4 = GlobalVar.i4 - 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM4.getString(GlobalVar.cursorM4.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM4.getString(GlobalVar.cursorM4.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM4.getString(GlobalVar.cursorM4.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                GlobalVar.cursorM4.moveToNext();
                Toast.makeText(Memory.this, "想要从头再来？你已经回到起点啦！", Toast.LENGTH_SHORT).show();
            }
        }
        else if(GlobalVar.dbnum == 5){
            if(GlobalVar.cursorM5.moveToPrevious()){
                GlobalVar.i5 = GlobalVar.i5 - 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM5.getString(GlobalVar.cursorM5.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM5.getString(GlobalVar.cursorM5.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM5.getString(GlobalVar.cursorM5.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                GlobalVar.cursorM5.moveToNext();
                Toast.makeText(Memory.this, "想要从头再来？你已经回到起点啦！", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            if(GlobalVar.cursorM6.moveToPrevious()){
                GlobalVar.i6 = GlobalVar.i6 - 1;
                @SuppressLint("Range") String sword = GlobalVar.cursorM6.getString(GlobalVar.cursorM6.getColumnIndex("word"));
                @SuppressLint("Range") String sproperty = GlobalVar.cursorM6.getString(GlobalVar.cursorM6.getColumnIndex("property"));
                @SuppressLint("Range") String sexample = GlobalVar.cursorM6.getString(GlobalVar.cursorM6.getColumnIndex("example"));
                TextView tword = (TextView) findViewById(R.id.word);
                TextView tproperty = (TextView) findViewById(R.id.property);
                TextView texmeple = (TextView) findViewById(R.id.example);
                tword.setText(sword);
                tproperty.setText(sproperty);
                texmeple.setText(sexample);
            }
            else{
                GlobalVar.cursorM6.moveToNext();
                Toast.makeText(Memory.this, "想要从头再来？你已经回到起点啦！", Toast.LENGTH_SHORT).show();
            }

        }
    }

    //监听返回，数据回溯
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if(GlobalVar.dbnum == 1){
            GlobalVar.cursorM1.moveToPrevious();
            GlobalVar.i1 = GlobalVar.i1 - 1;
        }
        else if(GlobalVar.dbnum == 2){
            GlobalVar.cursorM2.moveToPrevious();
            GlobalVar.i2 = GlobalVar.i2 - 1;
        }
        else if(GlobalVar.dbnum == 3){
            GlobalVar.cursorM3.moveToPrevious();
            GlobalVar.i3 = GlobalVar.i3 - 1;
        }
        else if(GlobalVar.dbnum == 4){
            GlobalVar.cursorM4.moveToPrevious();
            GlobalVar.i4 = GlobalVar.i4 - 1;
        }
        else if(GlobalVar.dbnum == 5){
            GlobalVar.cursorM5.moveToPrevious();
            GlobalVar.i5 = GlobalVar.i5 - 1;
        }
        if(GlobalVar.dbnum == 6){
            GlobalVar.cursorM6.moveToPrevious();
            GlobalVar.i6 = GlobalVar.i6 - 1;
        }
    }

    /*获取PopipWinsow实例*/
    private  void  getPopupWindow(){
        if (null!=popupWindow){

            popupWindow.dismiss();
        }else {
            //获取自定义布局文件activity_pop_left.xml 布局文件
            final View popipWindow_view = getLayoutInflater().inflate(R.layout.activity_menu,null,false);
            //创建Popupwindow 实例，200，LayoutParams.MATCH_PARENT 分别是宽高
            popupWindow = new PopupWindow(popipWindow_view,500, ViewGroup.LayoutParams.MATCH_PARENT,true);
            popupWindow.setFocusable(true);
            popupWindow.setTouchable(true);
            //设置动画效果
            popupWindow.setAnimationStyle(androidx.appcompat.R.style.Base_TextAppearance_AppCompat_Menu);
            //点击其他地方消失
            popipWindow_view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (popipWindow_view != null && popipWindow_view.isShown()) {
                        popupWindow.dismiss();
                        popupWindow = null;
                    }
                    return false;
                }
            });
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            Button back = popipWindow_view.findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });

            Button wrongSet = popipWindow_view.findViewById(R.id.wrongSet);
            wrongSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = new Intent(Memory.this, WrongSet.class);
                    startActivity(intent2);
                    popupWindow.dismiss();
                }
            });

            Button wordSet = popipWindow_view.findViewById(R.id.wordSet);
            wordSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent3 = new Intent(Memory.this, MainActivity.class);
                    startActivity(intent3);
                    popupWindow.dismiss();
                }
            });
        }
    }



    public void getIconcenter(final MaterialButton btn){
        btn.post(new Runnable() {
            @Override
            public void run() {
                int btnwidth = btn.getWidth();
                btn.measure(0, 0);
                int iconwidth = btn.getIcon().getIntrinsicWidth();
                int paddingleft = ( btnwidth - iconwidth  ) / 2;
                btn.setPadding( paddingleft , 0, 0, 0 );
            }
        });
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
