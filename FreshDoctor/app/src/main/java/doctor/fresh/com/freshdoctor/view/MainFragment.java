package doctor.fresh.com.freshdoctor.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import doctor.fresh.com.freshdoctor.BaseFragment;
import doctor.fresh.com.freshdoctor.R;

import doctor.fresh.com.freshdoctor.model.MainModel;
import doctor.fresh.com.freshdoctor.presenter.OnBannerListListener;

/**
 * Created by hewei on 2017/4/17.
 */

public class MainFragment extends BaseFragment implements IMainView {

    private static final String TAG = MainFragment.class.getSimpleName();

    private TextView textView;
    private ViewPager viewPager;

    public static MainFragment newInstance() {
        Log.d(TAG, "newInstance()");
        return new MainFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.testTv);
        viewPager = (ViewPager) view.findViewById(R.id.main_viewpager);

        MainModel.getInstance().getMainBannerList(new OnBannerListListener() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse:" + response.toString());
            }

            @Override
            public void onFailure(String errStr) {
                Log.d(TAG, "onFailure:" + errStr);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}
