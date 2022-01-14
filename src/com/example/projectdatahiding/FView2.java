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

public class FView2 extends Activity {
	
	 ImageButton fexit1;
	 ImageButton fshare1;
	public static String fnewPath22=null;
	//public static String newPath3="NEWPATH3";
	
	private Bundle extrasf32 = null;
	
	public static ImageView fnewImage2;
	
	 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.fview2);
	     
	        
	        extrasf32 = getIntent().getExtras();
	        
		       fnewPath22     = extrasf32.getString(FImageProcess2.fnewPath2);
		       
		    
		       Log.d("newP",""+fnewPath22);
		       
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
		  
		        
		       
		       
		       File fimgFile = new  File(fnewPath22);

		       if(fimgFile.exists()){

		           Bitmap fmyBitmap = BitmapFactory.decodeFile(fimgFile.getAbsolutePath());

		           ImageView fmyImage = (ImageView) findViewById(R.id.fimageView1);

		           fmyImage.setImageBitmap(fmyBitmap);

		       }
		       ;
		       fshare1=(ImageButton)findViewById(R.id.fshare1);
		       fshare1.setOnClickListener(new OnClickListener() {
		        	 @Override
		                public void onClick(View arg0) {
		        		// String captionText = "<< media caption >>";
		        		 
		        		 Intent share = new Intent(Intent.ACTION_SEND);

		        		    // Set the MIME type
		        		    share.setType("image/*");

		        		    // Create the URI from the media
		        		    File media = new File(fnewPath22);
		        		    Uri uri = Uri.fromFile(media);

		        		    // Add the URI and the caption to the Intent.
		        		    share.putExtra(Intent.EXTRA_STREAM, uri);
		        		  //  share.putExtra(Intent.EXTRA_TEXT, captionText);

		        		    // Broadcast the Intent.
		        		    startActivity(Intent.createChooser(share, "Share to"));   	 }		        }); 
		       
		       
		       
		       
		       //PROGRAMDAN �IKI�
		        fexit1= (ImageButton) findViewById(R.id.fexit1);
		        fexit1.setOnClickListener(new OnClickListener() {
		        	 @Override
		                public void onClick(View arg0) {
		        		finish();
		        		
		        		Intent intent = new Intent(getApplicationContext(), Start.class);
		        		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        		startActivity(intent);
		                }
					
		        });
		  
	  
		       
				
		      
}}