package com.open.trunpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);	
		setContentView(R.layout.mainui);
		
		findViewById(R.id.btn1).setOnClickListener(listener);
		findViewById(R.id.btn2).setOnClickListener(listener);
	}

	private View.OnClickListener listener=new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent mIntent=new Intent(getBaseContext(), TuruPageActivity.class);
			int index=1;
			switch(v.getId())
			{
				case R.id.btn1:
						index=1;
						break;
						
				case R.id.btn2:
					index=2;
					break;
			}
			mIntent.putExtra("index", index);
			startActivity(mIntent);
		}
	};
}
