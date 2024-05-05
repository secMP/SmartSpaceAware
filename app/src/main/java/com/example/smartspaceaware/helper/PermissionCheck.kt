package com.example.smartspaceaware.helper

import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.smartspaceaware.MainActivity
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

class PermissionCheck(private val mainActivity: MainActivity){
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun AskPermission(){
        val permissionState = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
        val lifecycleOwner = LocalLifecycleOwner.current

        DisposableEffect(key1 = lifecycleOwner) {
            val observer = LifecycleEventObserver { source, event ->
                when(event){
                    Lifecycle.Event.ON_START->{
                        permissionState.launchPermissionRequest()
                    }
                    else -> {

                    }
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            if(!permissionState.status.isGranted){
                val  text = if(permissionState.status.shouldShowRationale){
                    "Permission required for notifcation."
                }else{
                    "Please provide Notification permission to continue."
                }
                Toast.makeText(mainActivity,text, Toast.LENGTH_LONG).show()
            }

        }
    }

}