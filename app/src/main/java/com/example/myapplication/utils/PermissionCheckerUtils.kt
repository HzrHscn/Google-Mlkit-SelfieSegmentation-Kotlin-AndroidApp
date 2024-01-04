package com.example.myapplication.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest

object PermissionCheckerUtils {

    fun checkCameraPerm(context : Context, activity: Activity, process : () -> Unit){
        if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            process()
        } else{
            ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.CAMERA), 0)
        }
    }

    fun checkGalleryReadPerm(context : Context, activity: Activity, process : () -> Unit){
        if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            process()
        } else{
            ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }
    }

    fun checkGalleryWritePerm(context : Context, activity: Activity, process : () -> Unit){
        if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            process()
        } else{
            ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 2)
        }
    }
}