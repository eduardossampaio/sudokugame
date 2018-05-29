package com.apps.esampaio.sudoku.view.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.apps.esampaio.sudoku.R
import com.apps.esampaio.sudoku.entity.Coordinate
import com.apps.esampaio.sudoku.entity.SudokuGame

/**
 * Created by eduardo.sampaio on 29/03/18.
 */

class SudokuBoard(private val context_: Context, attrs: AttributeSet) : View(context_, attrs) {

    private var boardPaint: Paint = Paint()
    private var quadrantPaint: Paint = Paint()
    private var selectedQuadrantPaint: Paint = Paint()
    private var textPaintImmutable: Paint = Paint()
    private var textPaintMutable: Paint = Paint()
    private var squareWidth: Int = 0
    private var selectedPosition: Coordinate? = null
    private val strokeWidth = 2

    var listener: SudokuBoardListener? = null

    var sudokuGame: SudokuGame = SudokuGame()

    init {
        this.squareWidth = width / 9
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        this.squareWidth = width / 9
        setMeasuredDimension(width, width)
        initializePaints()
    }

    private fun initializePaints() {
        val defaultTextFont = Typeface.createFromAsset(context_.assets, "fonts/comic_sans_ms_bold.ttf")
        boardPaint.apply {
            isAntiAlias = true
            color =context_.resources.getColor(R.color.board_border_color)
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeWidth = 4f
        }

        quadrantPaint.apply {
            color =context_.resources.getColor(R.color.quadrant_color)
            strokeWidth = 0f
            isAntiAlias = true
        }

        selectedQuadrantPaint.apply {
            color = context_.resources.getColor(R.color.selected_square_color)
            strokeWidth = 0f
            isAntiAlias = true
        }

        textPaintImmutable.apply {
            textSize = squareWidth * 0.65f
            isAntiAlias = true
            color = context_.resources.getColor(R.color.immutable_text_color)
            textAlign = Paint.Align.CENTER
            typeface = Typeface.create(this.typeface,Typeface.BOLD)
//            typeface = Typeface.create(defaultTextFont,Typeface.BOLD)
        }

        textPaintMutable.apply {
            textSize = squareWidth * 0.65f
            isAntiAlias = true
            color = context_.resources.getColor(R.color.mutable_text_color)
            textAlign = Paint.Align.CENTER
            typeface = Typeface.create(this.typeface,Typeface.BOLD)
//            typeface = Typeface.create(defaultTextFont,Typeface.BOLD)
        }
    }

    fun drawBoard(canvas: Canvas) {
        for (i in 0..8) {
            for (j in 0..8) {
                val square = buildSquareAtPosition(i, j)
                canvas.drawRect(square, boardPaint!!)
            }
        }
        paintQuadrant(canvas, Coordinate(0, 0))
        paintQuadrant(canvas, Coordinate(6, 0))

        paintQuadrant(canvas, Coordinate(3, 3))

        paintQuadrant(canvas, Coordinate(0, 6))
        paintQuadrant(canvas, Coordinate(6, 6))

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {

            MotionEvent.ACTION_DOWN -> if (x > 0 && x < width && y > 0 && y < width) {
                val clickedPosition = getClickedPosition(x, y)
                setSelectedPosition(clickedPosition)
                invalidate()
                if (listener != null) {
                    listener!!.onPositionSelected(clickedPosition.x, clickedPosition.y)
                }
            }
        }
        return true
    }

    private fun getClickedPosition(touchX: Float, touchY: Float): Coordinate {
        return Coordinate((touchX / squareWidth).toInt(), (touchY / squareWidth).toInt())
    }

    fun addNumber(indexX: Int, indexY: Int, number: Int) {
        if ( sudokuGame.addNumber(indexX,indexY,number) ) {
            invalidate()
        }
    }
    fun removeNumber(indexX: Int, indexY: Int){
        if(sudokuGame.removeNumber(indexX,indexY)) {
            invalidate()
        }
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.squareWidth = width / 9
        drawBoard(canvas)
        drawSelectedPosition(canvas)
        drawNumbers(canvas)
    }

    private fun drawNumbers(canvas: Canvas) {
        for ((position, number) in sudokuGame.sudokuNumbers) {
            if (number.immutable) {
                drawNumber(canvas, number.value, position.x, position.y, textPaintImmutable)
            } else {
                drawNumber(canvas, number.value, position.x, position.y, textPaintMutable)
            }
        }
    }

    private fun drawSelectedPosition(canvas: Canvas) {
        if (selectedPosition != null) {
            val selectedPositionSquare = buildSquareAtPosition(selectedPosition!!.x, selectedPosition!!.y, strokeWidth)
            canvas.drawRect(selectedPositionSquare, selectedQuadrantPaint)
//            for ( i in 0..8){
//                canvas.drawRect(buildSquareAtPosition(selectedPosition!!.x,i,strokeWidth),selectedQuadrantPaint)
//                canvas.drawRect(buildSquareAtPosition(i,selectedPosition!!.y,strokeWidth),selectedQuadrantPaint)
//            }
        }
    }

    private fun drawNumber(canvas: Canvas, num: Int, xIndex: Int, yIndex: Int, paint: Paint) {
        if (xIndex < 0 || xIndex > 8 || yIndex < 0 || yIndex > 8) {
            return
        }

        val rectF = RectF((xIndex * squareWidth).toFloat(), (yIndex * squareWidth).toFloat(), ((xIndex + 1) * squareWidth).toFloat(), ((yIndex + 1) * squareWidth).toFloat())
        val numberPosition = getTextDrawPosition(num.toString(), rectF, textPaintImmutable)
        canvas.drawText(num.toString(), numberPosition.x.toFloat(), numberPosition.y.toFloat(), paint)

    }

    private fun setSelectedPosition(selectedPosition: Coordinate) {
        setSelectedPosition(selectedPosition.x, selectedPosition.y)
    }

    private fun setSelectedPosition(indexX: Int, indexY: Int) {
        this.selectedPosition =Coordinate(indexX, indexY)
    }

    private fun paintQuadrant(canvas: Canvas, start: Coordinate) {
        for (i in start.x until start.x + 3) {
            for (j in start.y until start.y + 3) {
                val square = buildSquareAtPosition(j, i, 2)
                canvas.drawRect(square, quadrantPaint!!)
            }
        }
    }

    @JvmOverloads
    fun buildSquareAtPosition(posX: Int, posY: Int, stroke: Int = 0): Rect {
        val startX = posX * squareWidth
        val startY = posY * squareWidth
        return Rect(startX + stroke, startY + stroke, startX + squareWidth - stroke, startY + squareWidth - stroke)
    }


    private fun getTextDrawPosition(text: String, rectF: RectF, paint: Paint?): Coordinate {
        val align = paint!!.textAlign
        val x: Float
        val y: Float
        //x
        if (align == Paint.Align.LEFT) {
            x = rectF.centerX() - paint.measureText(text) / 2
        } else if (align == Paint.Align.CENTER) {
            x = rectF.centerX()
        } else {
            x = rectF.centerX() + paint.measureText(text) / 2
        }
        //y
        val metrics = paint.fontMetrics
        val acent = Math.abs(metrics.ascent)
        val descent = Math.abs(metrics.descent)
        y = rectF.centerY() + (acent - descent) / 2f
        return Coordinate(x.toInt(), y.toInt())
    }


}
