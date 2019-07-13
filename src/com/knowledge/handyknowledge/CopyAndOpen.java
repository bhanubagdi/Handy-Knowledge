package com.knowledge.handyknowledge;


import java.io.File;
import android.view.View;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.annotation.SuppressLint;
import android.app.Activity; 
import android.os.Bundle;  
import android.os.Environment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;  
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;  
import java.util.Arrays;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.util.Log;

public class CopyAndOpen extends Activity {
	
	String selectedFromList;
	String value;
	String filename;
	String filearr[];
	private ListView mainListView ;  
	private ArrayAdapter<String> listAdapter ; 
	@SuppressLint("SdCardPath")
	@Override
	
	
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        
        Bundle extras = getIntent().getExtras(); 
        if(extras !=null) {
            value = extras.getString("subname");
        }
        
        File dir = new File(Environment.getExternalStorageDirectory() + "/FirstApp/"+value);
		        if(dir.exists() && dir.isDirectory()) 
		        {
		          // do something here
		        }
		        else
		        {
		            //create dir here
		            dir.mkdirs(); 
		        }
					try   
					{
					Resources res = getResources(); //if you are in an activity
					AssetManager am = res.getAssets();
					filearr = am.list(value);
					}
					catch (IOException e)
					{
					  
					}
			if (filearr != null)
		    {  			
				for ( int i = 0;i<filearr.length;i++)
                {
				  filename=filearr[i];
			      File fileBrochure = new File(Environment.getExternalStorageDirectory() + "/FirstApp/"+value+"/"+filename+"");
			        if (!fileBrochure.exists())
			        {
			             CopyAssetsbrochure(filename);
			        } 
                }    
		    }    
     ///code do display the list of files  
			setContentView(R.layout.first); 
	        
	        mainListView = (ListView) findViewById( R.id.mainListView );  
	        
	        // Create and populate a List of subject names.  
	        String[] files = filearr;   
	        ArrayList<String> fileList = new ArrayList<String>();  
	        fileList.addAll( Arrays.asList(files) );  
	          
	        // Create ArrayAdapter using the subject list.  
	        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, fileList);  
	          
	        // Set the ArrayAdapter as the ListView's adapter.  
	        mainListView.setAdapter( listAdapter );    
	        //-----------------------------------------------------
	        mainListView.setOnItemClickListener(new OnItemClickListener() 
	        {
			            @Override
			            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int position,
			                    long paramLong) 
			            {
			            	selectedFromList =(String) (mainListView.getItemAtPosition(position));
			            	File fileBrochure = new File(Environment.getExternalStorageDirectory() + "/FirstApp/"+value+"/"+selectedFromList+"");
			            	if (!fileBrochure.exists())
			            	{
			            		CopyAssetsbrochure(selectedFromList);
			            	}
			            	OpenPDF(value,selectedFromList);
	                    }
	                                           
	        });
	          
   //////  ///end of code do display the list of files  
        
         
    } 
    
	
	private void OpenPDF(String value1, String filename1)
	{
		/** PDF reader code */
        File file = new File(Environment.getExternalStorageDirectory() + "/FirstApp/"+value1+"/"+filename1+"");       
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),"application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction("android.intent.action.VIEW");
		try 
        {
            getApplicationContext().startActivity(intent);
        } 
        catch (ActivityNotFoundException e) 
        {
            Toast.makeText(CopyAndOpen.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
            Intent newActivity0 = new Intent(getBaseContext(), CopyAndInstallApp.class);     
            startActivity(newActivity0);
        }
	}
  //method to write the PDFs file to sd card
    @SuppressLint("SdCardPath")
	private void CopyAssetsbrochure(String filename2) 
    {
        AssetManager assetManager = getAssets();
       
        String[] files = null;
        try 
        {
            files = assetManager.list(value);
        } 
        catch (IOException e)
        {
            Log.e("tag", e.getMessage());
        }
        for(int i=0; i<files.length; i++)
        {
            
                InputStream in = null;
                OutputStream out = null;
                try 
                {
                  in = assetManager.open(value+"/"+filename2);
                  out = new FileOutputStream(Environment.getExternalStorageDirectory() + "/FirstApp/"+ value+"/"+filename2);
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

 private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
          out.write(buffer, 0, read);
        }
    }
}
