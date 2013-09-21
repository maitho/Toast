package com.androidthon.toast;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button simpleToast,customToast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//SIMPLE TOAST
		simpleToast = (Button) this.findViewById(R.id.bt_simple_toast);
		simpleToast.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//create a toast object and set the duration of the toast and the message
				Toast.makeText(getApplicationContext(),"This is a Simple Toast" , Toast.LENGTH_SHORT).show();
				
			}
		});
		
		//CUSTOM TOAST
		customToast = (Button) this.findViewById(R.id.bt_custom_toast);
		customToast.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Inflating our custom layout in the LayoutInflator
				LayoutInflater customInflator = getLayoutInflater();
				View customLayout = customInflator.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.toast_layout_container));
				
				//Getting our defined text view from the custom_layout_container
				TextView customText = (TextView) customLayout.findViewById(R.id.custom_toast_text);
				customText.setText("This is Custom Toast");
				
				//create the object for the toast and the duration of the display
				Toast customToast = new Toast(getApplicationContext());
				customToast.setDuration(Toast.LENGTH_LONG);
				customToast.setView(customLayout);
				customToast.show();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
