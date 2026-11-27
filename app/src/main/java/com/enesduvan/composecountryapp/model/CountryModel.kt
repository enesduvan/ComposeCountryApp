package com.enesduvan.composecountryapp.model

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CountryModel(
    val name: String?,
    val capital: String?,
    val region: String?,
    @ColumnInfo(name = "language")
    val language: String?,
    @SerializedName("flag")
    val flagUrl: String?,
    @SerializedName("currency")
    val price : String?,
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
)