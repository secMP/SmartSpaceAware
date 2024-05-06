package com.example.smartspaceaware

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartspaceaware.helper.PermissionCheck
import com.example.smartspaceaware.ui.theme.SmartSpaceAwareTheme

class MainActivity : ComponentActivity() {
    private val  permissionCheck = PermissionCheck(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartSpaceAwareTheme {
                permissionCheck.AskPermission()
                createButtonMenu(modifier = Modifier)
            }
            if(this.intent.extras != null){
                val context = LocalContext.current
                val caseString = this.intent.extras?.getString("click_action").toString()
                if (caseString == "Dummy"){
                    context.startActivity(Intent( context, Dummy::class.java))
                }
            }
        }
    }
}

@Composable
fun createButtonMenu(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Office Kitchen")
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Working Space")
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Private Office")
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Meeting Room")
        }
        ElevatedButton(
            onClick = {
                context.startActivity(Intent( context, Dummy::class.java))
            },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Dummy Device")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    createButtonMenu()
}

