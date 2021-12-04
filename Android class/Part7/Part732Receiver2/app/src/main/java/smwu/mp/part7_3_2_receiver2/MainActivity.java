package smwu.mp.part7_3_2_receiver2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView ivBattery;
    EditText etBattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배터리 상태 체크");

        ivBattery = findViewById(R.id.imageBattery);
        etBattery = findViewById(R.id.editBattery);

    }
    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                etBattery.setText("현재 충전량 : " + remain + "%\n");

                if (remain >= 90)
                    ivBattery.setImageResource(R.drawable.battery_100);
                else if (remain >= 70)
                    ivBattery.setImageResource(R.drawable.battery_80);
                else if (remain >= 50)
                    ivBattery.setImageResource(R.drawable.battery_60);
                else if (remain >= 30)
                    ivBattery.setImageResource(R.drawable.battery_40);
                else if (remain >= 10)
                    ivBattery.setImageResource(R.drawable.battery_20);
                else
                    ivBattery.setImageResource(R.drawable.battery_0);

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (plug) {
                    case 0:
                        etBattery.append("전원 연결 : 안 됨 \n");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        etBattery.append("전원 연결 : 어댑터 연결됨  \n");
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        etBattery.append("전원 연결 : USB 연결됨\n");
                        break;
                }
            }

            // 배터리 상태 출력
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
            switch (status) {
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    Toast.makeText(getApplicationContext(), "배터리 상태: 현재 충전 중임", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    Toast.makeText(getApplicationContext(), "배터리 상태: 현재 충전 중 아님", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    Toast.makeText(getApplicationContext(), "배터리 상태: 충전 100% 완료", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    Toast.makeText(getApplicationContext(), "배터리 상태: 방전됨", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "배터리 상태: 상태 알 수 없음", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }
}