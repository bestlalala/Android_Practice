package smwu.mobileprogramming.part7_1_1_musicplayerservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MusicService musicService;
    Button mStart, mPlay, mPause, mStop;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicService = ((MusicService.MusicServiceBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStart = findViewById(R.id.connButton);
        mPlay = findViewById(R.id.play);
        mPause = findViewById(R.id.pause);
        mStop = findViewById(R.id.disConnButton);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(MainActivity.this, MusicService.class);
                startService(service);
                bindService(service, conn, BIND_AUTO_CREATE);
            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicService.play();
            }
        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicService.pause();
            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(MainActivity.this, MusicService.class);
                unbindService(conn);
                stopService(service);
            }
        });
    }
}