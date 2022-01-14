package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class View1 extends Activity {
	
	 ImageButton exit1;
	 ImageButton share1;
	public static String newPath2=null;
	//public static String newPath3="NEWPATH3";
	
	private Bundle extras3 = null;
	
	public static ImageView newImage;
	
	 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.view);
	     
	        
	        extras3 = getIntent().getExtras();
	        
		       newPath2     = extras3.getString(ImageProcess.newPath);
		       
		    
		       Log.d("newP",""+newPath2);
		       
		     /*  try {
				    
				      Bundle extras = new Bundle();
				      extras.putString(newPath3, newPath2);
				      
				      Log.d("newP",""+newPath3);
				      Intent intent = new Intent();
				 
				
				      intent.putExtras(extras);
				 
				  
				     
				    } catch (Exception e) {
				      e.printStackTrace();
				    }
			      
		       */
		  
		        
		       
		       
		       File imgFile = new  File(newPath2);

		       if(imgFile.exists()){

		           Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

		           ImageView myImage = (ImageView) findViewById(R.id.imageView1);

		           myImage.setImageBitmap(myBitmap);

		       }
		       ;
		       share1=(ImageButton)findViewById(R.id.share1);
		       share1.setOnClickListener(new OnClickListener() {
		        	 @Override
		                public void onClick(View arg0) {
		        		// String captionText = "<< media caption >>";
		        		 
		        		 Intent share = new Intent(Intent.ACTION_SEND);

		        		    // Set the MIME type
		        		    share.setType("image/*");

		        		    // Create the URI from the media
		        		    File media = new File(newPath2);
		        		    Uri uri = Uri.fromFile(media);

		        		    // Add the URI and the caption to the Intent.
		        		    share.putExtra(Intent.EXTRA_STREAM, uri);
		        		  //  share.putExtra(Intent.EXTRA_TEXT, captionText);

		        		    // Broadcast the Intent.
		        		    startActivity(Intent.createChooser(share, "Share to"));   	 }		        }); 
		       
		       
		       
		       
		       //PROGRAMDAN �IKI�
		        exit1= (ImageButton) findViewById(R.id.exit1);
		        exit1.setOnClickListener(new OnClickListener() {
		        	 @Override
		                public void onClick(View arg0) {
		        		finish();
		        		
		        		Intent intent = new Intent(getApplicationContext(), Start.class);
		        		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        		startActivity(intent);
		                }
					
		        });
		  
	  
		       
				
		      
}}