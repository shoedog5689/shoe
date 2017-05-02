package doctor.fresh.com.freshdoctor.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import doctor.fresh.com.freshdoctor.R;
import doctor.fresh.com.freshdoctor.common.Utils;
import doctor.fresh.com.freshdoctor.presenter.ILoginPresenter;
import doctor.fresh.com.freshdoctor.presenter.LoginPresenter;
import doctor.fresh.com.freshdoctor.presenter.OnGetVerifyCode;
import doctor.fresh.com.freshdoctor.presenter.OnLoginListener;

/**
 * Created by wei.he on 17/4/28.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private TextInputEditText userNameEt, passwordEt;
    private AppCompatButton loginBtn, verifycodeBtn;
    private ILoginPresenter loginPresenter;
    private CountDownTime countDownTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        loginPresenter = new LoginPresenter(this);

        initView();

        countDownTime = new CountDownTime(60000, 1000);
    }

    private void initView() {
        Log.d(TAG, "initView()");

        userNameEt = (TextInputEditText) findViewById(R.id.user_name_dt);
        passwordEt = (TextInputEditText) findViewById(R.id.password_et);
        verifycodeBtn = (AppCompatButton) findViewById(R.id.verify_code_btn);
        loginBtn = (AppCompatButton) findViewById(R.id.login_btn);
        verifycodeBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void setPresenter(ILoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public ILoginPresenter getPresenter() {
        return loginPresenter;
    }

    @Override
    public Activity getViewActivity() {
        return this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                if (loginPresenter != null) {
                    loginPresenter.doLogin(new OnLoginListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //Login Success
                        }

                        @Override
                        public void onFailure(String errStr) {
                            //Login Failed

                        }
                    });
                }
                break;
            case R.id.verify_code_btn:
                countDownTime.start();
                verifycodeBtn.setClickable(false);

                //get verify code
                loginPresenter.getVerifyCode(new OnGetVerifyCode() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse:" + response);
                    }

                    @Override
                    public void onFailure(String errStr) {
                        Log.e(TAG, "onFailure:" + errStr);
                        Utils.showLongToast(LoginActivity.this, errStr);
                    }
                });
        }
    }

    class CountDownTime extends CountDownTimer {

        //构造函数  第一个参数代表总的计时时长  第二个参数代表计时间隔  单位都是毫秒
        public CountDownTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) { //每计时一次回调一次该方法
            verifycodeBtn.setText((l-1)/1000 + "秒后请重试");
        }

        @Override
        public void onFinish() { //计时结束回调该方法
            verifycodeBtn.setClickable(true);
            verifycodeBtn.setText(R.string.login_send_verify_code);
        }
    }

    @Override
    public String getPhoneNum() {
        return userNameEt.getText().toString().trim();
    }

    @Override
    public String getVerifyCode() {
        return verifycodeBtn.getText().toString().trim();
    }
}
