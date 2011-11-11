package com.blitz.quotes;

import java.util.Random;

import android.content.Context;

public class RandomQuote {
	private int oald;
	
	RandomQuote() {
		oald = 0;
	}
	
	private int getRandInt(int max){
    	Random mRand = new Random();
        int x = mRand.nextInt(max);
        return x;
    };
    
    public int getRandomQuote(Context context){
    	int quoteID;
    	while(true)	{
    		quoteID = getRandInt(9);
    		if(quoteID != oald){
    			oald = quoteID;
    			break;
    		}
    	}
    	String name = "Q" + quoteID;
    	int resource = context.getResources().getIdentifier(name,
    									"string",context.getPackageName());
    	return resource;
    };

}
