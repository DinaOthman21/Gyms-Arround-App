package com.example.new_gymsarround_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.new_gymsarround_app.ui.theme.New_GymsArround_AppTheme

@Composable
fun GymsScreen(){
    val vm:GymsViewModel= viewModel ()

    LazyColumn() {
     items(vm.state) {gym->
     GymItem(gym){
          vm.taggleFavouriteState(it) }
 }
    }

}

@Composable
fun GymItem(gym :Gym ,onClick:(Int) ->Unit) {

    var isFavouriteState by remember { mutableStateOf(false) }
    val icon = if (gym.isFavourite){
        Icons.Filled.Favorite
    } else{
        Icons.Filled.FavoriteBorder
    }
    Card( elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            DefaultIcon(Icons.Filled.Place , Modifier.weight(0.15f), "Location Icon")
           // Spacer(modifier = Modifier.width(10.dp))
            GymDetails( gym, Modifier.weight(.70f))
            DefaultIcon(icon ,Modifier.weight(.15f),"Favourite gym icon") {
                onClick(gym.id)}
        }
    }
}

@Composable
fun DefaultIcon(icon :ImageVector,
                modifier: Modifier,
                contentDescription:String,
                onClick: () ->Unit ={}) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription ,
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onClick()
            } ,
        colorFilter = ColorFilter.tint(
            Color.DarkGray)
        )
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



@Preview(name="p1",showBackground = true , showSystemUi = true)
@Composable
fun GymsScreenPreview(){
 New_GymsArround_AppTheme {
     GymsScreen()
 }
}