package com.example.vinod.haikujamapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.vinod.haikujamapp.R;

public class PageIndicator extends LinearLayout {
  private ImageView[] imageIndications;

  public PageIndicator(Context context) {
    super(context);
  }

  public PageIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  /**
   * method to create the pageIndicator
   */
  public void createPageIndicator(int pageCount, int focusedPageDrawable,
      int unFocusedPageDrawable) {
    imageIndications = new ImageView[pageCount];
    ImageView indicatorImageView;
    for (int i = 0; i < pageCount; i++) {
      indicatorImageView = new ImageView(getContext());
      int size = getDensityPixelValue(getContext());
      final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
      params.setMargins(4, 0, 4, 0);
      indicatorImageView.setLayoutParams(params);
      // method to change the page icon
      changePageIcon(i, 0, indicatorImageView, focusedPageDrawable, unFocusedPageDrawable);
      imageIndications[i] = indicatorImageView;
      this.addView(indicatorImageView);
    }
  }

  private int getDensityPixelValue(Context context) {
    float density = context.getResources().getDisplayMetrics().density;
    return (int) (8 * density);
  }

  /**
   * method to handle the PageChangeListener for ViewPager
   *
   * @param size the total number of images available for product
   * @param position the current position of ViewPager
   * @param focusedPageDrawable
   * @param unFocusedPageDrawable
   */
  public void handleViewPagerScroll(int size, int position, int focusedPageDrawable,
      int unFocusedPageDrawable) {
    for (int i = 0; i < size && i < imageIndications.length; i++) {
      changePageIcon(position, i, imageIndications[i], focusedPageDrawable, unFocusedPageDrawable);
    }
  }

  /**
   * method to change the page icon
   *
   * @param position
   * @param indicatorImageView
   * @param focusedPageDrawable
   * @param unFocusedPageDrawable
   */
  private void changePageIcon(int position, int pageIndex, ImageView indicatorImageView,
      int focusedPageDrawable, int unFocusedPageDrawable) {
    if (pageIndex == position) {
      if (focusedPageDrawable != 0) {
        indicatorImageView.setImageResource(focusedPageDrawable);
      } else {
        indicatorImageView.setImageResource(R.drawable.rounded_style_blue);
      }
    } else {
      if (unFocusedPageDrawable != 0) {
        indicatorImageView.setImageResource(unFocusedPageDrawable);
      } else {
        indicatorImageView.setImageResource(R.drawable.rounded_style2);
      }
    }
  }
}
