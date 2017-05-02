package doctor.fresh.com.freshdoctor.model;

import doctor.fresh.com.freshdoctor.presenter.OnGetVerifyCode;
import doctor.fresh.com.freshdoctor.presenter.OnLoginListener;

/**
 * Created by hewei on 2017/5/1.
 */

public interface ILoginModel {
    public void doLogin(OnLoginListener onLoginListener);
    public void getVerifyCode(String phoneNum, OnGetVerifyCode onGetVerifyCode);
}
