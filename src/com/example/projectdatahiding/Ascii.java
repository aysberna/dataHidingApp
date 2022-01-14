package com.example.projectdatahiding;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class Ascii extends Activity {
	private ImageButton button;
	private TextView koduGoster,binaryKod;
	public static String mesaj="MESAJ";
	public static String asciiMesaj=null;
	public static String asciiPath2=null;
	public static int dizi2;
	public static String asciiPath3="ASCIIPATH3";
	
	private Bundle extrasa1 = null;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ascii);
		final ProgressDialog progress = new ProgressDialog(this);
        progress.setCancelable(true);
        progress.setTitle("progress dialog");
        progress.setMessage("Please Wait");        
        
		final EditText metinAl=(EditText) findViewById (R.id.metin);
		button=(ImageButton)findViewById(R.id.gonder);
	//	koduGoster=(TextView)findViewById(R.id.asciikod);
	//	binaryKod=(TextView)findViewById(R.id.binarykod);
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

		
			//edit text teki metni string e �evir
				
				 String metin_al=metinAl.getText().toString();
				Log.d("metin",""+metin_al);
				 
				asciiMesaj=metin_al;
				 Log.d("ascii",""+asciiPath2);
				
			     //cameradan pathi yakala
			      extrasa1 = getIntent().getExtras();
			      asciiPath2     = extrasa1.getString(Question.qPath3);
			     //cameradan pathi yakala
			      Log.d("ascii",""+asciiPath2);
			       
				 try {
					    
				     Bundle extrasa = new Bundle();
				      
				     extrasa.putString(asciiPath3, asciiPath2);
				    extrasa.putString(mesaj, asciiMesaj);
				      
				     Log.d("ascii",""+mesaj);
				     Log.d("ascii",""+asciiPath3);
				      
				     Intent intent = new Intent();
				     intent.putExtras(extrasa);
				      
				     intent.setClass(getApplicationContext(), ImageProcess.class);
				     startActivity(intent);
				     
				    } catch (Exception e) {
				      e.printStackTrace();
				    }
		      

			}}
			
				 );
	}}