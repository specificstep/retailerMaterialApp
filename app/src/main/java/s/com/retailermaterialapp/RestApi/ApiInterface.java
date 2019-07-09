package s.com.retailermaterialapp.RestApi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("skipotp")
    @FormUrlEncoded
    Call<BaseResponse<String>> doRegister(@FieldMap Map<String, Object> params);
}
