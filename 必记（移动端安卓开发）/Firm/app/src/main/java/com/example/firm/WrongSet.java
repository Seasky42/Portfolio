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
 * 错题界面
 */
public class WrongSet extends AppCompatActivity {
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
        setContentView(R.layout.activity_wrongset);
        //调用实现沉浸式状态栏函数
        setStatusBar();

        next();

        /*对next按钮进行监听*/
        Button nt = (Button) this.findViewById(R.id.Wnext);
        nt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        /*对last按钮进行监听*/
        Button lt = (Button) this.findViewById(R.id.Wlast);
        lt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                last();
            }
        });

        /*对menu建立监听*/
        MaterialButton menu = (MaterialButton) this.findViewById(R.id.Wmenu);
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
        if(GlobalVar.cursorW.moveToNext()){
            @SuppressLint("Range") String Wword = GlobalVar.cursorW.getString(GlobalVar.cursorW.getColumnIndex("word"));
            @SuppressLint("Range") String Wproperty = GlobalVar.cursorW.getString(GlobalVar.cursorW.getColumnIndex("property"));
            @SuppressLint("Range") String Wexample = GlobalVar.cursorW.getString(GlobalVar.cursorW.getColumnIndex("example"));
            TextView tword = (TextView) findViewById(R.id.WrongWord);
            TextView tproperty = (TextView) findViewById(R.id.Wproperty);
            TextView texmeple = (TextView) findViewById(R.id.Wexample);
            tword.setText(Wword);
            tproperty.setText(Wproperty);
            texmeple.setText(Wexample);
        }
        else{
            GlobalVar.cursorW.moveToPrevious();
            Toast.makeText(WrongSet.this, "没有更多错题啦！", Toast.LENGTH_SHORT).show();
        }
    }

    /*显示上一个单词*/
    protected void last(){
        if(GlobalVar.cursorW.moveToPrevious()){
            @SuppressLint("Range") String Wword = GlobalVar.cursorW.getString(GlobalVar.cursorW.getColumnIndex("word"));
            @SuppressLint("Range") String Wproperty = GlobalVar.cursorW.getString(GlobalVar.cursorW.getColumnIndex("property"));
            @SuppressLint("Range") String Wexample = GlobalVar.cursorW.getString(GlobalVar.cursorW.getColumnIndex("example"));
            TextView tword = (TextView) findViewById(R.id.WrongWord);
            TextView tproperty = (TextView) findViewById(R.id.Wproperty);
            TextView texmeple = (TextView) findViewById(R.id.Wexample);
            tword.setText(Wword);
            tproperty.setText(Wproperty);
            texmeple.setText(Wexample);
        }
        else{
            GlobalVar.cursorW.moveToNext();
            Toast.makeText(WrongSet.this, "淇则有岸，隰则有泮", Toast.LENGTH_SHORT).show();
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
                    Intent intent2 = new Intent(WrongSet.this, Memory.class);
                    startActivity(intent2);
                    popupWindow.dismiss();
                }
            });

            Button wrongSet = popipWindow_view.findViewById(R.id.wrongSet);
            wrongSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });

            Button wordSet = popipWindow_view.findViewById(R.id.wordSet);
            wordSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent3 = new Intent(WrongSet.this, MainActivity.class);
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
