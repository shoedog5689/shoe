package doctor.fresh.com.freshdoctor.common;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by wei.he on 17/4/20.
 */

public class Utils {

    public static void showLongToast(final Context context, final String msg) {
        ((Activity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void showLongToast(final Context context, final int res) {
        ((Activity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, res, Toast.LENGTH_LONG).show();
            }
        });

    }

    public static void showShortToast(final Context context, final String msg) {
        ((Activity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void showShortToast(final Context context, final int res) {
        ((Activity)context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
