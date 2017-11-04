package tw.com.abc.myservice2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private MyService myService;
    private TextView tv;
    boolean isBound;
    private ServiceConnection mConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.LocalBinder binder = (MyService.LocalBinder)iBinder;
            myService =binder.getService()
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound=false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//用onStart 和 onPause 來取代 onCreate  和 onDestory，讓跳出系統（App 未結束）會中斷Service
    @Override
    protected void onStart() {
        super.onStart();
        Intent it = new Intent(this,MyService.class);
        bindService(it,mConnection ,Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isBound){
            unbindService(mConnection);
        }
    }
    public void test1(View view){
        myService.doSomething("brad");
    }
}
