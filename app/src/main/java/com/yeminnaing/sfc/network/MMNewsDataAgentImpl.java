package com.yeminnaing.sfc.network;

import android.content.Context;

import com.google.gson.Gson;
import com.yeminnaing.sfc.events.RestApiEvents;
import com.yeminnaing.sfc.network.response.GetNewResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yeminnaing on 12/3/17.
 */

public class MMNewsDataAgentImpl implements MMNewsDataAgent {


    private  static MMNewsDataAgentImpl objInstance;

    private MMNewsAPI theAPI;

    private MMNewsDataAgentImpl(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(MMNewsAPI.class);


    }

    public static MMNewsDataAgentImpl getInstance(){

        if(objInstance == null){
            objInstance = new MMNewsDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadMMNews(String accessToken, int pageNo, final Context context) {


       Call<GetNewResponse> loadMMNewsCall = theAPI.loadMMNews(pageNo, accessToken);
        // theAPI.loadMMNews(pageNo, accessToken); To above
        loadMMNewsCall.enqueue(new Callback<GetNewResponse>() {
            @Override
            public void onResponse(Call<GetNewResponse> call, Response<GetNewResponse> response) {

                GetNewResponse getNewResponse = response.body();
                if(getNewResponse != null
                        && getNewResponse.getNewsList().size() >0){

                    RestApiEvents.NewDataLoadedEvent newsDataLoadedevent = new RestApiEvents.NewDataLoadedEvent(getNewResponse.getPageNo(), getNewResponse.getNewsList(), context);
                    EventBus.getDefault().post(newsDataLoadedevent);
                }else{

                    RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for Now");
                    EventBus.getDefault().post(errorEvent);
                }



            }

            @Override
            public void onFailure(Call<GetNewResponse> call, Throwable t) {

                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);

            }
        });

    }
}
