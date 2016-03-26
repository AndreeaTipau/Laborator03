package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {
	
	
	// clasa interna pentru hang up
	// ca sa vezi cum e 
	private class BtnHangUpListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			finish();
			// TODO Auto-generated method stub
			
		}
		
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		// editul vietii
        final EditText text =  (EditText)findViewById(R.id.editText1);
        
        
        // cifrele :D
        final int buttonids[] = {R.id.button1, R.id.button2, R.id.button3, 
        		R.id.button4, R.id.button5, R.id.button6,
            R.id.button7,R.id.button8,R.id.button9, 
            R.id.button0, R.id.button_diez,R.id.button_steluta};
        
        for( int i = 0 ; i < buttonids.length; i ++){
            final Button btn = (Button)findViewById(buttonids[i]);
            btn.setOnClickListener(new OnClickListener(){


                @Override
                public void onClick(View arg0) {
                    String textContinut = text.getText().toString();
                    text.setText( textContinut +  btn.getText());
                    // TODO Auto-generated method stub
                    
                }
            });
        }
        
        //butonul de call
        
        final ImageButton btnCall = (ImageButton)findViewById(R.id.imageButton1);
        
        btnCall.setOnClickListener(new OnClickListener(){


            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+text.getText()));
                startActivity(intent);
                
            }
        });
		
        
        // butonul de corectie
        
        final ImageButton btnCorectie = (ImageButton)findViewById(R.id.imageButton3);
        
  		btnCorectie.setOnClickListener(new OnClickListener(){


            @Override
            public void onClick(View arg0) {
            	String textContinut = text.getText().toString();
            	int length = textContinut.length();
            	if( length == 1 )text.setText("");
            	else if(length > 1){
            		length --;
            		 text.setText( textContinut.substring(0, length));
            	}
               
                
            }
        });
  		
  		// butonul de hang up
  		
  		 final ImageButton btnHangUp = (ImageButton)findViewById(R.id.imageButton2);
  		BtnHangUpListener listenerHangUp = new BtnHangUpListener();
  		 btnHangUp.setOnClickListener(listenerHangUp);
  		
  		
  
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
