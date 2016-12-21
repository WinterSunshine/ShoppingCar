package com.wg.shopping.view.custom;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Edison on 2016/10/26.
 */
public class ShoppingList extends ListView
{
    public ShoppingList(Context context)
    {
        super(context);
    }

    public ShoppingList(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ShoppingList(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
