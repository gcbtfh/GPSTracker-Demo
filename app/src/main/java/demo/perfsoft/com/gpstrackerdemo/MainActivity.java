package demo.perfsoft.com.gpstrackerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnTrackGps;
    private GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrackGps = (Button) findViewById(R.id.btnTrackGPS);
        gpsTracker = new GPSTracker(this);

        btnTrackGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gpsTracker.canGetLocation()) {
                    Toast.makeText(MainActivity.this, "Latitude = " +gpsTracker.getLatitude()+ " ---- Longitude = "
                            +gpsTracker.getLongitude(), Toast.LENGTH_SHORT).show();
                }else {
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }
}
