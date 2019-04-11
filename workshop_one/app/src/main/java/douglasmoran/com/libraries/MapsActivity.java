package douglasmoran.com.libraries;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import douglasmoran.com.libraries.Models.Libraries;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        mMap = googleMap;

        //recuperar coordenadas
        Libraries librariesCoordinates = getIntent().getParcelableExtra("detail");

        Toast.makeText(this, String.valueOf(librariesCoordinates.getCountry()), Toast.LENGTH_SHORT).show();

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(librariesCoordinates.getMap_lat(), librariesCoordinates.getMap_long());
        mMap.addMarker(new MarkerOptions().position(sydney).title(librariesCoordinates.getCountry()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));

        /*LatLng parkMoran = new LatLng(13.831011,-89.272049);
        centralPark = googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.parking)).position(parkMoran).title("Parque Morán"));

        LatLng tomaCancha = new LatLng(13.847482 ,-89.292378);
        toma = googleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.aquapark)).position(tomaCancha).title("Cancha de la Toma"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(parkMoran,20));*/


    }
}
