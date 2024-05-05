package com.example.smartspaceaware.helper

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import android.content.Context

class DataParser(private val context: Context, private val fileName:String) {

    @Composable
    fun DummyReader() {
        var jsonString =""
        try {
            jsonString = context.assets.open("data.json")
                .bufferedReader().use{it.readText()}
        }catch (ioException: IOException){
            Log.d("File Error", ioException.toString())
        }
        val gson = Gson()
        val listDataType = object : TypeToken<List<ContextualIntegrityData>>(){}.type
        val listData: List<ContextualIntegrityData> = gson.fromJson(jsonString, listDataType)
        Text(text = listData.get(0).device.toString())

    }
}