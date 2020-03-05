package vandewouwer.michael.camelrace.Utils;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ProgressHandler extends Handler {

    private ProgressBar progressBar1;
    private TextView tv1, tv2, tv3;

    public ProgressHandler(ProgressBar progressBar1) {
        this.progressBar1 = progressBar1;
    }


    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        int value = msg.arg1;

        if (Build.VERSION.SDK_INT >= 25)
            progressBar1.setProgress(value, true);
        else
            progressBar1.setProgress(value);

    }
}
