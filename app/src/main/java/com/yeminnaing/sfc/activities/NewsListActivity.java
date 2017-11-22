package com.yeminnaing.sfc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.yeminnaing.sfc.R;
import com.yeminnaing.sfc.adapters.NewsAdapter;
import com.yeminnaing.sfc.delegates.NewsItemDelegate;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsListActivity extends AppCompatActivity implements NewsItemDelegate{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                drawer_layout.openDrawer(GravityCompat.START);
            }
        });



        RecyclerView rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        NewsAdapter newsAdapter = new NewsAdapter(getApplicationContext(), this);
        rvNews.setAdapter(newsAdapter);
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
}
