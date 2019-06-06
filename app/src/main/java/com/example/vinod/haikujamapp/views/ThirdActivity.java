package com.example.vinod.haikujamapp.views;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vinod.haikujamapp.R;
import com.example.vinod.haikujamapp.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityThirdBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_third);
    binder.tbToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });
  }
}
