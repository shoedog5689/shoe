package doctor.fresh.com.freshdoctor;

import android.app.Application;

/**
 * Created by hewei on 2017/5/2.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    public static MyApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }
}
