package com.example.new_gymsarround_app

val listOfGyms = listOf<Gym>(
    Gym(1,"Gold’s Gym","Open Air Mall Madinaty, Egypt"),
    Gym(2,"CrossFit Engine38","Shooting Club Dokki, Giza, Egypt"),
    Gym(3,"Gold’s Studio"," Katameya Residence"),
    Gym(4,"Befit 360","Katameya Heights, Cairo, Egypt"),
    Gym(5,"Gold’s Gym","Open Air Mall Madinaty, Egypt"),
    Gym(6,"CrossFit Engine38","Shooting Club Dokki, Giza, Egypt"),


)

data class Gym( val id:Int ,val name: String , val place :String , var isFavourite:Boolean=false)
