package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class View2 extends Activity {
	
	 ImageButton exit2;
	 ImageButton share2;
	public static String newPath3=null;
	//public static String newPath3="NEWPATH3";
	
	private Bundle extras4 = null;
	
	public static ImageView newImage;
	
	 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.view2);
	     
	        
	        extras4 = getIntent().getExtras();
	        
		       newPath3     = extras4.getString(ImageProcess2.newPath2);
		       
		    
		       Log.d("newP",""+newPath3);
		       
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
		  
		        
		       
		       
		       File imgFile2 = new  File(newPath3);

		       if(imgFile2.exists()){

		           Bitmap myBitmap2 = BitmapFactory.decodeFile(imgFile2.getAbsolutePath());

		           ImageView myImage2 = (ImageView) findViewById(R.id.imageView2);

		           myImage2.setImageBitmap(myBitmap2);

		       }
		       
		       
		       share2=(ImageButton)findViewById(R.id.share2);
		       share2.setOnClickListener(new OnClickListener() {
		        	 @Override
		                public void onClick(View arg0) {
		        		// String captionText = "<< media caption >>";
		        		 
		        		 Intent share = new Intent(Intent.ACTION_SEND);

		        		    // Set the MIME type
		        		    share.setType("image/*");

		        		    // Create the URI from the media
		        		    File media = new File(newPath3);
		        		    Uri uri = Uri.fromFile(media);

		        		    // Add the URI and the caption to the Intent.
		        		    share.putExtra(Intent.EXTRA_STREAM, uri);
		        		  //  share.putExtra(Intent.EXTRA_TEXT, captionText);

		        		    // Broadcast the Intent.
		        		    startActivity(Intent.createChooser(share, "Share to"));   	 }		        }); 
		       
		       
		       
		       //PROGRAMDAN �IKI�
		        exit2= (ImageButton) findViewById(R.id.exit2);
		        exit2.setOnClickListener(new OnClickListener() {
		        	 @Override
		                public void onClick(View arg0) {
		        		finish();
		        		
		        		Intent intent = new Intent(getApplicationContext(), Start.class);
		        		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        		startActivity(intent);
		                }
					
		        });
		  
	  
		       
				
		      
}}