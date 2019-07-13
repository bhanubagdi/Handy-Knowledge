package com.knowledge.handyknowledge;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import java.util.ArrayList;  
import java.util.Arrays;
public class Years extends Activity {
	
	  private ListView mainListView ;  
	  private ArrayAdapter<String> listAdapter ; 
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen); 
        
        mainListView = (ListView) findViewById( R.id.mainListView );  
        
        // Create and populate a List of planet names.  
        String[] planets = new String[] { "First Year", "Second Year", "Third Year", "Fourth Year"};    
        ArrayList<String> yearsList = new ArrayList<String>();  
        yearsList.addAll( Arrays.asList(planets) );  
          
        // Create ArrayAdapter using the planet list.  
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, yearsList);  
          
        // Add more planets. If you passed a String[] instead of a List<String>   
        // into the ArrayAdapter constructor, you must not add more items.   
        // Otherwise an exception will occur.  
        
        // Set the ArrayAdapter as the ListView's adapter.  
        mainListView.setAdapter( listAdapter );  
        
        mainListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int position,
                    long paramLong) {
                switch( position )
        {
           case 0:  
        	   Intent newActivity0 = new Intent(getBaseContext(), First.class);     
                    startActivity(newActivity0);
                    break;
           case 1:  Intent newActivity1 = new Intent(getBaseContext(), Second.class);     
                    startActivity(newActivity1);
                    break;
           case 2:  Intent newActivity2 = new Intent(getBaseContext(), Third.class);     
                    startActivity(newActivity2);
                    break;
           case 3:  Intent newActivity3 = new Intent(getBaseContext(), Fourth.class);     
                    startActivity(newActivity3);
                    break;
        }              
                                    }
                                           });
          
         
    } 
     
}