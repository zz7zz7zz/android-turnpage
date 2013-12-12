package com.open.trunpage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Window;

import com.open.turnpage.BlackSquareFadeAway;
import com.open.turnpage.BlackSquareZoomIn;
import com.open.turnpage.ShutterDown2Up;
import com.open.turnpage.ShutterLeft2Right;
import com.open.turnpage.ShutterRight2Left;
import com.open.turnpage.ShutterUp2Down;
import com.open.turnpage.TranslateLeft;
import com.open.turnpage.TranslateRight;
import com.open.turnpage.widget.IFillingEvent;
import com.open.turnpage.widget.TurnPageView;

public class TuruPageActivity extends Activity {

	private TurnPageView mTurnPageView=null;
	private Bitmap []mBitmaps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);	
		
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
		
		int index=getIntent().getIntExtra("index", 1);
		if(index==1)
		{
			trunPage1();
		}
		else if(index==2)
		{
			trunPage2();
		}
		else if(index==3)
		{
			trunPage3();
		}
		
		super.onResume();
	}
	
	private void trunPage1()
	{
		IFillingEvent mFillingListener=new IFillingEvent()
		{

			@Override
			public void onFlingLeft() {
				mTurnPageView.setTurnPageStyle(new ShutterRight2Left());
				
			}

			@Override
			public void onFlingRight() {
				mTurnPageView.setTurnPageStyle(new ShutterLeft2Right());
				
			}

			@Override
			public void onFlingUp() {
				mTurnPageView.setTurnPageStyle(new ShutterDown2Up());
				
			}

			@Override
			public void onFlingDown() {
				mTurnPageView.setTurnPageStyle(new ShutterUp2Down());
			}
			
		};
		
		mTurnPageView.setOnFillingListener(mFillingListener);
		mTurnPageView.setTurnPageStyle(new ShutterLeft2Right());
		mTurnPageView.setBitmaps(mBitmaps);
	}
	
	private void trunPage2()
	{
		IFillingEvent mFillingListener=new IFillingEvent()
		{

			@Override
			public void onFlingLeft() {
				mTurnPageView.setTurnPageStyle(new BlackSquareZoomIn());
				
			}

			@Override
			public void onFlingRight() {
				mTurnPageView.setTurnPageStyle(new BlackSquareFadeAway());
				
			}

			@Override
			public void onFlingUp() {
				mTurnPageView.setTurnPageStyle(new BlackSquareZoomIn());
				
			}

			@Override
			public void onFlingDown() {
				mTurnPageView.setTurnPageStyle(new BlackSquareFadeAway());
			}
			
		};
		
		mTurnPageView.setOnFillingListener(mFillingListener);
		mTurnPageView.setTurnPageStyle(new BlackSquareZoomIn());
		mTurnPageView.setBitmaps(mBitmaps);
	}
	
	private void trunPage3()
	{
		IFillingEvent mFillingListener=new IFillingEvent()
		{

			@Override
			public void onFlingLeft() {
				mTurnPageView.setTurnPageStyle(new TranslateLeft());
				
			}

			@Override
			public void onFlingRight() {
				mTurnPageView.setTurnPageStyle(new TranslateRight());
				
			}

			@Override
			public void onFlingUp() {
				mTurnPageView.setTurnPageStyle(new TranslateRight());
				
			}

			@Override
			public void onFlingDown() {
				mTurnPageView.setTurnPageStyle(new TranslateLeft());
			}
			
		};
		
		mTurnPageView.setOnFillingListener(mFillingListener);
		mTurnPageView.setTurnPageStyle(new TranslateLeft());
		mTurnPageView.setBitmaps(mBitmaps);
	}
	
}
