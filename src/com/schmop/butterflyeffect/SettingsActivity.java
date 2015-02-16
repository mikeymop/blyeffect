package com.schmop.butterflyeffect;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends Activity {
	int level;
	
	private int getPC() {
		SharedPreferences SharedPref = PreferenceManager.getDefaultSharedPreferences(this); //make a SP called SPRef
		level = SharedPref.getInt("dailyPC", level); //make int value temp
		return level;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		final Button btnTest = (Button)findViewById(R.id.btnTest);
		final TextView lvltxt = (TextView)findViewById(R.id.txtlevel);
		
		getPC();
		
		switch(level) {
			case 10:
				lvltxt.setText("You are a Bronze Samaratan");
			case 20:
				lvltxt.setText("You are a Silver Samaratan");
			case 40:
				lvltxt.setText("Congrats! You are a Gold Samaratan");
		}
		
		btnTest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
