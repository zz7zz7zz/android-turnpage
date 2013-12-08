package com.open.turnpage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.SurfaceHolder;

public class ShutterDown2Up implements ITurnPage {

	private int duration=350;//动画持续时间
	private final int leafNum=7;
	private PaintFlagsDrawFilter pdf=new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);
	
	public ShutterDown2Up() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTurnPageDraw(SurfaceHolder holder, Bitmap[] bitmap,
			int maxWidth, int maxHeight) {
		
		int perHeight=maxHeight/leafNum;
		
		long start=System.currentTimeMillis();
		long runMills=0;
		
		Canvas canvas=null;
		boolean isRunning=true;
		while(isRunning)
		{
			isRunning=((runMills=(System.currentTimeMillis()-start))<duration);
			if(!isRunning)
			{
				runMills=duration;
			}
			
			try {
					canvas=holder.lockCanvas(null);
					
					canvas.setDrawFilter(pdf);
					canvas.drawColor(Color.BLACK);// 清除画布
					
					for(int j=0;j<leafNum;j++)
					{
						Rect src=new Rect(0, (int)((j+1)*perHeight-((float)runMills/(float)duration)*perHeight), maxWidth, (j+1)*perHeight);
						canvas.drawBitmap(bitmap[0], src, src, null);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(null!=canvas)
				{
					holder.unlockCanvasAndPost(canvas);
				}
				else
				{
					break;
				}
				
				if(!isRunning)
				{
					break;
				}
			}
		}
	}

	@Override
	public void onDestory() {
		// TODO Auto-generated method stub

	}

}
