package com.example.smartspaceaware.helper

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.smartspaceaware.R

class CustomLayout (){
}


@Composable
fun LayoutTable(context: Context, fileName: String){
    val data = DataParser(context,fileName).DataReader()
    LazyColumn {
        items(data){ d ->
            LayoutCard(Modifier, d)
        }
    }
}
@Composable
fun LayoutCard(modifier: Modifier, d: ContextualIntegrityData){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
    ) {
        Column (modifier = Modifier
            .padding(top = 10.dp)){
            Text(
                text = d.device.toString(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(255,255,255)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0, 0, 139))
            )
            CreateElement("Data Type" ,  d.dataType.toString())
            CreateElement("Purpose" ,  d.purpose.toString())
            CreateElement("Sensor" ,  d.sensor.toString())
            CreateElement("Data Retention" ,  d.dataRetention.toString())
            CreateElement("Data Access" ,  d.dataAccess.toString())
            CreateElement("Description" ,  d.description.toString())
            Image(
                painter = painterResource(id = R.drawable.dummy),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }



    }
}

@Composable
fun CreateElement(titleString: String, descriptionString: String){
    Row{
        Text(text = titleString+":",
            modifier = Modifier
                .padding(10.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color(red = 51, green = 0, blue = 25)
            )
        )
        Text(text = descriptionString,
            modifier = Modifier
                .padding(top = 10.dp))
    }
}

