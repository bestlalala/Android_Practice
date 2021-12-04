package smwu.mp.part7_3_1_myreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public final static String MyAction = "smwu.mp.part7_3_1_myreceiver.ACTION_MY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "전원 연결", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(intent.getAction())) {
            Toast.makeText(context, "전원 비연결", Toast.LENGTH_SHORT).show();
        } else if (MyAction.equals(intent.getAction())) {
            Toast.makeText(context, "broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}