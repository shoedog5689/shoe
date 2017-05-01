package doctor.fresh.com.freshdoctor.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import doctor.fresh.com.freshdoctor.BaseFragment;
import doctor.fresh.com.freshdoctor.R;

import doctor.fresh.com.freshdoctor.presenter.IMainPresenter;

/**
 * Created by hewei on 2017/4/17.
 */

public class MainFragment extends BaseFragment implements IMainView {

    private static final String TAG = MainFragment.class.getSimpleName();

    private TextView textView;
    private ViewPager viewPager;
    private IMainPresenter mainPresenter;

    public static MainFragment newInstance() {
        Log.d(TAG, "newInstance()");
        return new MainFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Log.d(TAG, "initView()");
        viewPager = (ViewPager) view.findViewById(R.id.main_viewpager);
        mainPresenter.getImageViewList(new OnGetImageViewList() {
            @Override
            public void onComplete(List<ImageView> lst) {
                BannerViewPager bannerViewPager = new BannerViewPager(lst);
                viewPager.setAdapter(bannerViewPager);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    @Override
    public void setPresenter(IMainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public IMainPresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    public Activity getViewActivity() {
        return getHoldingActivity();
    }
}
