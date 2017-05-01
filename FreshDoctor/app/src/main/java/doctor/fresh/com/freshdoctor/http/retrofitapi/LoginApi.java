package doctor.fresh.com.freshdoctor.http.retrofitapi;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hewei on 2017/5/1.
 */

public class LoginApi {

    /**
     获取main界面的数据
     */
    public interface doLogin {

        @GET("")
        Call<JSONObject> getCall();
    }
}
