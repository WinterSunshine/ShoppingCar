package com.wg.shopping.view.custom;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wg.shopping.R;

public class BottomPopView
{
    private View convertView;
    private Context context;
    private int theme;
    private Dialog bv;
    private int animationStyle;
    private boolean isTop = false;

    public BottomPopView(Context c, int layoutRes)
    {
        this.context = c;
        this.theme = R.style.BottomViewStyle;
        this.convertView = View.inflate(c, layoutRes, null);
        this.setAnimation(R.style.BottomToTopAnim);
        this.bv = new Dialog(this.context, this.theme);
        this.bv.setContentView(this.convertView);
    }

    @SuppressWarnings("deprecation")
    public void showBottomView(boolean CanceledOnTouchOutside)
    {
        this.bv.setCanceledOnTouchOutside(CanceledOnTouchOutside);
        // this.bv.getWindow().requestFeature(1);
        Window wm = this.bv.getWindow();
        WindowManager m = wm.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = wm.getAttributes();
        p.width = (d.getWidth() * 1);
        if(this.isTop)
        {
            p.gravity = 48;
        }else
        {
            p.gravity = 80;
        }
        if(this.animationStyle != 0)
        {
            wm.setWindowAnimations(this.animationStyle);
        }
        wm.setAttributes(p);
        this.bv.show();
    }

    public void setTopIfNecessary()
    {
        this.isTop = true;
    }

    public void setAnimation(int animationStyle)
    {
        this.animationStyle = animationStyle;
    }

    public View getView()
    {
        return this.convertView;
    }

    public void dismissBottomView()
    {
        if(this.bv != null)
        {
            this.bv.dismiss();
        }
    }
}
