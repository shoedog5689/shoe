package doctor.fresh.com.freshdoctor.presenter;

import android.util.Log;

import org.json.JSONObject;

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
            loginModel.doLogin(new OnLoginListener() {
                @Override
                public void onResponse(JSONObject response) {

                }

                @Override
                public void onFailure(String errStr) {

                }
            });
        }
    }
}
