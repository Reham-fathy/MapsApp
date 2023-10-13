package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
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
        val mapOptionButton:ImageButton=findViewById(R.id.mapOptionMenu)
        val popUpMenu=PopupMenu(this,mapOptionButton)
        popUpMenu.menuInflater.inflate(R.menu.map_options,popUpMenu.menu)
        popUpMenu.setOnMenuItemClickListener { menuItem->
            changeMap(menuItem.itemId)
            true

        }
        mapOptionButton.setOnClickListener {
            popUpMenu.show()
        }
    }

    private fun changeMap(itemId: Int) {
    when(itemId){
      R.id.normal_map->mGoogleMap?.mapType=GoogleMap.MAP_TYPE_NORMAL
      R.id.hybird_map->mGoogleMap?.mapType=GoogleMap.MAP_TYPE_HYBRID
      R.id.satellite_map->mGoogleMap?.mapType=GoogleMap.MAP_TYPE_SATELLITE
      R.id.terrian_map->mGoogleMap?.mapType=GoogleMap.MAP_TYPE_TERRAIN
    }
    }

    override fun onMapReady(googlemap: GoogleMap) {
       mGoogleMap=googlemap
    }
}