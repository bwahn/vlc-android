package org.videolan.vlc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class VLCView extends SurfaceView
    implements SurfaceHolder.Callback
{
    private SurfaceHolder m_holder;
    private LibVLC        m_libVLC;

    //TODO:
    //static native int getVideoHeight();
    //static native int getVideoWidth();
    //static native void setSurfaceChanged(Surface surface, int px, int py);

    public VLCView(Context context)
    {
        super(context);
        initContext(context);
    }

    public VLCView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        initContext(context);
    }

    public void setBackend(LibVLC libVLC)
    {
        m_libVLC = libVLC;
    }

    private void initContext(Context context)
    {
        SurfaceHolder holder = getHolder();
        this.m_holder = holder;
        this.m_holder.addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int arg, int px, int py)
    {
        //setSurfaceChanged(surfaceHolder.getSurface(), px, py);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder)
    {
        // Give the surface to draw the video to libVLC
        m_libVLC.setSurface(surfaceHolder.getSurface());
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder)
    {
    }
}
