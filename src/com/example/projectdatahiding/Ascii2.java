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


public class Ascii2 extends Activity {
	private ImageButton button;
	private TextView koduGoster,binaryKod;
	public static String mesajg="MESAJG";
	public static String asciiMesajg=null;
	public static String asciiPath2g=null;
	public static int dizi2g;
	public static String asciiPath3g="ASCIIPATH3G";
	
	private Bundle extrasg2 = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ascii2);
		
		final ProgressDialog progress2 = new ProgressDialog(this);
        progress2.setCancelable(true);
        progress2.setTitle("progress dialog");
        progress2.setMessage("Please Wait");
		
        
		final EditText metinAl=(EditText) findViewById (R.id.metin);
		button=(ImageButton)findViewById(R.id.gonder);
		//koduGoster=(TextView)findViewById(R.id.asciikod);
		//binaryKod=(TextView)findViewById(R.id.binarykod);
		button.setOnClickListener(new OnClickListener(){
			
			@Override
            public void onClick(View v) {
                progress2.show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                //edit text teki metni string e cevir
				 String metin_al=metinAl.getText().toString();
				 
				 Log.d("metin",""+metin_al);
				 
				asciiMesajg=metin_al;
				 Log.d("ascii",""+asciiPath2g);
				
			     //cameradan pathi yakala
			      extrasg2 = getIntent().getExtras();
			      asciiPath2g     = extrasg2.getString(Question2.qPath32);
			     //cameradan pathi yakala
			      Log.d("ascii",""+asciiPath2g);
			       
				 try {
					    
				     Bundle extrasg3 = new Bundle();
				      
				     extrasg3.putString(asciiPath3g, asciiPath2g);
				    extrasg3.putString(mesajg, asciiMesajg);
				      
				     Log.d("ascii",""+mesajg);
				     Log.d("ascii",""+asciiPath3g);
				      
				     Intent intent = new Intent();
				     intent.putExtras(extrasg3);
				      
				     intent.setClass(getApplicationContext(), ImageProcess2.class);
				     startActivity(intent);
				     
				    } catch (Exception e) {
				      e.printStackTrace();
				    }
			      
			 
			      
			      

				}}
				
					 );
		}}