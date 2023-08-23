package com.example.firm;

import android.annotation.SuppressLint;
import android.database.Cursor;

public class GlobalVar {
    //记录当前使用的是那个数据库
    public static int dbnum;
    //记忆数据库游标
    public static Cursor cursorM1, cursorM2, cursorM3, cursorM4, cursorM5, cursorM6;
    //测试数据库游标
    public static Cursor cursorT;
    //错题数据库游标
    public static Cursor cursorW;
    //记录记忆数据库是否已经建立
    public static int opM1 = 0, opM2 = 0, opM3 = 0, opM4 = 0, opM5 = 0, opM6 = 0;
    //记录测试数据库是否已经建立
    public static int opT1 = 0, opT2 = 0, opT3 = 0, opT4 = 0, opT5 = 0, opT6 = 0;
    //记录错题数据库是否已经建立
    public static int opW = 0;
    //记录记忆数据库当前组中位置
    public static int i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0;
    //记录测试数据库当前组中位置
    public static int j;
    //记录下一条数据的测试类型
    public static int flag = 0;

}
