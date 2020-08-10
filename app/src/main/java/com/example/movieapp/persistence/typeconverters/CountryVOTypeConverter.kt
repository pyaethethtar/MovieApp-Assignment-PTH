package com.example.movieapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.movieapp.data.vos.CountryVO
import com.example.movieapp.data.vos.GenresVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CountryVOTypeConverter {

    @TypeConverter
    fun toString(countries : ArrayList<CountryVO>) : String{
        return Gson().toJson(countries)
    }

    @TypeConverter
    fun toArrayList(countriesJsonString: String) : ArrayList<CountryVO>{
        val countriesType = object : TypeToken<ArrayList<CountryVO>>(){}.type
        return Gson().fromJson(countriesJsonString, countriesType)
    }
}