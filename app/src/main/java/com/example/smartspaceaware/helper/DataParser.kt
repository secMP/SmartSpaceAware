package com.example.smartspaceaware.helper

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import android.content.Context

class DataParser(private val context: Context, private val fileName:String) {


    fun DataReader(): List<ContextualIntegrityData> {
        var jsonString =""
        try {
            jsonString = context.assets.open(fileName)
                .bufferedReader().use{it.readText()}
        }catch (ioException: IOException){
            Log.d("File Error", ioException.toString())
        }
        val gson = Gson()
        val listDataType = object : TypeToken<List<ContextualIntegrityData>>(){}.type
        val listData: List<ContextualIntegrityData> = gson.fromJson(jsonString, listDataType)
        return listData
    }
}