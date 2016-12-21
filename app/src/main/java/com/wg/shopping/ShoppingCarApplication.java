package com.wg.shopping;
import android.app.Activity;
import android.app.Application;
import android.os.Process;

import com.wg.shopping.base.tools.ToastUtils;

import java.util.Stack;

/**
 * Created by Edison on 2016/10/24.
 */
public class ShoppingCarApplication extends Application
{
    private static Stack<Activity> atyStack = new Stack<Activity>();

    @Override
    public void onCreate()
    {
        super.onCreate();
        ToastUtils.init(this);
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
        while(!atyStack.empty())
        {
            atyStack.pop().finish();
        }
        Process.killProcess(Process.myPid());
    }

    public static void push(Activity aty)
    {
        atyStack.push(aty);
    }

    public static void pop(Activity aty)
    {
        atyStack.remove(aty);
    }

    public static void closeSeries(Class<? extends Activity> cls)
    {
        for(int pos = findPos(cls); pos < atyStack.size() - 1; )
        {
            atyStack.pop().finish();
        }
    }

    private static int findPos(Class<? extends Activity> cls)
    {
        for(int pos = 0; pos < atyStack.size(); pos++)
        {
            if(atyStack.get(pos).getClass() == cls)
            {
                return pos;
            }
        }
        throw new IllegalStateException();
    }
}
