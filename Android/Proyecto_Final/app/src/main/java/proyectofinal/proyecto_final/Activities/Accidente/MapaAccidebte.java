package proyectofinal.proyecto_final.Activities.Accidente;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import proyectofinal.proyecto_final.R;

public class MapaAccidebte extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mapa;
    private final LatLng EAM = new LatLng(4.541763, -75.663464);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_accidebte);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;

        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(EAM, 15));

        mapa.getUiSettings().setZoomControlsEnabled(false);

        mapa.getUiSettings().setCompassEnabled(true);

        mapa.addMarker(new MarkerOptions().position(EAM)
                .title("EAM")
                .snippet("Escuela de administracion y mercadotecnia")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .anchor(0.5f, 0.5f));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getApplicationContext(),"No se ha dado permisos",Toast.LENGTH_SHORT).show();
            return;
        }else{

            mapa.setMyLocationEnabled(true);
        }
    }

    public void miPosicionActual(View view){
        if (mapa.getMyLocation() != null){
            double latitudActual = mapa.getMyLocation().getLatitude();
            double longitudActual = mapa.getMyLocation().getLongitude();

            mapa.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(new LatLng(
                            latitudActual,longitudActual),15)
            );
        }
    }
}