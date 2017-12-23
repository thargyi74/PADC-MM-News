package com.yeminnaing.sfc.viewholders;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yeminnaing.sfc.R;
import com.yeminnaing.sfc.data.vo.CommentVO;
import com.yeminnaing.sfc.data.vo.NewsVO;
import com.yeminnaing.sfc.data.vo.SentToVO;
import com.yeminnaing.sfc.delegates.NewsItemDelegate;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yeminnaing on 11/4/17.
 */

public class NewsViewHolder extends BaseViewHolder<NewsVO> {



    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.tv_publication_name)
    TextView tvPublicationName;

    @BindView(R.id.tv_published_date)
    TextView tvPublishedDate;

    @BindView(R.id.tv_breif_news)
    TextView tvBreifNews;

    @BindView(R.id.iv_news_hero_image)
    ImageView ivNewsHeroImage;

    /*@BindView(R.id.tv_news_statistical_data)
    TextView tvNewsStatisticalData;*/

    @BindView(R.id.tv_likes)
    TextView tvLikes;

    @BindView(R.id.tv_comments)
    TextView tvComments;

    @BindView(R.id.tv_sent_to)
    TextView tvSentTo;


    public NewsItemDelegate mDelegate;

    private NewsVO mItem;



    public NewsViewHolder(View itemView, NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void setData(NewsVO data) {

        mItem = data;

       /* tvPublicationName.setText(data.getPublication().getTitle());
        tvBreifNews.setText(data.getBreif());
        tvPublishedDate.setText(data.getPostedDate());
        Glide.with(ivPublicationLogo.getContext())
                .load(data.getPublication().getLogo())
                .into(ivPublicationLogo);


        List<String>  images = data.getImages();
        if(images != null){

            Glide.with(ivNewsHeroImage.getContext())
                    .load(data.getImages().get(0))
                    .into(ivNewsHeroImage);
        }else {
            ivNewsHeroImage.setVisibility(View.GONE);
        }


        tvLikes.setText(Html.fromHtml(tvLikes.getContext().getString(R.string.likes, data.getFavoriteAction().size())));

        List<CommentVO> comments = data.getCommentList();
        if(comments != null){
            tvComments.setText(Html.fromHtml(tvComments.getContext().getString(R.string.comments, data.getCommentList().size())));
        }else {
            tvComments.setText(Html.fromHtml(tvComments.getContext().getString(R.string.comments, 0)));
        }

        List<SentToVO> sentTo = data.getSentToList();
        if(sentTo != null) {
            tvSentTo.setText(Html.fromHtml(tvSentTo.getContext().getString(R.string.sent_to, data.getSentToList().size())));
        }else {

            tvSentTo.setText(Html.fromHtml(tvSentTo.getContext().getString(R.string.sent_to, 0)));
        }*/

        if (data != null) {
            if (data.getBreif()!=null){
                tvBreifNews.setText(data.getBreif());
            }
            if (data.getImages() != null) {
                Glide.with(itemView.getContext()).load(data.getImages().get(0)).into(ivNewsHeroImage);
            }
            if (data.getPostedDate()!=null){
                tvPublishedDate.setText(data.getPostedDate());
            }
            if (data.getPublication()!=null){
                Glide.with(itemView.getContext()).load(data.getPublication().getLogo()).into(ivPublicationLogo);
            }
        }






    }

    @Override
    public void onClick(View view) {

        //mDelegate.onTabNews();



    }
}
