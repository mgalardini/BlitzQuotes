package com.blitz.quotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BlitzQuotesActivity extends Activity {
	private int start = 1;
	
	private RandomQuote rquoter = new RandomQuote();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Set the first quote
        if (start == 1) {
        	setRandomQuote();
        	start = 0;
        	}
        	
	    final Button refresh = (Button) findViewById(R.id.Refresh);
	    refresh.setOnClickListener(new OnClickListener(){
	        public void onClick(View v) {
	            // Perform action on clicks
	        	setRandomQuote();
	        	}
	    	});
	    
	    final Button blitz = (Button) findViewById(R.id.Blitz);
	    blitz.setOnClickListener(new OnClickListener(){
	        public void onClick(View v) {
	            // Perform action on clicks
	        	String url = "http://www.blitzphoto.org";
	        	Intent i = new Intent(Intent.ACTION_VIEW);
	        	i.setData(Uri.parse(url));
	        	startActivity(i);
	        	}
	    	});
	    };
	    
	    private void setRandomQuote(){
	    	Context context = getBaseContext();
	    	int resource = rquoter.getRandomQuote(context);
	    	TextView tv = (TextView) findViewById(R.id.Quote);
	    	tv.setText(resource);
	    };
    
}