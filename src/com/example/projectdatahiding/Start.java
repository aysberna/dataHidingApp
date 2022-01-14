package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class Start extends Activity{
	 ImageButton captureCamera;
	 ImageButton choosePicture;
	 ImageButton openPicture;
	 ImageButton exit;
		
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.start);
	 //CIHAZ KAMERASINA ERISIM
	        captureCamera = (ImageButton) findViewById(R.id.captureCamera);
	        captureCamera.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{
	        	startActivity(new Intent(Start.this, Camera.class));
	        	}
	        });
	  //FOTOGRAF SECME
	        choosePicture = (ImageButton) findViewById(R.id.choosePicture);
	        choosePicture.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{
	        	startActivity(new Intent(Start.this, ChoosePicture.class));
	        	}
	        });
	        //OPEN
	       openPicture = (ImageButton) findViewById(R.id.openPicture);
	       openPicture.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{
	        	startActivity(new Intent(Start.this, Open.class));
	        	}
	        });

	        
	        
	      
	  //PROGRAMDAN ÇIKIÞ
	        exit = (ImageButton) findViewById(R.id.exit);
	        exit.setOnClickListener(new OnClickListener() {
	        	@Override
	        	public void onClick(View v)
	        	{
	        	finish();
	        	}
	        });
	    }


}
