package com.example.movieapp.views.components

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.withStyledAttributes
import com.example.movieapp.R
import com.google.android.material.tabs.TabLayout

class CustomTabLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    var normalText = R.color.textGray
    var selectedText = R.color.colorWhite

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomTabLayout){
            normalText = getColor(R.styleable.CustomTabLayout_normalTextColor, normalText)
            selectedText = getColor(R.styleable.CustomTabLayout_selectedTextColor, selectedText)
            setTabTextColors(normalText, selectedText)

        }

    }


}