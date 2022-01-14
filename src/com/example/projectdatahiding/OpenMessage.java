package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;


public class OpenMessage extends Activity {



	public static String imagePathM=null;
	public static String imageMesajM=null;
	private Bundle extraso2 = null;
	
	public static String secret="SECRET";

	public static String newPathM="NEWIMAGEPATHM";

	 public static String gizlimesaj = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.openmessage);
        
        extraso2 = getIntent().getExtras();
        imagePathM=extraso2.getString(Open.mpath);
       
       
        Log.d("imageM", ""+ imagePathM);
       
      
        
        int lastpixel;
        int p;
    
            
               BitmapFactory.Options opt= new BitmapFactory.Options();
               opt.inPreferredConfig=Bitmap.Config.ARGB_8888;
                   
                  Bitmap image2=BitmapFactory.decodeFile(imagePathM,opt);
                  Bitmap image=image2.copy(Bitmap.Config.ARGB_8888,true);

          
             
              
              lastpixel = image.getPixel(image.getWidth()-1, image.getHeight()-1);
              
              Log.d("openm",""+lastpixel);
              
              int msgLength = Color.blue(lastpixel);
              
             Log.d("openm",""+msgLength);
             
             
             String message1 = "";
          
              for (int i = 0; i < image.getWidth(); i++)
              {
                  for (int j = 0; j < image.getHeight(); j++)
                  {
                       p = image.getPixel(i, j);

                      if (i < 1 && j < 3)
                      {
                          int value = Color.blue(p);
                          
                          Log.d("openm",""+value);
                          
                          char ch = (char)value;
                          
                          Log.d("openm",""+ch);
                          
                          String s = Character.toString(ch);
                          
                          Log.d("openm",""+s);
                          
                          message1 = message1 + s;
                          
                  //       message = Character.toString((char)value);
                   //      Log.d("openm",""+message);
                         
                      }
                  }
            
              }

              Log.d("openm",""+message1);
              
         String patern1="tou";
         Log.d("openm",""+message1);
		 Log.d("openm",""+patern1);	
		 
		 
	//	 String patern2="filetou";
		 
	boolean s=new String(patern1).equals(message1);
	
	//boolean sf=new String(patern2).equals(message1);
	
	Log.d("openm",""+s);
				
		 if(s==true)     
		 {
			
            	 // String gizlimesaj = "";
                  for (int i = 0; i < image.getWidth(); i++)
                  {
                      for (int j = 3; j < image.getHeight(); j++)
                      {
                           p = image.getPixel(i, j);

                          if (i < 1 && j < msgLength)
                          {
                              int value = Color.blue(p);
                              
                              Log.d("openm",""+value);
                              
                              char ch2 = (char)value;
                              
                              Log.d("openm",""+ch2);
                              
                              String s2 = Character.toString(ch2);
                              
                              Log.d("openm",""+s2);
                              
                              gizlimesaj = gizlimesaj + s2;
                              
                      //       message = Character.toString((char)value);
                       //      Log.d("openm",""+message);
                             
                          }
                      }
                
                  }
                  Log.d("openmg",""+gizlimesaj);
               
              }
            
		// else if(sf=true)
		 
			 
			 
			 
			 
			 
		 		 
		 
		 
		 else {
	       	  String uyari= "Acilamiyor";
	       	  Log.d("openmg",""+uyari);
	         }
              
		 
		 Bundle extrass = new Bundle();
		 extrass.putString(secret, gizlimesaj);
	
		 Intent intent = new Intent();
				 
				
       			 intent.putExtras(extrass);
       			 
       			      intent.setClass( getApplicationContext(), ViewMessage.class);
       			     startActivity(intent);
                     
        
}
             
          
    
    
    
}