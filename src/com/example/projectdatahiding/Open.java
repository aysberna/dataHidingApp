package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

	public class Open extends Activity {
	     
	     
	    private static int RESULT_LOAD_IMAGE = 1;
	     
	    public static String mpath="MPATH";
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.open);
	         
	        ImageButton buttonLoadImage = (ImageButton) findViewById(R.id.buttonLoadPicture);
	        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View arg0) {
	                 
	                Intent i = new Intent(
	                        Intent.ACTION_PICK,
	                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	                 
	                startActivityForResult(i, RESULT_LOAD_IMAGE);
	            }
	        });
	    }
	     
	     
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	         
	        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
	            Uri selectedImage = data.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	            Cursor cursor = getContentResolver().query(selectedImage,
	                    filePathColumn, null, null, null);
	            cursor.moveToFirst();
	 
	            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	            String picturePath = cursor.getString(columnIndex);
	            cursor.close();
	            
	            Log.d("open",""+picturePath);
	            
	            ImageView imageView = (ImageView) findViewById(R.id.imgView);
	            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	      

	            Bundle extraso = new Bundle();
	        	
	            extraso.putString(mpath,picturePath);
	          
	           Log.d("open",""+mpath);
	            Intent intent = new Intent();
	            
	         intent.putExtras(extraso);

	            intent.setClass(getApplicationContext(), OpenMessage.class);
	           startActivity(intent);
	            
	            
	        }
	     
	      
	    }
	    
	    

	}
