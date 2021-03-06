package com.example.projectdatahiding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

abstract class AlbumStorageDirFactory {
	public abstract File getAlbumStorageDir(String albumName);
}

public class Camera extends Activity {

	private static final int ACTION_TAKE_PHOTO=0;
	private ImageButton gizle;

	private static final String BITMAP_STORAGE_KEY = "viewbitmap";
	private static final String IMAGEVIEW_VISIBILITY_STORAGE_KEY = "imageviewvisibility";
	private ImageView mImageView;
	private Bitmap mImageBitmap;
	public static String path="PATH";
	public static File imageF;



	private String mCurrentPhotoPath;

	private static final String JPEG_FILE_PREFIX = "IMG_";
	private static final String JPEG_FILE_SUFFIX = ".jpg";

	private AlbumStorageDirFactory mAlbumStorageDirFactory = null;

	public final class BaseAlbumDirFactory extends AlbumStorageDirFactory {

		// Foto�raf�n kaydedilece�i lokasyon belirlenir
		private static final String CAMERA_DIR = "/dcim/";

		@Override
		public File getAlbumStorageDir(String albumName) {
			return new File (
					Environment.getExternalStorageDirectory()
					+ CAMERA_DIR
					+ albumName
			);
		}
	}
	public final class FroyoAlbumDirFactory1 extends AlbumStorageDirFactory {

		@Override
		public File getAlbumStorageDir(String albumName) {
			// TODO Auto-generated method stub
			return new File(
			  Environment.getExternalStoragePublicDirectory(
			    Environment.DIRECTORY_PICTURES
			  ), 
			  albumName
			);
		}
	}
	
	//uygulam i�in olu�turulan alb�m
	private String getAlbumName() {
		return getString(R.string.album_name);
	}

	
	private File getAlbumDir() {
		File storageDir = null;

		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			
			storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());

