package com.example.haritakullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haritakullanimi.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

// OnMapReadyCallback interface is used to notify the app when the map is ready to be used.
class MainActivity : AppCompatActivity() , OnMapReadyCallback{

    private lateinit var binding : ActivityMainBinding

    private lateinit var mMap:GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        // fragment manager is used to add the map fragment to the activity.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // getMapAsync() method is used to register the callback object.
        mapFragment.getMapAsync(this)

        binding.buttonKonumaGit.setOnClickListener {
            val konum = LatLng(40.904888, 31.180909)

            mMap.addMarker(MarkerOptions()
                .position(konum)
                .title("MF / M2")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.resim)))

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,17f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }



        setContentView(binding.root)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //40.904888, 31.180909

        val konum = LatLng(40.904888, 31.180909)
        mMap.addMarker(MarkerOptions().position(konum).title("MF / M2"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(konum))
    }
}