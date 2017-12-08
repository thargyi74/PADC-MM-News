package com.yeminnaing.sfc.network;

import com.yeminnaing.sfc.network.response.GetNewResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by yeminnaing on 12/3/17.
 */

public interface MMNewsAPI {

    @FormUrlEncoded
    @POST("v1/getMMNews.php")
    Call<GetNewResponse> loadMMNews(@Field("page") int pageIndex,
                                    @Field("access_token") String accessToken);


}
