package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;


public class ImageProcess extends Activity {



	public static String imagePath=null;
	public static String imageMesaj=null;
	private Bundle extrasa2 = null;

	
	public static String newPath="NEWIMAGEPATH";

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageprocess);
        
        extrasa2 = getIntent().getExtras();
        imagePath=extrasa2.getString(Ascii.asciiPath3);
        imageMesaj=extrasa2.getString(Ascii.mesaj);
       	   
      //  extras3 = getIntent().getExtras();
  
        Log.d("image", ""+ imagePath);
        //Log.d("bundle",""+newMessage[2]);
        
        Log.d("image", ""+ imageMesaj);
        
    
      
        int p;
    
        	BitmapFactory.Options opt= new BitmapFactory.Options();
            opt.inPreferredConfig=Bitmap.Config.ARGB_8888;
                   
    
                  Bitmap image2=BitmapFactory.decodeFile(imagePath,opt);
                  Bitmap image=image2.copy(Bitmap.Config.ARGB_8888,true);
   
              String imza="tou";
              String m=imageMesaj.toString();
              
              String gizle= new StringBuilder()
              .append(imza)
              .append(m)
              .toString();

              for(int i=0; i<image.getWidth(); i++){

             	for(int j=0; j<image.getHeight(); j++){

         	p= image.getPixel(i,j);

             	if (i < 1 && j < gizle.length())

                      {
             	Log.d("renk", ""+Color.red(p));
             	Log.d("renk", ""+Color.green(p));
             	Log.d("renk", ""+Color.blue(p));

             	char letter= gizle.charAt(j);

             	int value= (int) letter;

             	Log.d("imzaascii",""+letter);
             	Log.d("imzaascii",""+value);
             	
             	int a;
            	a= Color.blue(p);     	 
             	a=value;
            	 
            	Log.d("imzaascii",""+value);
            	
             	image.setPixel(i, j, Color.argb(Color.alpha(p),Color.red(p), Color.green(p),  value));
	
                      }
             	/*
             	int k;
             	k=image.getPixel(image.getWidth() - 1, image.getHeight() - 1);
             	
             	image.setPixel(image.getWidth() - 1, image.getHeight() - 1, Color.argb(A, R, G, k));
         	*/
             	 if (i == image.getWidth() - 1 && j == image.getHeight() - 1)
                 {
                     image.setPixel(i, j, Color.argb(Color.alpha(p),Color.red(p), Color.green(p), gizle.length()));
                 }
           // image.setPixel(i, j, Color.argb(A, R, G, B));

          } 

                }
             
               //  BitmapFactory.decodeFile("/storage/sdcard0/Download/a.jpeg");
                 FileOutputStream out = null;
                 try {
              	
                	 out = new FileOutputStream(imagePath);
                     image.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
                     // PNG is a lossless format, the compression factor (100) is ignored
                     Log.d("done",""+"its done");
                     }
                 catch (Exception e) {
                     e.printStackTrace();
                 }
                 finally {
	                     try {
	                         if (out != null) {
	                             out.close();
	                         }
	                     }
	                     catch (IOException e) {
	                         e.printStackTrace();
	                     }
	                 	} 
                 
                 Log.d("Imgnp",""+imagePath);
                 
                 Bundle extras2 = new Bundle();
     		
     			      extras2.putString(newPath,imagePath.toString());
                 
     			      Log.d("Imgnp",""+imagePath);
     			      Log.d("Imgnp",""+newPath);

     			  Intent intent = new Intent();
			      intent.putExtras(extras2);
			 
			      intent.setClass(getApplicationContext(), View1.class);
			     startActivity(intent);
              
             
    
    }
    
}