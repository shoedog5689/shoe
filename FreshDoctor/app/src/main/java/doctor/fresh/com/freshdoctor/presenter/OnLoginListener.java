package doctor.fresh.com.freshdoctor.presenter;

import org.json.JSONObject;

/**
 * Created by hewei on 2017/5/1.
 */

public interface OnLoginListener {
    public void onResponse(JSONObject response);
    public void onFailure(String errStr);
}
