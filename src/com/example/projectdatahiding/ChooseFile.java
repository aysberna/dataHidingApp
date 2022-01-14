package com.example.projectdatahiding;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChooseFile extends ListActivity {
 
	
	
	private ImageButton button;
	
 private List<String> item = null;
 private List<String> path = null;
 private String root;
 private TextView myPath;
 	public static String filename="FILENAME";
	public static String filen=null; //asciiMesaj
	public static String filePath2=null;
	public static String filePath3="FILEPATH3";
	
	private Bundle extrasf1 = null;
	
 
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file);
        
        myPath = (TextView)findViewById(R.id.path);
        
        root = Environment.getExternalStorageDirectory().getPath();
        
        getDir(root);
        
    
		final ProgressDialog progress = new ProgressDialog(this);
        progress.setCancelable(true);
        progress.setTitle("progress dialog");
        progress.setMessage("Please Wait");        
        
      /*  button=(ImageButton)findViewById(R.id.dosyagonder);

		button.setOnClickListener(new OnClickListener(){
			 
			@Override
            public void onClick(View v) {
                progress.show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                extrasf1 = getIntent().getExtras();
			    filePath2     = extrasf1.getString(Question.qPathf3);
		  
		    
                
                Bundle extrasaf = new Bundle();
			      
			     extrasaf.putString(filePath3, filePath2);
		//	    extrasaf.putString(filename, filen);
			      
                
			     Intent intent = new Intent();
			     intent.putExtras(extrasaf);
			      
			     intent.setClass(getApplicationContext(), FImageProcess.class);
			     startActivity(intent);
	

			}}
			
				 );
	
        */
    }
    
    public void getDir(String dirPath)
    {
     myPath.setText("Location: " + dirPath);
     item = new ArrayList<String>();
     path = new ArrayList<String>();
     File f = new File(dirPath);
     File[] files = f.listFiles();
     
     if(!dirPath.equals(root))
     {
      item.add(root);
      path.add(root);
      item.add("../");
      path.add(f.getParent()); 
     }
     
     for(int i=0; i < files.length; i++)
     {
      File file = files[i];
      
      if(!file.isHidden() && file.canRead()){
       path.add(file.getPath());
          if(file.isDirectory()){
           item.add(file.getName() + "/");
          }else{
           item.add(file.getName());
          }
      } 
     }

     ArrayAdapter<String> fileList =
       new ArrayAdapter<String>(this, R.layout.file2, item);
     setListAdapter(fileList); 
    }

 @Override
 public void onListItemClick(ListView l, View v, int position, long id) {
  // TODO Auto-generated method stub
  File file = new File(path.get(position));
/*
  try {

			String dosya_al = new Scanner( new File(file.getName()) ).useDelimiter("\\Z").next();
		
			Log.d("ascii",""+dosya_al);
				// filen=dosya_al;
				 	 
					filen=dosya_al;
				 
				 
				 Bundle extrasf2 = new Bundle();
			      
		//	     extrasaf2.putString(filePath3, filePath2);
		    extrasf2.putString(filename, filen);
			      
                
			     Intent intent = new Intent();
			     intent.putExtras(extrasf2);

			
			
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  */
  if (file.isDirectory())
  {
   if(file.canRead()){
    getDir(path.get(position));
   }else{
    new AlertDialog.Builder(this)
     .setIcon(R.drawable.ic_launcher)
     .setTitle("[" + file.getName() + "] folder can't be read!")
     .setPositiveButton("OK", null).show(); 
   } 
  }else {
   
   
   String dosya_ad=file.getName();
   

 //Find the directory for the SD Card using the API
 //*Don't* hardcode "/sdcard"
 File sdcard = Environment.getExternalStorageDirectory();

 //Get the text file
 File file2 = new File(sdcard,dosya_ad);

 //Read text from file
 StringBuilder text = new StringBuilder();

 try {
     BufferedReader br = new BufferedReader(new FileReader(file));
     String line;

     while ((line = br.readLine()) != null) {
         text.append(line);
         text.append('\n');
     }
     br.close();
 }
 catch (IOException e) {
     //You'll need to add proper error handling here
 }
 
   
   Log.d("dos",""+file.getName());
   
   filen=text.toString();
   Log.d("dos",""+filen);
   
   
   extrasf1 = getIntent().getExtras();
   filePath2     = extrasf1.getString(Question.qPathf3);


   
   Bundle extrasaf = new Bundle();
     
    extrasaf.putString(filePath3, filePath2);
//	    extrasaf.putString(filename, filen);
     
   
    Intent intent = new Intent();
    intent.putExtras(extrasaf);
     
    
    
    Bundle extrasf2 = new Bundle();
    
//    extrasaf2.putString(filePath3, filePath2);
extrasf2.putString(filename, filen);
     
  
 //   Intent intent2 = new Intent();
    intent.putExtras(extrasf2);

    
    intent.setClass(getApplicationContext(), FImageProcess.class);
    startActivity(intent);
   
/*
   
try {
	
	
	Log.d("imzaascii",""+file.getName());
	
	String dosya_al = new Scanner( new File(dosya_ad), "UTF-8" ).useDelimiter("\\A").next();
	
	
	
	
	Log.d("imzaascii",""+dosya_al);
	// filen=dosya_al;
	 	 
		filen=dosya_al;
		Log.d("imzaascii",""+filen);
	
} catch (FileNotFoundException e) {

	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
		 
		 
		 Bundle extrasf2 = new Bundle();
	      
//	     extrasaf2.putString(filePath3, filePath2);
   extrasf2.putString(filename, filen);
	      
       
	     Intent intent = new Intent();
	     intent.putExtras(extrasf2);
*/
   
   
    new AlertDialog.Builder(this)
    .setIcon(R.drawable.ic_launcher)
    .setTitle("[" + file.getName() + "]")
    .setPositiveButton("OK", null).show();

    }
 }
 
 
 
 

}