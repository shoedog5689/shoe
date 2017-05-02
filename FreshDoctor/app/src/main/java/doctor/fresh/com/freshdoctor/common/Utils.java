package doctor.fresh.com.freshdoctor.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

import doctor.fresh.com.freshdoctor.MyApplication;

/**
 * Created by wei.he on 17/4/20.
 */

public class Utils {

    private static final String INSTALLATION = "INSTALLATION";

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

    public static final String getDeviceNum() {
        StringBuilder sb = new StringBuilder();
        sb.append(Settings.Secure.getString(MyApplication.getInstance().getContentResolver(), Settings.Secure.ANDROID_ID));
        sb.append(((TelephonyManager) MyApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId());
//        String serialNum = ((TelephonyManager) MyApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE)).getSimSerialNumber();
        WifiInfo info = ((WifiManager) MyApplication.getInstance().getSystemService(Context.WIFI_SERVICE)).getConnectionInfo();
        if (null != info) {
            sb.append(info.getMacAddress());
        }
        return DigestUtils.md5Hex(sb.append(getId()).append("pj_health").toString());
    }

    public synchronized static String getId() {
        String sid = "";
        File installation = new File("/sdcard/" + INSTALLATION);
        try {
            if (!installation.exists())
                writeInstallationFile(installation);
            sid = readInstallationFile(installation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sid;
    }

    private static String readInstallationFile(File installation) throws IOException {
        RandomAccessFile f = new RandomAccessFile(installation, "r");
        byte[] bytes = new byte[(int) f.length()];
        f.readFully(bytes);
        f.close();
        return new String(bytes);
    }

    private static void writeInstallationFile(File installation) throws IOException {
        FileOutputStream out = new FileOutputStream(installation);
        String id = UUID.randomUUID().toString();
        out.write(id.getBytes());
        out.close();
    }
}
