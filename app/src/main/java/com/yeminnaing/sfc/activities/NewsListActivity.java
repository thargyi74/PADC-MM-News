package com.yeminnaing.sfc.activities;

import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yeminnaing.sfc.R;
import com.yeminnaing.sfc.adapters.NewsAdapter;
import com.yeminnaing.sfc.components.EmptyViewPod;
import com.yeminnaing.sfc.components.SmartRecyclelrView;
import com.yeminnaing.sfc.components.SmartScrollListener;
import com.yeminnaing.sfc.data.vo.NewsVO;
import com.yeminnaing.sfc.delegates.NewsItemDelegate;
import com.yeminnaing.sfc.events.RestApiEvents;
import com.yeminnaing.sfc.network.persistence.NewsContract;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsListActivity extends BaseActivity implements NewsItemDelegate, NavigationView.OnNavigationItemSelectedListener, android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    @BindView(R.id.rv_news)
    SmartRecyclelrView rvNews;

    @BindView(R.id.vp_empty_news)
    EmptyViewPod vpEmptyNews;

    private SmartScrollListener mSmartScrollListener;

    private NewsAdapter mNewsAdapter;

    private static final int NEWS_LIST_LOADER_ID =1001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //drawer_layout.openDrawer(GravityCompat.START);
                Intent intent = LoginRegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });


        rvNews.setmEmptyView(vpEmptyNews);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mNewsAdapter = new NewsAdapter(getApplicationContext(), this);
        rvNews.setAdapter(mNewsAdapter);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Toast.makeText(getApplicationContext(), "end of the death", Toast.LENGTH_SHORT).show();
            }
        });

        getSupportLoaderManager().initLoader(NEWS_LIST_LOADER_ID, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home){
            drawer_layout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabComment() {

    }

    @Override
    public void onTabSendTo() {

    }

    @Override
    public void onTabFavorite() {

    }

    @Override
    public void onTabStatistics() {

    }

    @Override
    public void onTabNews() {

        //Analytic logic in
        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext());
        startActivity(intent);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe (threadMode = ThreadMode.MAIN)
    public void onNewsDataLoaded(RestApiEvents.NewDataLoadedEvent event){

      /*  mNewsAdapter.appendNewData(event.getLoadedNews());*/




    }

    @Subscribe (threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event){

        Snackbar.make(rvNews, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(), NewsContract.NewsEntry.CONTENT_URI, null, null, null, null);


    }

    @Override
    public void onLoadFinished(Loader loader, Cursor data) {

        if(data != null && data.moveToFirst()){

            List<NewsVO>  newsList = new ArrayList<>();

            do{
                NewsVO news = NewsVO.parseFromCursor(data);
                newsList.add(news);
            }while (data.moveToNext());

            mNewsAdapter.setNewData(newsList);
        }

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
