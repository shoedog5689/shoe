package doctor.fresh.com.freshdoctor.presenter;

import org.json.JSONObject;

/**
 * Created by wei.he on 17/4/20.
 */

public interface OnBannerListListener {
    public void onResponse(JSONObject response);
    public void onFailure(String errStr);
}
