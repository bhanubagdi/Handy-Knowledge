package com.knowledge.handyknowledge;

import java.io.IOException;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search extends Activity {
  public String value;
  String filearr[];
  boolean res;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
				 
		   Button button= (Button) findViewById(R.id.click_it);
		   button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) 
		    {
		    	EditText text = (EditText)findViewById(R.id.edit_message);
		    	value = text.getText().toString(); 
		    	try   
				{
				Resources res = getResources(); //if you are in an activity
				AssetManager am = res.getAssets();
				filearr = am.list("");
				}
				catch (IOException e)
				{
				  
				}
		    	//Toast.makeText(Search.this,Integer.toString(filearr.length), Toast.LENGTH_SHORT).show();
		    	res=false;
		    	if (filearr != null)
			    {  			
					for ( int i = 0;i<filearr.length;i++)
	                {
						//Toast.makeText(Search.this,filearr[i], Toast.LENGTH_SHORT).show();
				        if (filearr[i].equalsIgnoreCase(value))
				        {
				            value= filearr[i];
				        	res=true;
				        } 
	                }    
			    }    
		    	if(res)
		    	{
		    	Intent newActivity0 = new Intent(getBaseContext(), CopyAndOpen.class);   
	        	newActivity0.putExtra("subname",value);
	            startActivity(newActivity0);	  
		    	}
		    	else
		    	{
		    		Toast.makeText(Search.this, "NO such subject found, please reverify the entered subject name", Toast.LENGTH_SHORT).show();
		    		
		    	}
		    	
		    }
		   							});///click listener end
	}

}
