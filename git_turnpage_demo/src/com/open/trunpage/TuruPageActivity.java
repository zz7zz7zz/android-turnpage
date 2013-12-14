package com.open.trunpage;

import android.app.Activity;
import android.graphics.Bitmap;
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
import com.open.turnpage.util.BitmapUtil;
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
		int length=2;
		mBitmaps=new Bitmap[length];
		for(int i=0;i<length;i++)
		{
			mBitmaps[i]=BitmapUtil.getFitBitmapFromResource(getResources(), R.drawable.img_1+i, 
					SysUtil.getScreenWidth(getApplicationContext()), SysUtil.getScreenHeight(getApplicationContext())-SysUtil.getStatusBarHeight(getApplicationContext()));
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
	
	@Override
	protected void onDestroy() {
		for(int i=0;i<mBitmaps.length;i++)
		{
			if(null!=mBitmaps[i]&&!mBitmaps[i].isRecycled())
			{
				mBitmaps[i].recycle();
			}
		}
		super.onDestroy();
	}




	int curBitmapIndex=0;
	private void prePage()
	{
		if(curBitmapIndex>0)
		{
			curBitmapIndex--;
		}
		else
		{
			curBitmapIndex=0;
		}
		mTurnPageView.setBitmaps(new Bitmap[]{mBitmaps[curBitmapIndex]});
	}
	
	private void nextPage()
	{
		if(curBitmapIndex<mBitmaps.length-1)
		{
			curBitmapIndex++;
		}
		mTurnPageView.setBitmaps(new Bitmap[]{mBitmaps[curBitmapIndex]});
	}
	
	private void trunPage1()
	{
		IFillingEvent mFillingListener=new IFillingEvent()
		{

			@Override
			public void onFlingLeft() {
				nextPage();
				mTurnPageView.setTurnPageStyle(new ShutterRight2Left());
				
			}

			@Override
			public void onFlingRight() {
				prePage();
				mTurnPageView.setTurnPageStyle(new ShutterLeft2Right());
				
			}

			@Override
			public void onFlingUp() {
				nextPage();
				mTurnPageView.setTurnPageStyle(new ShutterDown2Up());
				
			}

			@Override
			public void onFlingDown() {
				prePage();
				mTurnPageView.setTurnPageStyle(new ShutterUp2Down());
			}
			
		};
		
		mTurnPageView.setOnFillingListener(mFillingListener);
		mTurnPageView.setTurnPageStyle(new ShutterLeft2Right());
		mTurnPageView.setBitmaps(new Bitmap[]{mBitmaps[curBitmapIndex]});
	}
	
	private void trunPage2()
	{
		IFillingEvent mFillingListener=new IFillingEvent()
		{

			@Override
			public void onFlingLeft() {
				nextPage();
				mTurnPageView.setTurnPageStyle(new BlackSquareZoomIn());
				
			}

			@Override
			public void onFlingRight() {
				prePage();
				mTurnPageView.setTurnPageStyle(new BlackSquareFadeAway());
				
			}

			@Override
			public void onFlingUp() {
				nextPage();
				mTurnPageView.setTurnPageStyle(new BlackSquareZoomIn());
				
			}

			@Override
			public void onFlingDown() {
				prePage();
				mTurnPageView.setTurnPageStyle(new BlackSquareFadeAway());
			}
			
		};
		
		mTurnPageView.setOnFillingListener(mFillingListener);
		mTurnPageView.setTurnPageStyle(new BlackSquareZoomIn());
		mTurnPageView.setBitmaps(new Bitmap[]{mBitmaps[curBitmapIndex]});
	}
	
	private void trunPage3()
	{
		IFillingEvent mFillingListener=new IFillingEvent()
		{

			@Override
			public void onFlingLeft() {
				nextPage();
				mTurnPageView.setTurnPageStyle(new TranslateLeft());
				
			}

			@Override
			public void onFlingRight() {
				prePage();
				mTurnPageView.setTurnPageStyle(new TranslateRight());
				
			}

			@Override
			public void onFlingUp() {
				nextPage();
				mTurnPageView.setTurnPageStyle(new TranslateRight());
				
			}

			@Override
			public void onFlingDown() {
				prePage();
				mTurnPageView.setTurnPageStyle(new TranslateLeft());
			}
			
		};
		
		mTurnPageView.setOnFillingListener(mFillingListener);
		mTurnPageView.setTurnPageStyle(new TranslateLeft());
		mTurnPageView.setBitmaps(new Bitmap[]{mBitmaps[curBitmapIndex]});
	}
	
}
