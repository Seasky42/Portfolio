package com.example.firm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
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
 * 展示界面
 */
public class ShowRight extends AppCompatActivity {
    //是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    protected boolean useStatusBarColor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView之前添加,未添加的话home键监听无效，设置窗体属性
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_showright);
        //调用实现沉浸式状态栏函数
        setStatusBar();

        @SuppressLint("Range") String sword = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("word"));
        @SuppressLint("Range") String sproperty = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("property"));
        @SuppressLint("Range") String sexample = GlobalVar.cursorT.getString(GlobalVar.cursorT.getColumnIndex("example"));
        TextView tword = (TextView) findViewById(R.id.Sword);
        TextView tproperty = (TextView) findViewById(R.id.Sproperty);
        TextView texmeple = (TextView) findViewById(R.id.Sexample);
        tword.setText(sword);
        tproperty.setText(sproperty);
        texmeple.setText(sexample);

        Toast.makeText(ShowRight.this, "单词拼错啦！已加入错题本", Toast.LENGTH_SHORT).show();

        /*以下为对按钮showDown的监听*/
        Button sDown = (Button) this.findViewById(R.id.showDown);
        sDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ShowRight.this.finish();
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