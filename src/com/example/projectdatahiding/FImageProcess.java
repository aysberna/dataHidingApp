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


public class FImageProcess extends Activity {



	public static String fimagePath=null;
	public static String fimageMesaj=null;
	private Bundle extrasaf2 = null;

	
	public static String fnewPath="FNEWIMAGEPATH";

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fimageprocess);
        
        extrasaf2 = getIntent().getExtras();
        fimagePath=extrasaf2.getString(ChooseFile.filePath3);
        fimageMesaj=extrasaf2.getString(ChooseFile.filename);
       	   
      //  extras3 = getIntent().getExtras();
  
        Log.d("fimage", ""+ fimagePath);
        //Log.d("bundle",""+newMessage[2]);
        
        Log.d("fimage", ""+ fimageMesaj);
        
    
      
        int fp;
    
        	BitmapFactory.Options fopt= new BitmapFactory.Options();
            fopt.inPreferredConfig=Bitmap.Config.ARGB_8888;
                   
    
                  Bitmap fimage2=BitmapFactory.decodeFile(fimagePath,fopt);
                  Bitmap fimage=fimage2.copy(Bitmap.Config.ARGB_8888,true);
   
              String fimza="tou";
              String fm=fimageMesaj;
              
              String fgizle= new StringBuilder()
              .append(fimza)
              .append(fm)
              .toString();

              for(int i=0; i<fimage.getWidth(); i++){

             	for(int j=0; j<fimage.getHeight(); j++){

         	fp= fimage.getPixel(i,j);

             	if (i < 1 && j < fgizle.length())

                      {
             	Log.d("renk", ""+Color.red(fp));
             	Log.d("renk", ""+Color.green(fp));
             	Log.d("renk", ""+Color.blue(fp));

             	char fletter= fgizle.charAt(j);

             	int fvalue= (int) fletter;

             	Log.d("imzaascii",""+fletter);
             	Log.d("imzaascii",""+fvalue);
             	
             	int a;
            	a= Color.blue(fp);     	 
             	a=fvalue;
            	 
            	Log.d("imzaascii",""+fvalue);
            	
             	fimage.setPixel(i, j, Color.argb(Color.alpha(fp),Color.red(fp), Color.green(fp),  fvalue));
	
                      }
             	/*
             	int k;
             	k=image.getPixel(image.getWidth() - 1, image.getHeight() - 1);
             	
             	image.setPixel(image.getWidth() - 1, image.getHeight() - 1, Color.argb(A, R, G, k));
         	*/
             	 if (i == fimage.getWidth() - 1 && j == fimage.getHeight() - 1)
                 {
                     fimage.setPixel(i, j, Color.argb(Color.alpha(fp),Color.red(fp), Color.green(fp), fgizle.length()));
                 }
           // image.setPixel(i, j, Color.argb(A, R, G, B));

          } 

                }
             
               //  BitmapFactory.decodeFile("/storage/sdcard0/Download/a.jpeg");
                 FileOutputStream out = null;
                 try {
              	
                	 out = new FileOutputStream(fimagePath);
                     fimage.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
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
                 
                 Log.d("Imgnp",""+fimagePath);
                 
                 Bundle extras2 = new Bundle();
     		
     			      extras2.putString(fnewPath,fimagePath.toString());
                 
     			      Log.d("Imgnp",""+fimagePath);
     			      Log.d("Imgnp",""+fnewPath);

     			  Intent intent = new Intent();
			      intent.putExtras(extras2);
			 
			      intent.setClass(getApplicationContext(), FView.class);
			     startActivity(intent);
              
             
    
    }
    
}