package org.videolan.vlc;

import org.videolan.vlc.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class VLCMain extends Activity
{
	private VLCView m_view;
    private LibVLC m_libVLC;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // tell system to use the layout defined in our XML file
        setContentView(R.layout.main);
        m_libVLC = new LibVLC();

        final Button button = (Button)findViewById(R.id.button);
        
        m_view = (VLCView)findViewById(R.id.vlc_view);
        m_view.setBackend(m_libVLC);
        
		Log.v("VLC", "Created, loading LibVLC.");

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
            	//Make sure surface is set before calling this...
            	if( !m_libVLC.Init() )
            		Log.e("VLC", "Unable to init libvlc");
            	m_libVLC.readMedia("/sdcard/test.mpg");
            }
        });
    }
}