			if (storageDir != null) {
				if (! storageDir.mkdirs()) {
					if (! storageDir.exists()){
						Log.d("Veri Gizleme", "failed to create directory");
						return null;
					}
				}
			}
			
		} else {
			Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
		}
		
		return storageDir;
	}

	private File createImageFile() throws IOException {
		// Image file � olu�turma
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
		File albumF = getAlbumDir();
		imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
		
		Log.d("fotoad",""+imageFileName);
		Log.d("fotoad",""+imageF);
		
		
		//name = fotoad.toString().trim();
	
	//path = imageF.toString().trim();
		
				    
		
		return imageF;
	}

	private File setUpPhotoFile() throws IOException {
		
		File f = createImageFile();
		mCurrentPhotoPath = f.getAbsolutePath();
		
		return f;
	}

	private void setPic() {

		/* There isn't enough memory to open up more than a couple camera photos */
		/* So pre-scale the target bitmap into which the file is decoded */

		/* Get the size of the ImageView */
		int targetW = mImageView.getWidth();
		int targetH = mImageView.getHeight();

		/* Get the size of the image */
		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		bmOptions.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
		int photoW = bmOptions.outWidth;
		int photoH = bmOptions.outHeight;
		
		/* Figure out which way needs to be reduced less */
		int scaleFactor = 1;
		if ((targetW > 0) || (targetH > 0)) {
			scaleFactor = Math.min(photoW/targetW, photoH/targetH);	
		}

		/* Set bitmap options to scale the image decode target */
		bmOptions.inJustDecodeBounds = false;
		bmOptions.inSampleSize = scaleFactor;
		bmOptions.inPurgeable = true;

		/* Decode the JPEG file into a Bitmap */
		Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
		
		/* Associate the Bitmap to the ImageView */
		mImageView.setImageBitmap(bitmap);
		
		mImageView.setVisibility(View.VISIBLE);
		
	
	}

	//fotografi galeriye ekleme
	private void galleryAddPic() {
		    Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
			File f = new File(mCurrentPhotoPath);
		    Uri contentUri = Uri.fromFile(f);
		    mediaScanIntent.setData(contentUri);
		    this.sendBroadcast(mediaScanIntent);
	}

	private void dispatchTakePictureIntent(int actionCode) {

		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		switch(actionCode) {
		case ACTION_TAKE_PHOTO:
			File f = null;
			
			try {
				f = setUpPhotoFile();
				mCurrentPhotoPath = f.getAbsolutePath();
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
			} catch (IOException e) {
				e.printStackTrace();
				f = null;
				mCurrentPhotoPath = null;
			}
			break;

		default:
			break;			
		} // switch

		startActivityForResult(takePictureIntent, actionCode);
		
		
	
	}



	private void handleBigCameraPhoto() {

		if (mCurrentPhotoPath != null) {
			setPic();
			galleryAddPic();
			mCurrentPhotoPath = null;
			
		}

	}

	
	ImageButton.OnClickListener mTakePicOnClickListener = new ImageButton.OnClickListener()
	{
		@Override
		public void onClick(View v) {
			dispatchTakePictureIntent(ACTION_TAKE_PHOTO);
			
			
		}
	};
	private Context context;




	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
	 
	        
		
		mImageView = (ImageView) findViewById(R.id.imageView1);
	
		mImageBitmap = null;
	

		Button picBtn = (Button) findViewById(R.id.capture);
		setBtnListenerOrDisable( picBtn, mTakePicOnClickListener,MediaStore.ACTION_IMAGE_CAPTURE);

		
	
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
			mAlbumStorageDirFactory = new FroyoAlbumDirFactory1();
		} else {
			mAlbumStorageDirFactory = new BaseAlbumDirFactory();
		}
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	
			
		if (resultCode == RESULT_OK) {
				
		//***********************************************************************************
			handleBigCameraPhoto();
		//	startActivity(new Intent(Camera.this, Ascii.class));
			 try {
				    
			      Bundle extras = new Bundle();
		
			      extras.putString(path,imageF.toString());
			    
			     Log.d("camera",""+path);
			      Intent intent = new Intent();
			 
			
			      intent.putExtras(extras);
			 
			      intent.setClass(getApplicationContext(), Question.class);
			     startActivity(intent);
			     
			    } catch (Exception e) {
			      e.printStackTrace();
			    }

		} // ACTION_TAKE_PHOTO

			
		
	}

	// Some lifecycle callbacks so that the image can survive orientation change
	/*@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putParcelable(BITMAP_STORAGE_KEY, mImageBitmap);

		outState.putBoolean(IMAGEVIEW_VISIBILITY_STORAGE_KEY, (mImageBitmap != null) );
		
		super.onSaveInstanceState(outState);
	}*/

/*	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		mImageBitmap = savedInstanceState.getParcelable(BITMAP_STORAGE_KEY);
		
		mImageView.setImageBitmap(mImageBitmap);
		mImageView.setVisibility(
				savedInstanceState.getBoolean(IMAGEVIEW_VISIBILITY_STORAGE_KEY) ? 
						ImageView.VISIBLE : ImageView.INVISIBLE
						
		);
		
	}*/

	/**
	 * Indicates whether the specified action can be used as an intent. This
	 * method queries the package manager for installed packages that can
	 * respond to an intent with the specified action. If no suitable package is
	 * found, this method returns false.
	 * http://android-developers.blogspot.com/2009/01/can-i-use-this-intent.html
	 *
	 * @param context The application's environment.
	 * @param action The Intent action to check for availability.
	 *
	 * @return True if an Intent with the specified action can be sent and
	 *         responded to, false otherwise.
	 */
	public static boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list =
			packageManager.queryIntentActivities(intent,
					PackageManager.MATCH_DEFAULT_ONLY);
			
		return list.size() > 0;
	
	}

	private void setBtnListenerOrDisable(Button btn, ImageButton.OnClickListener onClickListener,String intentName)
	{
		if (isIntentAvailable(this, intentName)) {
			btn.setOnClickListener(onClickListener);        	
		} else {
			btn.setText( 
				getText(R.string.cannot).toString() + " " + btn.getText());
			btn.setClickable(false);
		}
	
		
		
	}

	
	
	
}

