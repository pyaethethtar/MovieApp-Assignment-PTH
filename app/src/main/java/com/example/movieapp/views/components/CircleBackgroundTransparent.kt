package com.example.movieapp.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.example.movieapp.R

class CircleBackgroundTransparent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val paint= Paint(Paint.ANTI_ALIAS_FLAG)
    private var colorFill = Color.BLACK
    private var size = 300f

    init {
        context.withStyledAttributes(attrs, R.styleable.CircleBackgroundTransparent){
            colorFill = getColor(R.styleable.CircleBackgroundTransparent_colorFill, colorFill)
            size = getDimension(R.styleable.CircleBackgroundTransparent_size, size)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color= colorFill
        paint.style=Paint.Style.FILL
        val radius = size/2
        canvas?.drawCircle(size, size, radius, paint)
    }


}