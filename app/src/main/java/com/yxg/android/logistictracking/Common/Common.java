package com.yxg.android.logistictracking.Common;

import android.content.Context;
import android.content.IntentFilter;

public class Common {


    //操作工编号
    public static String workId = "";
    public static String serverIP = "";        //服务器地址
    public static String serverport = "80";      //服务器端口
    public static String serverUrl = "";        //服务器url
    public static ScanBroadCast scanBroadCast;
    public static Context app;
    public static String action = "scan";




    //清除回调扫描
    public static void clearBroadCastDelegate()
    {
        scanBroadCast.setiScanDelegate(null);
    }


    public static void registerBroadCast()
    {

        IntentFilter intentFilter=new IntentFilter(action);
        ScanBroadCast scanBroadCast11=new ScanBroadCast();
        scanBroadCast =scanBroadCast11;
        app.registerReceiver(scanBroadCast,intentFilter);
    }

    public static void unregisterbroadCast()
    {
        app.unregisterReceiver(scanBroadCast);
        scanBroadCast = null;
    }

    //得到服务器地址
    public static String getServerAddr() {
        return String.format("http://%1$s:%2$s", serverIP, serverport);
    }



}
