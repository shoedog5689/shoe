package doctor.fresh.com.freshdoctor.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import doctor.fresh.com.freshdoctor.R;
import doctor.fresh.com.freshdoctor.presenter.ILoginPresenter;
import doctor.fresh.com.freshdoctor.presenter.LoginPresenter;
import doctor.fresh.com.freshdoctor.presenter.OnLoginListener;

/**
 * Created by wei.he on 17/4/28.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private TextInputEditText userNameEt, passwordEt;
    private AppCompatButton loginBtn;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        loginPresenter = new LoginPresenter(this);

        initView();
    }

    private void initView() {
        Log.d(TAG, "initView()");

        userNameEt = (TextInputEditText) findViewById(R.id.user_name_dt);
        passwordEt = (TextInputEditText) findViewById(R.id.password_et);
        loginBtn = (AppCompatButton) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

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
}
