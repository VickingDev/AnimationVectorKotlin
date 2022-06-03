package com.vickingdev.animationkotlin.views.activities

import android.annotation.SuppressLint
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.vickingdev.animationkotlin.R
import com.vickingdev.animationkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    //image sequence as movie
    private lateinit var frameAnimation: AnimationDrawable

    private var isConnect: Boolean = false


    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //By simple action on a different button
//        binding.btStartStop.setOnClickListener {
//
//            //image sequence as movie
//            if (frameAnimation.isRunning) {
//                frameAnimation.stop()
//            } else {
//                frameAnimation.start()
//            }
//
//
//            //Vector displacement
//            if (isConnect) {
//                checkToCloseOnBattery()
//                checkToCloseOnIllustratorImage()
//            } else {
//                closeToCheckOnBattery()
//                closeToCheckOnIllustratorImage()
//            }
//
//            isConnect = !isConnect
//        }

        //By action directly on the image icon
        binding.imAnimation.setOnClickListener{

            //image sequence as movie
            if (frameAnimation.isRunning) {
                frameAnimation.stop()
            } else {
                frameAnimation.start()
            }

            //Vector displacement
            if (isConnect) {
                checkToCloseOnBattery()
                checkToCloseOnIllustratorImage()
            } else {
                closeToCheckOnBattery()
                closeToCheckOnIllustratorImage()
            }

            animateView(binding.imAnimation)

            isConnect = !isConnect
        }

    }

    //By action directly on the image icon
    private fun animateView(view: ImageView) {
        when (val drawable = view.drawable) {
            is AnimatedVectorDrawableCompat -> {
               drawable.start()
            }
            is AnimatedVectorDrawable -> {
                drawable.start()
            }
        }
    }

    //Vector displacement
    private fun checkToCloseOnBattery() {
        binding.imAnimation.setImageResource(R.drawable.avd_check_to_close)
        val avdCheckToClose: AnimatedVectorDrawable =
            binding.imAnimation.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    //Vector displacement
    private fun closeToCheckOnBattery() {
        binding.imAnimation.setImageResource(R.drawable.avd_close_to_check)
        val avdCheckToClose: AnimatedVectorDrawable =
            binding.imAnimation.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    //Vector displacement
    private fun checkToCloseOnIllustratorImage() {
        binding.imNewTest.setImageResource(R.drawable.avd_check_to_close)
        val avdCheckToClose: AnimatedVectorDrawable =
            binding.imNewTest.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }

    //Vector displacement
    private fun closeToCheckOnIllustratorImage() {
        binding.imNewTest.setImageResource(R.drawable.avd_close_to_check)
        val avdCheckToClose: AnimatedVectorDrawable =
            binding.imNewTest.drawable as AnimatedVectorDrawable
        avdCheckToClose.start()
    }


    override fun onStart() {
        super.onStart()


        //place at first plan this icon
        binding.imNewTest.setImageResource(R.drawable.avd_check_to_close)

        //place at second plan this icon in background
        binding.imAnimation.setBackgroundResource(R.drawable.battery_animation_list)
        frameAnimation = binding.imAnimation.background as AnimationDrawable
        frameAnimation.start()

        //place this image test from illustrator in background
        binding.imNewTest.setBackgroundResource(R.drawable.ic_testcocosay)

    }

}