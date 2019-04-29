package com.dawson.threegearswitchbutton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), ThirdSwitchSeekBar.SeekTouchListener {
    private lateinit var seekBar: ThirdSwitchSeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_switch)
        seekBar = findViewById(R.id.third_switch_seekBar)
        seekBar.setSeekTouchListenr(this)
        seekBar.thumb = resources.getDrawable(R.drawable.red)
    }

    /**
     * 滑到第一档
     * @param seekBar
     */
    override fun touchTop(seekBar: SeekBar) {
        seekBar.thumb = resources.getDrawable(R.drawable.red)

    }

    /**
     * 滑到第二档
     * @param seekBar
     */
    override fun touchMiddle(seekBar: SeekBar) {
        seekBar.thumb = resources.getDrawable(R.drawable.green)

    }

    /**
     * 滑到第三档
     * @param seekBar
     */
    override fun touchEnd(seekBar: SeekBar) {
        seekBar.thumb = resources.getDrawable(R.drawable.blue)
    }
}

