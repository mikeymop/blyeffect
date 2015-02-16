package com.schmop.butterflyeffect;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends Activity {

	private ParseQueryAdapter<ParseObject> mainAdapter;
	private CustomListAdapter mCustomListAdapter;
	private ListView mlistView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Parse.initialize(this, "jKkPfZgJibzJQTKyZI5x5aQEi1YMGOFaTaDVMvPf", "ygfKA30nsW6cZELw51KsbxUsfTKzFQG5raF5rDeo");
        
        
        //thank you https://github.com/ParsePlatform/ParseQueryAdapterTutorial
    	// Set up the Parse query to use in the adapter
        // Initialize main ParseQueryAdapter
     		//mainAdapter = new ParseQueryAdapter<ParseObject>(this, "Deed");
     		//mainAdapter.setTextKey("title");
     	//Init Custom List Adapter	
     		mCustomListAdapter = new CustomListAdapter(this);
     		
     	// Initialize ListView and set initial view to mainAdapter
    		mlistView = (ListView) findViewById(R.id.list);
    		mlistView.setAdapter(mCustomListAdapter);
    		//mlistView.setAdapter(mainAdapter);
    		//mlistView.setAdapter(mCustomListAdapter);
    		//mainAdapter.loadObjects();
        
        
        /**
 		ParseQueryAdapter.QueryFactory<Todo> factory = new ParseQueryAdapter.QueryFactory<Todo>() {
 			public ParseQuery<Todo> create() {
 				ParseQuery<Todo> query = Todo.getQuery();
 				query.orderByDescending("createdAt");
 				query.fromLocalDatastore();
 				return query;
 			}
 		};
        **/
        
  
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	// Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_newPost:
            	//open newPostActivity
            	Intent postIntent = new Intent(this, NewDeedActivity.class);
            	startActivity(postIntent);
                return true;
            case R.id.action_refresh:
            	//refresh listview
            	mCustomListAdapter.notifyDataSetChanged(); //refreshes query object
            	mlistView.setAdapter(mCustomListAdapter); //applies new listadapter to MainActivity
            	Toast.makeText(this, "Refreshed", Toast.LENGTH_SHORT).show();
            	return true;
            case R.id.action_settings:
                //openSettings
            	//Context context = getApplicationContext();
            	Intent settingsIntent = new Intent(this, SettingsActivity.class);
            	startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
    	
/**        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
        **/
        }
    }
}
