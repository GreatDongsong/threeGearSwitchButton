package com.dawson.threegearswitchbutton

import android.content.Context
import android.util.AttributeSet
import android.widget.SeekBar

class ThirdSwitchSeekBar : SeekBar, SeekBar.OnSeekBarChangeListener {
    private var touchListener: SeekTouchListener? = null

    /**
     * 新的Progress值,初始值是5 为了解决左右显示不全问题
     */
    private var newProgress = 5

    constructor(context: Context) : super(context) {
        setOnSeekBarChangeListener(this)
        progress = 5//三挡开关,为了解决thumb显示不全，所以设为5
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setOnSeekBarChangeListener(this)
        progress = 5
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setOnSeekBarChangeListener(this)
        progress = 5
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        newProgress = progress

    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {
        if (newProgress < 30) {//如果progress<25,因为左右缩进了5%,所以加了5%,为30%则滑到第一档
            newProgress = 5
            progress = 5
            if (touchListener != null) {
                touchListener!!.touchTop(seekBar)
            }

        } else if (newProgress >= 70) {//如果progress>75,因为左右缩进了5%,所以减了5%,为70%则滑到第三档
            newProgress = 95
            progress = 95
            if (touchListener != null) {
                touchListener!!.touchEnd(seekBar)
            }

        } else {//到中档
            newProgress = 50
            progress = 50
            if (touchListener != null) {
                touchListener!!.touchMiddle(seekBar)
            }
        }
    }

    interface SeekTouchListener {
        fun touchTop(seekBar: SeekBar)

        fun touchMiddle(seekBar: SeekBar)

        fun touchEnd(seekBar: SeekBar)

    }


    fun setSeekTouchListenr(touchListenr: SeekTouchListener) {
        this.touchListener = touchListenr

    }
}