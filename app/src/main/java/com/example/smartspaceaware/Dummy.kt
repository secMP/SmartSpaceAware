package com.example.smartspaceaware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.smartspaceaware.helper.LayoutTable
import com.example.smartspaceaware.ui.theme.SmartSpaceAwareTheme

class Dummy : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SmartSpaceAwareTheme {
                LayoutTable(this, "dummyData.json", R.drawable.dummy2)
            }
        }
    }

}
