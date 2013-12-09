package com.open.turnpage.widget;

/**
 * 左右上下滑动的四个事件
 * @author Administrator
 *
 */
public interface IFillingEvent {
	
	public void onFlingLeft();
	
	public void onFlingRight();
	
	public void onFlingUp();
	
	public void onFlingDown();
}
