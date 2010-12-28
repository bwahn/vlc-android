package org.videolan.vlc;

import org.videolan.vlc.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

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

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
            	//Make sure surface is set before calling this...
            	m_libVLC.Init();
            	m_libVLC.readMedia("/sdcard/test.mp4");
            }
        });
    }
}
