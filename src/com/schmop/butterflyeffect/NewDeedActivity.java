package com.schmop.butterflyeffect;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewDeedActivity extends Activity {

	int temp = 0;
	SharedPreferences SharedPref = PreferenceManager.getDefaultSharedPreferences(this); //make a SP called SPRef
	
	private void updatePostCount() {
		if (temp == 0) {
			temp = SharedPref.getInt("dailyPC", temp); //make int value temp	
		} else {
			temp++;
			SharedPreferences.Editor edit = SharedPref.edit(); //make an editor called edit
			edit.putInt("dailyPC", temp); //store temp in dailyPC
			edit.commit(); //save changes
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_deed);
		
		final EditText deedText =(EditText)findViewById(R.id.txtDeed);
		final EditText deedDuration =(EditText)findViewById(R.id.deedDuration);
        final Button btnSubmit =(Button)findViewById(R.id.btnSubmit);
        
        //init ParseObject through Deed class
        //final Deed mDeed = new Deed();
      
        btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ParseObject deed = new ParseObject("Deed");
				deed.put("title", deedText.getText().toString());
				deed.put("Length", deedDuration.getText().toString());
				
				//deed.put("key", value);
				deed.saveInBackground(new SaveCallback() {
					@Override //Anonymous inner class
					public void done(ParseException e) {
						// TODO Auto-generated method stub
						if (e == null) {
							//Store post count on device
							if(temp == 0)
							updatePostCount();
							//success toast
							Log.v("Butterfly Effect", "Post Success");
							Toast.makeText(NewDeedActivity.this, "Post Success", Toast.LENGTH_SHORT).show();
							//close activity
							finish();
							
						} else {
							//failure toast
							Log.e("Butterfly Effect", "Post Failure");
							Toast.makeText(NewDeedActivity.this, "Post Failure", Toast.LENGTH_SHORT).show();
							//store ParseObject locally
							//save eventually
						}
					}
				});
							
			}
			
		});
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_deed, menu);
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
