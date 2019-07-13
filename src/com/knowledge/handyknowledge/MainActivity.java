package com.knowledge.handyknowledge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				 
		   Button button= (Button) findViewById(R.id.click_enter);
		   button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) 
		    {
		    	Intent i = new Intent(getBaseContext(), Selection.class);
                startActivity(i);
		        
		    }
		   							});
	}

}
