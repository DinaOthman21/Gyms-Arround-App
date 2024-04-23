package com.example.new_gymsarround_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.new_gymsarround_app.ui.theme.New_GymsArround_AppTheme

@Composable
fun GymsScreen(){
    LazyColumn {
     items(listOfGyms) {gym->
     GymItem(gym)
 }
    }
}

@Composable
fun GymItem(gym :Gym) {

    Card( elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            GymIcon(Icons.Filled.Place , Modifier.weight(0.25f))
           // Spacer(modifier = Modifier.width(10.dp))
            GymDetails( gym, Modifier.weight(.85f))
            /*DefaultIcon(icon , Modifier.weight(.15f),"Favourite Gym Icon"){
                onFavouriteIconClick(gym.id ,gym.isFavourite)
            }*/
        }
    }
}

@Composable
fun GymDetails( gym:Gym ,modifier: Modifier) {
Column(modifier=modifier) {
    Text(
        text = gym.name,
        style = MaterialTheme.typography.h5,
        color = Color.Magenta
        )

    Text(
        text = gym.place,
        style = MaterialTheme.typography.body2,
        fontWeight = FontWeight.Medium
        )
}
}


@Composable
fun GymIcon(vector: ImageVector, modifier: Modifier) {
    Image(imageVector = vector,
        contentDescription ="GymIcon",
        modifier=modifier,
        colorFilter = ColorFilter.tint(
            Color.DarkGray))
}



@Preview(name="p1",showBackground = true , showSystemUi = true)
@Composable
fun GymsScreenPreview(){
 New_GymsArround_AppTheme {
     GymsScreen()
 }
}