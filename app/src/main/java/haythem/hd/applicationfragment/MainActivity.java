package haythem.hd.applicationfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener {
    Button mServiceBtn;
    Button mServiceStopBtn;
    Button mLocalBroadcastManagerBtn;
    Button mMode;
    Button frag3;
    Button frag4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mServiceBtn = (Button) findViewById(R.id.serviceBtn);
        mServiceStopBtn = (Button) findViewById(R.id.servicestopBtn);
        mLocalBroadcastManagerBtn = (Button) findViewById(R.id.LocalBroadcastManager_btn);
        mMode = (Button) findViewById(R.id.launch_mode_btn);
        frag3 = (Button) findViewById(R.id.btn_frag3);
        frag4 = (Button) findViewById(R.id.btn_frag4);

        mServiceBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View actuelView)
            {
                startService(new Intent(MainActivity.this, MonPremierService.class));
            }
        });

        mServiceStopBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View actuelView)
            {
                stopService(new Intent(MainActivity.this, MonPremierService.class));
            }
        });


       mLocalBroadcastManagerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View actuelView)
            {
                    Intent i = new Intent(MainActivity.this,LocalBroadcastExampleActivity.class);
                    startActivity(i);
            }
        });

        mMode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View actuelView)
            {
                startActivity(new Intent(MainActivity.this,ActivityA.class));
            }
        });

        frag3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View actuelView)
            {
                FragmentThree fragment=new FragmentThree();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_two, fragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();

            }
        });

        frag4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View actuelView)
            {
                FragmentFour fragment=new FragmentFour();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_two, fragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(String ch) {
        Log.i("OnRecive",ch);
        FragmentTwo fragmentTwo = (FragmentTwo)
                getSupportFragmentManager().findFragmentById(R.id.fragment_two  );
        fragmentTwo.changeText(ch);

    }
}
