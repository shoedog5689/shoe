package doctor.fresh.com.freshdoctor.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import doctor.fresh.com.freshdoctor.R;

/**
 * Created by wei.he on 17/4/28.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        initView();
    }

    private void initView() {

    }
}
