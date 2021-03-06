package com.wg.shopping.base.tools;
import android.util.Log;

import java.lang.reflect.Method;

public class ReflectUtils
{
    private ReflectUtils()
    {
    }

    public static void invokeMethod(Object receiver, String methodName, Object param, Class<?> parameterTypes)
    {
        try
        {
            Method declaredMethod = getDeclaredMethod(receiver, methodName, parameterTypes);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(receiver, param);
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.e(receiver.getClass().getSimpleName(), e.getMessage());
        }
    }

    public static void invokeMethod(Object receiver, String methodName, Object param, Object param1st, Class<?>... parameterTypes)
    {
        try
        {
            Method declaredMethod = getDeclaredMethod(receiver, methodName, parameterTypes);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(receiver, param, param1st);
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.e(receiver.getClass().getSimpleName(), e.getMessage());
        }
    }

    public static void invokeMethod(Object receiver, String methodName)
    {
        try
        {
            Method method = getDeclaredMethod(receiver, methodName);
            method.setAccessible(true);
            method.invoke(receiver);
        }catch(Exception e)
        {
            Log.e(receiver.getClass().getSimpleName(), e.getMessage());
        }
    }

    private static Method getDeclaredMethod(Object receiver, String methodName, Class<?>... parameterTypes)
    {
        Method method = null;
        for(Class<?> clazz = receiver.getClass(); clazz != Object.class; clazz = clazz.getSuperclass())
        {
            try
            {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            }catch(Exception e)
            {
                continue;
            }
        }
        throw new NoSuchMethodError(methodName);
    }
}
