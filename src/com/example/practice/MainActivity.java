package com.example.practice;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {
	final String tag = "ticketresponder";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		final EditText edittext1 = (EditText) findViewById(R.id.editText1);
		final Button button1 = (Button) findViewById(R.id.button1);
		final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.spinner1_items,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);

		button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String docket = edittext1.getText().toString();
				String status = spinner1.getSelectedItem().toString();
				String msg;
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				AlertDialog ad = adb.create();
			if (docket.length()== 0 ){
					msg = "Docket # can't be blanks. Please enter value.";
			}
				else
				{
					msg = "Updating docket [" + docket.trim() + "] to ["
							+ status + "].";
				}
				ad.setMessage(msg);
				ad.show();
				
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
