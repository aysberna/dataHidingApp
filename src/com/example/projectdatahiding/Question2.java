package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class Question2 extends Activity{
	 ImageButton uploadFile;
	 ImageButton writeMessage;
	 public static String qPath22=null;
	 public static String qPath32="QPATH32";
	 private Bundle extrasq12 = null;
	 
	 public static String qPathf22=null;
	 public static String qPathf32="QPATH32";
	 private Bundle extrasqf12 = null;
	 
	 
	/* public static String q2Path2=null;
	 public static String q2Path3="Q2PATH3";
	 private Bundle extrasq2 = null;	
	 extrasq2 = getIntent().getExtras();
	      q2Path2     = extrasq2.getString(ChoosePicture.gpath);
		
		 Bundle extras2q = new Bundle();
	      
	     extras2q.putString(q2Path3, q2Path2);
	     
	     Intent intent2 = new Intent();
	     intent2.putExtras(extras2q);
		
		*/
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.question2);
	        
	     
	      //metin gizle
	        writeMessage = (ImageButton) findViewById(R.id.writeMessage);
	        writeMessage.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{
	        		   
	        		   extrasq12 = getIntent().getExtras();
		     		      qPath22     = extrasq12.getString(ChoosePicture.gpath);
		     	        
		        		 Bundle extrasq = new Bundle();
					      
					     extrasq.putString(qPath32, qPath22);
					     
					     Intent intent = new Intent();
					     intent.putExtras(extrasq);

					      intent.setClass(getApplicationContext(), Ascii2.class);
					     startActivity(intent);
	        	}
	        });
	    
	        
	        //dosya gizle
	        uploadFile = (ImageButton) findViewById(R.id.uploadFile);
	        uploadFile.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{      
	        		 extrasqf12 = getIntent().getExtras();
	     		      qPathf22     = extrasqf12.getString(ChoosePicture.gpath);
	     	        
	        		 Bundle extrasq = new Bundle();
				      
				     extrasq.putString(qPathf32, qPathf22);
				     
				     Intent intent = new Intent();
				     intent.putExtras(extrasq);

				      intent.setClass(getApplicationContext(), ChooseFile2.class);
				     startActivity(intent);
	        	}
	        });
	        
	        
	        
	        
	        
	        
	  
	    }

	 }
