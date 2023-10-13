package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity(),OnMapReadyCallback {
    private var mGoogleMap:GoogleMap?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapFragment=supportFragmentManager
            .findFragmentById(R.id.mapfragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googlemap: GoogleMap) {
       mGoogleMap=googlemap
    }
}