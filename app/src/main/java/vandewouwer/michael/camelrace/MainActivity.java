package vandewouwer.michael.camelrace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import vandewouwer.michael.camelrace.Utils.ProgressHandler;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb1, pb2, pb3;
    private Button btn_start;
    private TextView tv1, tv2, tv3;
    private Handler mHandler, mHandler2, mHandler3;
    private boolean isRunning = false;

    int min = 1;
    int max = 100;


    private View.OnClickListener startRaceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!isRunning)
                camelRaceThread1();
            if (!isRunning)
                camelRaceThread2();
            if (!isRunning)
                camelRaceThread3();


        }
    };

    private void camelRaceThread3() {
        final int random = new Random().nextInt((max - min) + 1) + min;
        Thread raceThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i = 0; i <= 20; i++) {
                    Message message = new Message();
                    message.arg1 = i;
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler3.sendMessage(message);

                }
                isRunning = false;
            }
        });
        raceThread1.start();
    }


    private void camelRaceThread2() {
        final int random = new Random().nextInt((max - min) + 1) + min;
        Thread raceThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i = 0; i <= 20; i++) {
                    Message message = new Message();
                    message.arg1 = i;
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler2.sendMessage(message);

                }
                isRunning = false;
            }
        });
        raceThread2.start();
    }


    private void camelRaceThread1() {

        final int random = new Random().nextInt((max - min) + 1) + min;

        Thread raceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                for (int i = 0; i <= 20; i++) {
                    Message message = new Message();
                    message.arg1 = i;
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler.sendMessage(message);

                }
                isRunning = false;
            }
        });
        raceThread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv_camel1);
        tv2 = findViewById(R.id.tv_camel2);
        tv3 = findViewById(R.id.tv_camel3);
        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);
        pb3 = findViewById(R.id.pb3);
        btn_start = findViewById(R.id.button);
        mHandler = new ProgressHandler(pb1);
        mHandler2 = new ProgressHandler(pb2);
        mHandler3 = new ProgressHandler(pb3);

        btn_start.setOnClickListener(startRaceListener);


    }
}
