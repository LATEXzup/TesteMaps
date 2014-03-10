package com.fundacao.testemaps.app;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;

import Location.UserPosition;
import Location.map;
import Rest.RestLiga;

public class MainActivity extends Activity {
    View m = null;
    static final LatLng SP = new LatLng( -23.5965995247643721, -46.68809878834976);
    static final LatLng Guarulhos = new LatLng(-23.560002957327292, -46.65697556208617);
    GoogleMap ma;

    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //login
     //   RestLiga res = new RestLiga();
       // res.Login("","");

        //position
        IniciarServico();

        //mapa

        ma = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        ma.setMyLocationEnabled(true);
        ma.getMyLocation();




        ma.setBuildingsEnabled(true);
        ma.setTrafficEnabled(true);
        ma.setIndoorEnabled(true);

       // ma.moveCamera(CameraUpdateFactory.newLatLngZoom(SP,10));
        ma.animateCamera(CameraUpdateFactory.zoomTo(15),6000,null);
        //ma.addMarker(new MarkerOptions().position(SP).title("Acidente").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_crash)));
        ma.addMarker(new MarkerOptions().position(Guarulhos).title("Roubo"));

        //
        addListenerOnButton();

    }
    ImageButton imageButton;
    public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.btReport);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                ma.addMarker(new MarkerOptions().position(SP).title("Loca correndo na rua").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_crash)));

            }

        });

    }

    public void IniciarServico()
    {

        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Atualizar(location);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}

        };

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }
    public void Atualizar(Location location)
    {
        Double latPoint = location.getLatitude();
        Double lngPoint = location.getLongitude();
        LatLng ml = new LatLng( latPoint, lngPoint);
        ma.moveCamera(CameraUpdateFactory.newLatLngZoom(ml,10));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
