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
 
public class First extends Activity {
	
	  private ListView mainListView ;  
	  private ArrayAdapter<String> listAdapter ; 
     
    @SuppressLint("SdCardPath")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //----------------------------------------------------
       setContentView(R.layout.first); 
        
        mainListView = (ListView) findViewById( R.id.mainListView );  
        
        // Create and populate a List of planet names.  
        String[] planets = new String[] { "First Semester", "Second Semester"};    
        ArrayList<String> semesterList = new ArrayList<String>();  
        semesterList.addAll( Arrays.asList(planets) );  
          
        // Create ArrayAdapter using the planet list.  
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, semesterList);  
          
        // Add more planets. If you passed a String[] instead of a List<String>   
        // into the ArrayAdapter constructor, you must not add more items.   
        // Otherwise an exception will occur.  
        
        // Set the ArrayAdapter as the ListView's adapter.  
        mainListView.setAdapter( listAdapter );    
        //-----------------------------------------------------
        mainListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int position,
                    long paramLong) 
            {
                switch( position )
                {
           			case 0:  
           					Intent newActivity0 = new Intent(getBaseContext(), Sem1Sub.class);     
           					startActivity(newActivity0);
           					break;
           			case 1:  
           					Intent newActivity1 = new Intent(getBaseContext(), Sem2Sub.class);     
           					startActivity(newActivity1);
           					break;
           
                }              
            }
                                           });
          
    }

     
}