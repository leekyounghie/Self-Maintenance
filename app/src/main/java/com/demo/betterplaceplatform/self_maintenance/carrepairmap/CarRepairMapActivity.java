package com.demo.betterplaceplatform.self_maintenance.carrepairmap;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.demo.betterplaceplatform.self_maintenance.R;
import com.demo.betterplaceplatform.self_maintenance.calander.Calandar_Activity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class CarRepairMapActivity extends FragmentActivity implements OnMapReadyCallback {

    LocationManager manager;
    GoogleMap map;
    ArrayList<LatLng> latLngsarray;
    String[] PositionName = null;
    Marker[] marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carcentamap_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        PositionName = getPostionName();
        marker = new Marker[PositionName.length];
        setArrayListItem();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng sydney = new LatLng(37.4692, 126.4406);
//        map.addMarker(new MarkerOptions().position(sydney).title("Seoul"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        for (int i = 0; i < latLngsarray.size(); i++) {
            marker[i] = map.addMarker(new MarkerOptions().position(latLngsarray.get(i)).title(PositionName[i]));
        }

        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(37.4213, 128.06598), 7);
        map.animateCamera(cameraUpdate);

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intentSubActivity =
                        new Intent(getApplicationContext(), Calandar_Activity.class);
                startActivity(intentSubActivity);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private String[] getPostionName() {
        String[] GroupName = {"서울시 사당동", "인천시 구월동", "수원시 화서동", "천안시 동남구",
                "대전시 서구", "광주시 서구", "대구 중구", "부산 연제구"};
        return GroupName;
    }

    private void setArrayListItem() {
        LatLng sadang = new LatLng(37.484956, 126.967608);
        LatLng guwal = new LatLng(37.453404, 126.704328);
        LatLng hwaser = new LatLng(37.282283, 127.006538);
        LatLng dongnam = new LatLng(36.817575, 127.131006);
        LatLng sergu = new LatLng(36.334804, 127.395495);
        LatLng kwangju = new LatLng(35.160562, 126.847062);
        LatLng daegu = new LatLng(35.865701, 128.587471);
        LatLng busan = new LatLng(35.175957, 129.078323);

        latLngsarray = new ArrayList<>();
        latLngsarray.add(sadang);
        latLngsarray.add(guwal);
        latLngsarray.add(hwaser);
        latLngsarray.add(dongnam);
        latLngsarray.add(sergu);
        latLngsarray.add(kwangju);
        latLngsarray.add(daegu);
        latLngsarray.add(busan);
    }
}

