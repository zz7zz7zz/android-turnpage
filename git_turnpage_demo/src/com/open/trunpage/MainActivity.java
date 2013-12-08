package com.open.trunpage;

import com.open.turnpage.ShutterLeft2Right;
import com.open.turnpage.widget.TurnPageView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

public class MainActivity extends Activity {

	private TurnPageView mTurnPageView=null;
	private Bitmap []mBitmaps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mTurnPageView=new TurnPageView(getApplicationContext());
		mBitmaps=new Bitmap[1];
		int length=1;
		for(int i=0;i<length;i++)
		{
			mBitmaps[i]=((BitmapDrawable)(getResources().getDrawable(R.drawable.img_1+i))).getBitmap();
		}
		setContentView(mTurnPageView);
	}

	@Override
	protected void onResume() {
		mTurnPageView.setTurnPageStyle(new ShutterLeft2Right());
		mTurnPageView.setBitmaps(mBitmaps);
		super.onResume();
	}
	
}
