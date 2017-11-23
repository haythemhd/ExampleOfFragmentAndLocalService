package haythem.hd.applicationfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("State","onCreateA");
        setContentView(R.layout.activity_activity);
        tv = (TextView)findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this,ActivityB.class));
            }
        });
    }

    @Override
    protected void onResume() {
        Log.i("State","onCreateA");
        super.onResume();
    }
    @Override
    protected void onPause() {
        Log.i("State","onCreateA");
        super.onPause();
    }
    @Override
    protected void onStop() {
        Log.i("State","onCreateA");
        super.onStop();
    }
}
