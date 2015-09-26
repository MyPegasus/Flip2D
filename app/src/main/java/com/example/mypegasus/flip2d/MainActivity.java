package com.example.mypegasus.flip2d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private ImageView imageA, imageB;

	private ScaleAnimation scale0 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
	private ScaleAnimation scale1 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		findViewById(R.id.root).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (imageA.getVisibility() == View.VISIBLE) {
					imageA.startAnimation(scale0);
				} else {
					imageB.startAnimation(scale0);
				}
			}
		});

	}

	private void initView() {
		imageA = (ImageView) findViewById(R.id.ivA);
		imageB = (ImageView) findViewById(R.id.ivB);

		showImageA();
		scale0.setDuration(500);
		scale1.setDuration(500);

		scale0.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				if(imageA.getVisibility() == View.VISIBLE) {
					imageA.setAnimation(null);
					showImageB();
					imageB.startAnimation(scale1);
				} else {
					imageB.setAnimation(null);
					showImageA();
					imageA.startAnimation(scale1);
				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});
	}

	private void showImageA() {
		imageA.setVisibility(View.VISIBLE);
		imageB.setVisibility(View.INVISIBLE);
	}

	private void showImageB() {
		imageA.setVisibility(View.INVISIBLE);
		imageB.setVisibility(View.VISIBLE);
	}


}
