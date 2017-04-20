package doctor.fresh.com.freshdoctor.model;

import android.app.Activity;

import doctor.fresh.com.freshdoctor.presenter.OnBannerListListener;

/**
 * Created by wei.he on 17/4/20.
 */

public interface IMainModel {

    public void getMainBannerList(OnBannerListListener onBannerListListener);
}
