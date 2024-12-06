package com.example.pr26_boboev__e.screen

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun TrackingPackage(navController: NavController) {
    val context = LocalContext.current
    val Novosibirsk = LatLng(55.041, 82.9346)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(Novosibirsk, 10f)
    }
    val mapProperties = MapProperties(
        maxZoomPreference = 18f,
        minZoomPreference = 5f,
        isTrafficEnabled = true,
        isBuildingEnabled = true,
        isMyLocationEnabled = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    )
    val uiSettings = MapUiSettings(
        compassEnabled = true,
        zoomControlsEnabled = false,
        myLocationButtonEnabled = false // Удаление значка "My Location"
    )

    Box(
        modifier = Modifier.fillMaxWidth().height(400.dp)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = mapProperties,
                uiSettings = uiSettings
            ) {
                // Пример маршрута
                val routePoints = listOf(
                    LatLng(55.041, 82.9346),
                    LatLng(55.050, 82.940),
                    LatLng(55.060, 82.950)
                )

                Polyline(
                    points = routePoints,
                    color = androidx.compose.ui.graphics.Color.Blue,
                    width = 5f
                )

                // Добавление маркеров для начальной и конечной точек маршрута
                Marker(
                    position = routePoints.first(),
                    title = "Начало маршрута"
                )

            }
        }
    }
}