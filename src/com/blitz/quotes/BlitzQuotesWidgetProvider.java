package com.blitz.quotes;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class BlitzQuotesWidgetProvider extends AppWidgetProvider {
	private RandomQuote rquoter = new RandomQuote();
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		//setRandomQuote(context);
		final int N = appWidgetIds.length;

    	int resource = rquoter.getRandomQuote(context);
    	for (int i = 0; i < N; i++) {
		    int appWidgetId = appWidgetIds[i];

	    	RemoteViews remoteView = new RemoteViews(context.getPackageName(),
	                R.layout.widget);
	        remoteView.setTextViewText(R.id.textView1, context.getResources().getText(resource));
	        appWidgetManager.updateAppWidget(appWidgetId, remoteView);
    	};
	};
}
