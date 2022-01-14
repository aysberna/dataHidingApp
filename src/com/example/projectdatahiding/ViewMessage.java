package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewMessage extends Activity {
	
	
	public static String newPathM2=null;
	//public static String newPath3="NEWPATH3";
	

	private Bundle extrass2 = null;//mesaj
	public static ImageView newImageM;
	public static String secretMessage=null;
	private TextView mesajiniz;
	
	 ImageButton exit;

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.viewmessage);
	        
	        mesajiniz=(TextView)findViewById(R.id.textView2);
	        
	      //  mesajiniz.setText("mesajiniz: "+message+"\n");
	        
	        extrass2 = getIntent().getExtras();
	        secretMessage=extrass2.getString(OpenMessage.secret);
	        
	        mesajiniz.setText(""+secretMessage);
	        
	        
	        //PROGRAMDAN �IKI�
	        exit= (ImageButton) findViewById(R.id.button1);
	        exit.setOnClickListener(new OnClickListener() {
	        	 @Override
	                public void onClick(View arg0) {
	        		finish();
	        		
	        		Intent intent = new Intent(getApplicationContext(), Start.class);
	        		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        		startActivity(intent);
	                }
				
	        });
	  
	        
	     /*
	        
	        extras3 = getIntent().getExtras();
	        
		       newPathM2     = extras3.getString(OpenMessage.newPathM);
		       
		    
		       Log.d("newPM",""+newPathM2);
		       
      
		       
		       File imgFile = new  File(newPathM2);

		       if(imgFile.exists()){

		           Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

		           ImageView myImage = (ImageView) findViewById(R.id.imageView2);

		           myImage.setImageBitmap(myBitmap);

		       }
		     */  
	        
}}