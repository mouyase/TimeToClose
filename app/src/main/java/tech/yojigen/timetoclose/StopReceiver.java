package tech.yojigen.timetoclose;

import android.app.IActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.widget.Toast;

import rikka.shizuku.ShizukuBinderWrapper;
import rikka.shizuku.SystemServiceHelper;

public class StopReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        IActivityManager iActivityManager = IActivityManager.Stub.asInterface(new ShizukuBinderWrapper(SystemServiceHelper.getSystemService("activity")));
        try {
            iActivityManager.forceStopPackage("tv.danmaku.bili", 0);
            Toast.makeText(context, "哔哩哔哩给爷死", Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}