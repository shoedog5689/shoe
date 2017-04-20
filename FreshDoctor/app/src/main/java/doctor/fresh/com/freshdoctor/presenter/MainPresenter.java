package doctor.fresh.com.freshdoctor.presenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import doctor.fresh.com.freshdoctor.common.Utils;
import doctor.fresh.com.freshdoctor.model.IMainModel;
import doctor.fresh.com.freshdoctor.model.MainModel;
import doctor.fresh.com.freshdoctor.view.IMainView;
import doctor.fresh.com.freshdoctor.view.MainFragment;

/**
 * Created by hewei on 2017/4/14.
 */

public class MainPresenter {

    private IMainView mainView;
    private IMainModel mainModel;
    private JSONArray bannerListJsonArr;

    public MainPresenter() {
        mainModel = new MainModel();
        mainView = new MainFragment();
    }

    public JSONArray getMainBannerList() {
        if (mainModel != null && mainView != null) {
            mainModel.getMainBannerList(new OnBannerListListener() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        bannerListJsonArr = response.getJSONArray("object");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Utils.showLongToast(((MainFragment) mainView).getActivity(), e.toString());
                    }
                }

                @Override
                public void onFailure(String errStr) {
                    Utils.showLongToast(((MainFragment) mainView).getActivity(), errStr);
                }
            });
        }
        return bannerListJsonArr;
    }

}
