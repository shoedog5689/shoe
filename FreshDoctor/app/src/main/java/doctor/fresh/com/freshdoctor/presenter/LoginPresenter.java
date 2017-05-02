package doctor.fresh.com.freshdoctor.presenter;

import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import doctor.fresh.com.freshdoctor.common.Constants;
import doctor.fresh.com.freshdoctor.model.ILoginModel;
import doctor.fresh.com.freshdoctor.model.LoginModel;
import doctor.fresh.com.freshdoctor.view.ILoginView;

/**
 * Created by hewei on 2017/5/1.
 */

public class LoginPresenter implements ILoginPresenter {
    private static final String TAG = LoginPresenter.class.getSimpleName();

    private ILoginView loginView;
    private ILoginModel loginModel;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
        loginView.setPresenter(this);
    }

    @Override
    public void doLogin(OnLoginListener onLoginListener) {
        Log.d(TAG, "doLogin()");
        if (loginModel != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("mobile", loginView.getPhoneNum());
            map.put("code", loginView.getVerifyCode());
            map.put("deviceNo", Constants.DEVICE_NUM);
            map.put("deviceType", Constants.OS);
            loginModel.doLogin(new OnLoginListener() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, "response:" + response);

                }

                @Override
                public void onFailure(String errStr) {

                }
            });
        }
    }

    @Override
    public void getVerifyCode(OnGetVerifyCode onGetVerifyCode) {
        Log.d(TAG, "getVerifyCode()");
        if (loginModel != null) {
            loginModel.getVerifyCode(loginView.getPhoneNum(), new OnGetVerifyCode() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, "getVerifyCode >> onResponse:" + response);
                }

                @Override
                public void onFailure(String errStr) {
                    Log.e(TAG, "getVerifyCode >> onFailure:" + errStr);
                }
            });
        }
    }
}
