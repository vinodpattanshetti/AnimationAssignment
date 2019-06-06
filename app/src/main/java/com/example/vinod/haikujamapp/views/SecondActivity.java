package com.example.vinod.haikujamapp.views;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vinod.haikujamapp.R;
import com.example.vinod.haikujamapp.databinding.ActivitySecondBinding;

import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

  private ActivitySecondBinding mBinder;
  private int count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinder = DataBindingUtil.setContentView(this, R.layout.activity_second);
    mBinder.tbToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });
    List<String> list = Arrays.asList("One person sets a topic & writes the first line",
            "One person sets a topic & writes the first line",
            "Others will add to it & that's how you JAM!");
    IntroViewPagerAdapter mPager = new IntroViewPagerAdapter(this, list);
    mBinder.screenViewpager.setAdapter(mPager);
    mBinder.ivImageOne.bringToFront();
    mBinder.ivImageTwo.bringToFront();
    mBinder.ivImageThree.bringToFront();

    ObjectAnimator animator = ObjectAnimator.ofFloat(mBinder.ivImageOne, "translationY", -450f);
    animator.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        mBinder.ivImageOne.setVisibility(View.VISIBLE);
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animator.start();

    ObjectAnimator animator1 = ObjectAnimator.ofFloat(mBinder.ivImageTwo, "translationX", 400f);
    animator1.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        mBinder.ivImageTwo.setVisibility(View.VISIBLE);
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animator1.start();

    ObjectAnimator animation2 = ObjectAnimator.ofFloat(mBinder.ivImageThree, "translationX", -420f);
    animation2.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        mBinder.ivImageThree.setVisibility(View.VISIBLE);
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animation2.start();
    mBinder.llImageIndicator.createPageIndicator(4, 0, 0);
    mBinder.btNext.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (0 == count) {
          count++;
          mBinder.llImageIndicator.handleViewPagerScroll(4, count, 0, 0);
          mBinder.screenViewpager.setCurrentItem(count);
          animateLeftView();
        } else if (1 == count) {
          count++;
          mBinder.llImageIndicator.handleViewPagerScroll(4, count, 0, 0);
          mBinder.screenViewpager.setCurrentItem(count);
          animateTopView();
        } else if (2 == count) {
          count++;
          mBinder.llImageIndicator.handleViewPagerScroll(4, count, 0, 0);
          mBinder.screenViewpager.setCurrentItem(count);
          animateRightView();
        } else if(3 == count) {
          startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
        }
      }
    });
  }

  private void animateLeftView() {
    ObjectAnimator animator = ObjectAnimator.ofFloat(mBinder.ivImageOne, "translationY", 0f);
    animator.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        mBinder.ivImageOne.setVisibility(View.GONE);
        mBinder.view1
            .setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.color_red));
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animator.start();
  }

  private void animateTopView() {
    ObjectAnimator animator1 = ObjectAnimator.ofFloat(mBinder.ivImageTwo, "translationX", 0f);
    animator1.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        mBinder.ivImageTwo.setVisibility(View.GONE);
        mBinder.view2
            .setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.color_orange));
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animator1.start();
  }

  private void animateRightView() {
    ObjectAnimator animation2 = ObjectAnimator.ofFloat(mBinder.ivImageThree, "translationX", 0f);
    animation2.addListener(new Animator.AnimatorListener() {
      @Override
      public void onAnimationStart(Animator animator) {

      }

      @Override
      public void onAnimationEnd(Animator animator) {
        mBinder.ivImageThree.setVisibility(View.GONE);
        mBinder.view3.setBackgroundColor(
            ContextCompat.getColor(SecondActivity.this, R.color.color_light_orange));
      }

      @Override
      public void onAnimationCancel(Animator animator) {

      }

      @Override
      public void onAnimationRepeat(Animator animator) {

      }
    });
    animation2.start();
  }
}
