package com.yeminnaing.sfc.network;

import android.content.Context;

/**
 * Created by yeminnaing on 12/3/17.
 */

public interface MMNewsDataAgent {

    void loadMMNews(String accessToken, int pageNo, Context context);

}
