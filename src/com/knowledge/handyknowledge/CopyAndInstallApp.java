package com.knowledge.handyknowledge;


import java.io.File;


import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.annotation.SuppressLint;
import android.app.Activity; 
import android.os.Bundle;  
import android.os.Environment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;

public class CopyAndInstallApp extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        File dir = new File(Environment.getExternalStorageDirectory() + "/FirstApp/viewerapp");
        if(dir.exists() && dir.isDirectory()) {
          // do something here
         }
        else{
            //create dir here
            dir.mkdir(); 
           }
        
        File fileBrochure = new File(Environment.getExternalStorageDirectory()+"/FirstApp/viewerapp/Quickoffice.apk");
        if (!fileBrochure.exists())
        {
             CopyAssetsbrochure();
        } 

        /** PDF reader code */
        File file = new File(Environment.getExternalStorageDirectory()+"/FirstApp/viewerapp/Quickoffice.apk");       
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // without this flag android returned a intent error!
		try 
        {
            getApplicationContext().startActivity(intent);
        } 
        catch (Exception e) 
        {
            Toast.makeText(CopyAndInstallApp.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            
        }
         
    } 
    
  //method to write the PDFs file to sd card
    @SuppressLint("SdCardPath")
	private void CopyAssetsbrochure() {
        AssetManager assetManager = getAssets();
        String[] files = null;
        try 
        {
            files = assetManager.list("");
        } 
        catch (IOException e)
        {
            Log.e("tag", e.getMessage());
        }
        for(int i=0; i<files.length; i++)
        {
            String fStr = files[i];
            if(fStr.equalsIgnoreCase("Quickoffice.apk"))
            {
                InputStream in = null;
                OutputStream out = null;
                try 
                {
                  in = assetManager.open(files[i]);
                  out = new FileOutputStream(Environment.getExternalStorageDirectory()+"/FirstApp/viewerapp/" + files[i]);
                  copyFile(in, out);
                  in.close();
                  in = null;
                  out.flush();
                  out.close();
                  out = null;
                  break;
                } 
                catch(Exception e)
                {
                    Log.e("tag", e.getMessage());
                } 
            }
        }
    }

 private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
          out.write(buffer, 0, read);
        }
    }
}
