package com.yxg.android.logistictracking.Common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScanBroadCast extends BroadcastReceiver {


    private IScanDelegate iScanDelegate = null;

    public void setiScanDelegate(IScanDelegate iScanDelegate) {
        this.iScanDelegate = iScanDelegate;
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        String data = intent.getStringExtra("data");
        Log.e("扫描到的条码",data);
        if (iScanDelegate != null)
            iScanDelegate.onScanDataResult(data);

    }


    //扫描回调
    public interface IScanDelegate {
        void onScanDataResult(String barcode);
    }
}
