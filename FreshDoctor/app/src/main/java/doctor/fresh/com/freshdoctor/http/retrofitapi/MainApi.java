package doctor.fresh.com.freshdoctor.http.retrofitapi;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wei.he on 17/4/19.
 */

public class MainApi {

    /**
       获取main界面的数据
     */
    public interface ApiService {

        @GET("banner/list")
        Call<JSONObject> getCall();
    }
}
