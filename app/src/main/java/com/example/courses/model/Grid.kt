package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.util.ListResourceBundle
//  Grid class represents the string , image and numbers of images.
data class Grid(
    @StringRes val name : Int,
    val numberOfCourses : Int,
    @DrawableRes val imageRes: Int

)
