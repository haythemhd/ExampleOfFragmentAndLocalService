package haythem.hd.applicationfragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LocalBroadcastExampleActivity extends Activity {
    TextView textView ;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast_example);

        intentFilter = new IntentFilter("custom-event-name");
        Button buttonStartService = (Button)findViewById(R.id.button_ok);
        textView = (TextView)findViewById(R.id.textview);

        buttonStartService.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Register MessageService in Manifest to work
                startService(new Intent(LocalBroadcastExampleActivity.this, MessageService.class));
            }
        });


    }

    @Override
    protected void onPause() {
        // Unregister since the activity is paused.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(
                mMessageReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        LocalBroadcastManager.getInstance(this).registerReceiver(
                mMessageReceiver, intentFilter);
        super.onResume();
    }

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "custom-event-name" is broadcasted.
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // Get extra data included in the Intent
            String message = intent.getStringExtra("message");
            textView.setText(message);
            Log.d("receiver", "Got message: " + message);
        }
    };


}
