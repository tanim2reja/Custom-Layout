package com.example.customeLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CustomLayout extends ViewGroup {

	
	

	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
		final int count = getChildCount();
		int curWidth, curHeight, curLeft, curTop, maxHeight;
		
		int childLeft = this.getPaddingLeft();
		int childTop =this.getPaddingTop();
		int childRight = this.getMeasuredWidth() - this.getPaddingRight();
		int childBottom = this.getMeasuredHeight() - this.getPaddingBottom();
		
		int childWidth = childRight - childLeft;
		  int childHeight = childBottom - childTop;
		  
		  maxHeight = 0;
		  curLeft = childLeft;
		  curTop = childTop;
		  
		  for (int i = 0; i < count; i++) {
			    View child = getChildAt(i);
			    if (child.getVisibility() != GONE) {
			      //Get the maximum size of the child
			      child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), 
			                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
			      curWidth = child.getMeasuredWidth();
			      curHeight = child.getMeasuredHeight();
			      //wrap is reach to the end
			      if (curLeft + curWidth >= childRight) {
			        curLeft = childLeft;
			        curTop += maxHeight;
			        maxHeight = 0;
			      }
			      //do the layout
			      child.layout(curLeft, curTop, curLeft + curWidth, curTop + curHeight);
			      //store the max height
			      if (maxHeight < curHeight)
			        maxHeight = curHeight;
			      curLeft += curWidth;
			    }
			  }
	}

}
