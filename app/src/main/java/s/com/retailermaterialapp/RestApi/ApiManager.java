package s.com.retailermaterialapp.RestApi;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private Context mContext;
    private ProgressDialog dialog;
    private ApiResponseInterface mApiResponseInterface;

    public ApiManager(Context context, ApiResponseInterface apiResponseInterface) {
        this.mContext = context;
        this.mApiResponseInterface = apiResponseInterface;
        dialog = new ProgressDialog(mContext);
    }


    public void makeLoginRequest(Map<String, Object> params, final int requestCode) {
        showDialog("Login user...");
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<BaseResponse<String>> call = apiService.doRegister(params);
        call.enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                closeDialog();
//                if (response.body().getACK().equalsIgnoreCase("success")) {
//                    mApiResponseInterface.isSuccess(response.body(), AppConstant.LOGIN_REQUEST);
//                } else {
//
//                    mApiResponseInterface.isError(response.body().getMessage());
//                }

                if (response.body().getData() != null && response.body().getStatus().equalsIgnoreCase("1")) {
                    mApiResponseInterface.isSuccess(response.body(), requestCode);
                } else if (response.body().getStatus().equalsIgnoreCase("2")) {
                    mApiResponseInterface.isUserDisabled(response.body().getMsg(), AppConstant.USER_DISABLED);
                } else {
                    mApiResponseInterface.isError(response.body().getMsg(), AppConstant.ERROR_CODE);
                }

            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                closeDialog();
                Log.e("error", t.getMessage());
                mApiResponseInterface.isError("Network Error", AppConstant.NO_NETWORK_ERROR_CODE);
                Toast.makeText(mContext, "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * The purpose of this method is to show the dialog
     *
     * @param message
     */
    private void showDialog(String message) {
        dialog.setMessage(message);
        dialog.show();
    }

    /**
     * The purpose of this method is to close the dialog
     */
    private void closeDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
