package doctor.fresh.com.freshdoctor.model;

import android.util.Log;

import doctor.fresh.com.freshdoctor.presenter.OnLoginListener;

/**
 * Created by hewei on 2017/5/1.
 */

public class LoginModel implements ILoginModel {
    private static final String TAG = LoginModel.class.getSimpleName();

    public void doLogin(OnLoginListener onLoginListener) {
        Log.d(TAG, "doLogin()");


    }
}
