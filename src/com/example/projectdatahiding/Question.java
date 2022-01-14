package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class Question extends Activity{
	 ImageButton uploadFile;
	 ImageButton writeMessage;
	 public static String qPath2=null;
	 public static String qPath3="QPATH3";
	 private Bundle extrasq1 = null;
	 
	 public static String qPathf2=null;
	 public static String qPathf3="QPATH3";
	 private Bundle extrasqf1 = null;
	 
	 
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
	        setContentView(R.layout.question);
	        
	     
	      //metin gizle
	        writeMessage = (ImageButton) findViewById(R.id.writeMessage);
	        writeMessage.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{
	        		   
	        		   extrasq1 = getIntent().getExtras();
		     		      qPath2     = extrasq1.getString(Camera.path);
		     	        
		        		 Bundle extrasq = new Bundle();
					      
					     extrasq.putString(qPath3, qPath2);
					     
					     Intent intent = new Intent();
					     intent.putExtras(extrasq);

					      intent.setClass(getApplicationContext(), Ascii.class);
					     startActivity(intent);
	        	}
	        });
	    
	        
	        //dosya gizle
	        uploadFile = (ImageButton) findViewById(R.id.uploadFile);
	        uploadFile.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{      
	        		 extrasqf1 = getIntent().getExtras();
	     		      qPathf2     = extrasqf1.getString(Camera.path);
	     	        
	        		 Bundle extrasq = new Bundle();
				      
				     extrasq.putString(qPathf3, qPathf2);
				     
				     Intent intent = new Intent();
				     intent.putExtras(extrasq);

				      intent.setClass(getApplicationContext(), ChooseFile.class);
				     startActivity(intent);
	        	}
	        });
	        
	        
	        
	        
	        
	        
	  
	    }

	 }
