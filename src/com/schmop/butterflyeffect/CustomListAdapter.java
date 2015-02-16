package com.schmop.butterflyeffect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class CustomListAdapter extends ParseQueryAdapter<ParseObject> {
	
	public CustomListAdapter(Context context) {
		super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
			public ParseQuery create() {
				ParseQuery query = new ParseQuery("Deed"); //Deed key, calls upon ParseObj key-value pair
				return query;
			}
			
		});
	}
	
	// overriding getItemView, overrides .xml layout, interfaces with ParseObject through object class k/v pairs
		@Override
		public View getItemView(ParseObject object, View v, ViewGroup parent) {
			if (v == null) {
				v = View.inflate(getContext(), R.layout.blylistitem, null);
			}

			super.getItemView(object, v, parent);

			// Add and download the image
			/**ParseImageView todoImage = (ParseImageView) v.findViewById(R.id.icon);
			ParseFile imageFile = object.getParseFile("image");
			if (imageFile != null) {
				todoImage.setParseFile(imageFile);
				todoImage.loadInBackground();
			}**/

			// Add the title view
			TextView txtTitle = (TextView) v.findViewById(R.id.deedTitle);
			txtTitle.setText(object.getString("title"));
			// Add the duration of the deed
			TextView txtDuration = (TextView) v.findViewById(R.id.deedDurat);
			txtDuration.setText(object.getString("Length") + " min");
			// Add a reminder of how long this item has been outstanding
			TextView timestampView = (TextView) v.findViewById(R.id.deedTime);
			timestampView.setText(object.getCreatedAt().toString());
			return v;
			
		}

}
