package com.example.new_gymsarround_app

val listOfGyms = listOf<Gym>(
    Gym("Gold’s Gym","Open Air Mall Madinaty, Egypt"),
    Gym("CrossFit Engine38","Shooting Club Dokki, Giza, Egypt"),
    Gym("Gold’s Studio"," Katameya Residence"),
    Gym("Befit 360","Katameya Heights, Cairo, Egypt"),
    Gym("Gold’s Gym","Open Air Mall Madinaty, Egypt"),
    Gym("CrossFit Engine38","Shooting Club Dokki, Giza, Egypt"),
    Gym("Gold’s Gym","Open Air Mall Madinaty, Egypt"),
    Gym("CrossFit Engine38","Shooting Club Dokki, Giza, Egypt"),
    Gym("Gold’s Studio"," Katameya Residence"),
    Gym("Befit 360","Katameya Heights, Cairo, Egypt"),
    Gym("Gold’s Gym","Open Air Mall Madinaty, Egypt"),
    Gym("CrossFit Engine38","Shooting Club Dokki, Giza, Egypt"),

)

data class Gym(val name: String , val place :String)
