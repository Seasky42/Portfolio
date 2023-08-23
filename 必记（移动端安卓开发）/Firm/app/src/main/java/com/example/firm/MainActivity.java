package com.example.firm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * 初始界面
 */
public class MainActivity extends AppCompatActivity {
    //是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useThemestatusBarColor = false;
    //是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置
    protected boolean useStatusBarColor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView之前添加,未添加的话home键监听无效，设置窗体属性
        this.getWindow().setFlags(0x80000000, 0x80000000);
        setContentView(R.layout.activity_main);
        //调用实现沉浸式状态栏函数
        setStatusBar();

        //创建错题词库以备使用
        if(GlobalVar.opW == 0){
            WrongSetDb wrongSetDb = new WrongSetDb(MainActivity.this, "wSet_Db", null, 1);
            wrongSetDb.getWritableDatabase();
            GlobalVar.cursorW = wrongSetDb.getReadableDatabase().query("wSet_Db",null,null,null,null,null,null);
            GlobalVar.opW = 1;
        }

        /*以下为对六个button的监听*/
        Button btn1 = (Button) this.findViewById(R.id.button_primary);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVar.dbnum = 1;
                Intent intent1 = new Intent(MainActivity.this, Memory.class);
                startActivity(intent1);
            }
        });

        Button btn2 = (Button) this.findViewById(R.id.button_high);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVar.dbnum = 2;
                Intent intent2 = new Intent(MainActivity.this, Memory.class);
                startActivity(intent2);
            }
        });

        Button btn3 = (Button) this.findViewById(R.id.button_CET4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVar.dbnum = 3;
                Intent intent3 = new Intent(MainActivity.this, Memory.class);
                startActivity(intent3);
            }
        });

        Button btn4 = (Button) this.findViewById(R.id.button_CET6);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVar.dbnum = 4;
                Intent intent4 = new Intent(MainActivity.this, Memory.class);
                startActivity(intent4);
            }
        });

        Button btn5 = (Button) this.findViewById(R.id.button_postgraduate);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVar.dbnum = 5;
                Intent intent5 = new Intent(MainActivity.this, Memory.class);
                startActivity(intent5);
            }
        });

        Button btn6 = (Button) this.findViewById(R.id.button_abroad);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVar.dbnum = 6;
                Intent intent6 = new Intent(MainActivity.this, Memory.class);
                startActivity(intent6);
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