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


public class FImageProcess2 extends Activity {



	public static String fimagePath2=null;
	public static String fimageMesaj2=null;
	private Bundle extrasaf22 = null;

	
	public static String fnewPath2="FNEWIMAGEPATH2";

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fimageprocess);
        
        extrasaf22 = getIntent().getExtras();
        fimagePath2=extrasaf22.getString(ChooseFile2.filePath32);
        fimageMesaj2=extrasaf22.getString(ChooseFile2.filename2);
       	   
      //  extras3 = getIntent().getExtras();
  
        Log.d("fimage", ""+ fimagePath2);
        //Log.d("bundle",""+newMessage[2]);
        
        Log.d("fimage", ""+ fimageMesaj2);
        
    
      
        int fp;
    
        	BitmapFactory.Options fopt= new BitmapFactory.Options();
            fopt.inPreferredConfig=Bitmap.Config.ARGB_8888;
                   
    
                  Bitmap fimage2=BitmapFactory.decodeFile(fimagePath2,fopt);
                  Bitmap fimage=fimage2.copy(Bitmap.Config.ARGB_8888,true);
   
              String fimza="tou";
              String fm=fimageMesaj2;
              
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
              	
                	 out = new FileOutputStream(fimagePath2);
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
                 
                 Log.d("Imgnp",""+fimagePath2);
                 
                 Bundle extras2 = new Bundle();
     		
     			      extras2.putString(fnewPath2,fimagePath2.toString());
                 
     			      Log.d("Imgnp",""+fimagePath2);
     			      Log.d("Imgnp",""+fnewPath2);

     			  Intent intent = new Intent();
			      intent.putExtras(extras2);
			 
			      intent.setClass(getApplicationContext(), FView2.class);
			     startActivity(intent);
              
             
    
    }
    
}