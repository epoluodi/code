package com.yxg.android.logistictracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GJBD extends AppCompatActivity {

    private RelativeLayout btn1,btn2,btn3;
    private EditText editcode;

    private List<Map<String,String>> mapList;
    private String jjdh,th,gcbh,gjh,tm,tm2d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gjbd);
        btn1 = (RelativeLayout)findViewById(R.id.btn1);
        btn2 = (RelativeLayout)findViewById(R.id.btn2);
        btn3 = (RelativeLayout)findViewById(R.id.btn3);


        editcode = (EditText)findViewById(R.id.editcode);



        //返回
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =new AlertDialog.Builder(GJBD.this);
                builder.setTitle("提示").setMessage("确定要退出当前业务吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.show();

            }
        });

        mapList = new ArrayList<>();


    }



    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter("android.intent.ACTION_DECODE_DATA");

        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }



    //注册条码接收广播
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String barcode = intent.getStringExtra("barcode_string");
            Log.e("扫描的条码",barcode);
            editcode.setText(barcode);
        }
    };




}
