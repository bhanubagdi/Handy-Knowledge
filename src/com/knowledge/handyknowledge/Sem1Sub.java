package com.knowledge.handyknowledge;


import android.view.View;
import android.annotation.SuppressLint;
import android.app.Activity; 
import android.os.Bundle;  
import android.widget.AdapterView;
import android.widget.ArrayAdapter;  
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;  
import java.util.Arrays;
import android.content.Intent;
 
public class Sem1Sub extends Activity {
	
	  private ListView mainListView ;  
	  private ArrayAdapter<String> listAdapter ; 
	  public String selectedFromList;
     
    @SuppressLint("SdCardPath")
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
      //----------------------------------------------------
       setContentView(R.layout.first); 
        
        mainListView = (ListView) findViewById( R.id.mainListView );  
        
        // Create and populate a List of subject names.  
        String[] subjects = new String[] {"Engineering Mathematics I","Engineering Physics","Engineering Chemistry","Fundamentals of Programming languages I","Basic Electrical engineering","Basic Electronics Engineering","Basic civil and Environmental engineering","Engineering Graphics I"};    
        ArrayList<String> subjectList = new ArrayList<String>();  
        subjectList.addAll( Arrays.asList(subjects) );  
          
        // Create ArrayAdapter using the subject list.  
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, subjectList);  
          
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
					        	   Intent newActivity0 = new Intent(getBaseContext(), CopyAndOpen.class);   
					        	   newActivity0.putExtra("subname",selectedFromList);
					               startActivity(newActivity0);
					          
					        
					        
                    }
                                           
        });
          
     }

    }

