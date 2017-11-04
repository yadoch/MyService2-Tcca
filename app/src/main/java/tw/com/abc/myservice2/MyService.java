package tw.com.abc.myservice2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {
    private final IBinder mBinder = new LocalBinder();

    public  class  LocalBinder extends Binder{
        MyService getService(){
            Log.i("geoff","getService()");
            return MyService.this;
        }
    }

    public MyService() {
        Log.i("geoff","MyService()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("geoff","onBind()");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("geoff","onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private void doSomething(String str){

    }
}
