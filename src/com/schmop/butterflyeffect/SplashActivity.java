package com.schmop.butterflyeffect;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends Activity {
	AnimationDrawable rippleAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		final ImageView imgFrame=(ImageView)findViewById(R.id.splashLogo1);
		imgFrame.setBackgroundResource(R.drawable.frame);
		rippleAnimation=(AnimationDrawable) imgFrame.getBackground();
		rippleAnimation.start();
		
		TimerTask task= new TimerTask() {
			@Override
			public void run() {			
				Intent mIntent = new Intent(SplashActivity.this, MainActivity.class);
				mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            	startActivity(mIntent);
				//finish();
			}
		};
		Timer open = new Timer();
		open.schedule(task, 4000);
		
	}
}
