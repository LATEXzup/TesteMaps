package com.fundacao.testemaps.app;

import android.app.Activity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpException;
import org.apache.http.client.ClientProtocolException;

import Location.map;
import Rest.RestLiga;

public class MainActivity extends Activity {
    View m = null;
    static final LatLng SP = new LatLng(-23.3251, -46.3810);
    static final LatLng KIEL = new LatLng(53.551, 9.993);
    GoogleMap ma;



    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestLiga res = new RestLiga();
        Object result  = res.Login("","");


       // ma = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
       // ma.moveCamera(CameraUpdateFactory.newLatLngZoom(SP,15));
       // ma.animateCamera(CameraUpdateFactory.zoomTo(5),2000,null);
       // ma.addMarker(new MarkerOptions().position(SP).title("Liga"));

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
