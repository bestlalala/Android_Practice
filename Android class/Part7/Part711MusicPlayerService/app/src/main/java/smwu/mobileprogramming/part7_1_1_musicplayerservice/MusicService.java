package smwu.mobileprogramming.part7_1_1_musicplayerservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service {
    private MediaPlayer mp;


    IBinder binder = new MusicServiceBinder();

    public class MusicServiceBinder extends Binder {
        public MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.mission_impossible);
        mp.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(getApplicationContext(), "서비스 연결", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), "서비스 연결 해제", Toast.LENGTH_SHORT).show();
        mp.stop();
        super.onDestroy();
    }

    public void play() {
        Toast.makeText(getApplicationContext(), "사운드 재생", Toast.LENGTH_SHORT).show();
        mp.start();
    }

    public void pause(){
        Toast.makeText(getApplicationContext(), "사운드 일시정지", Toast.LENGTH_SHORT).show();
        mp.pause();
    }
}