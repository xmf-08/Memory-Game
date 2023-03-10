package com.example.memorygame

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.image_default
import kotlinx.android.synthetic.main.activity_main2.image_default2
import kotlinx.android.synthetic.main.activity_main2.image_default3
import kotlinx.android.synthetic.main.activity_main2.image_default4
import kotlinx.android.synthetic.main.activity_main2.image_default5
import kotlinx.android.synthetic.main.activity_main2.image_default6
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    //Arraylist malumotlar markazi
    var listImageOchiqYopiq = arrayOf(false,false,false,false,false,false,false,false,false,false,false,false)
    //..........//
    val imageIndex = arrayOfNulls<Int>(3)
    var rasmId = arrayOfNulls<Int>(3)
    var ochiqRasm = 0
    var animationDoing = false

    //OnCreat Projekt boshlanishi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //Image ni Aniqlash
        fun imageViewAniqlash(index:Int?): ImageView {
            var imageView: ImageView? = null
            when (index){
                0-> imageView = image_default
                1-> imageView = image_default2
                2-> imageView = image_default3
                3-> imageView = image_default4
                4-> imageView = image_default5
                5-> imageView = image_default6
                6-> imageView = image_default7
                7-> imageView = image_default8
                8-> imageView = image_default9
                9-> imageView = image_default10
                10-> imageView = image_default11
                11-> imageView = image_default12
            }
            return imageView!!
        }
        //.........//

        //Animatsia yopilishi
        fun animationYopilishi(imageView: ImageView, rasm:Int, index:Int?){
            var animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
            imageView.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener{

                override fun onAnimationStart(animation: Animation?) {animationDoing = true}

                override fun onAnimationEnd(animation: Animation?) {
                    val animation2 = AnimationUtils.loadAnimation(this@MainActivity3, R.anim.anim_2)
                    imageView.startAnimation(animation2)
                    imageView.setImageResource(R.drawable.question)
                    animation2.setAnimationListener(object : Animation.AnimationListener{
                        override fun onAnimationStart(p0: Animation?) {

                        }

                        override fun onAnimationEnd(p0: Animation?) {
                            animationDoing = false
                        }

                        override fun onAnimationRepeat(p0: Animation?) {

                        }
                    })
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
            //Animatsia yopilishi = false
            listImageOchiqYopiq[index!!] = false
            //.........//
            ochiqRasm--
        }
        //...........//

        //Animatsia ochilishi
        fun animationOchilishi(imageView: ImageView, rasm:Int, index: Int){
            var animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
            imageView.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener{

                override fun onAnimationStart(animation: Animation?) {animationDoing = true}

                override fun onAnimationEnd(animation: Animation?) {
                    val animation2 = AnimationUtils.loadAnimation(this@MainActivity3, R.anim.anim_2)
                    imageView.startAnimation(animation2)
                    imageView.setImageResource(rasm)
                    animation2.setAnimationListener(object : Animation.AnimationListener{
                        override fun onAnimationStart(p0: Animation?) {

                        }

                        override fun onAnimationEnd(p0: Animation?) {
                            //Rasm ochilishi = true
                            listImageOchiqYopiq[index] = true
                            //.......//
                            //Rasm ochilibYopilishi
                            imageIndex[ochiqRasm] = index
                            rasmId[ochiqRasm] = rasm
                            ochiqRasm++

                            if (ochiqRasm == 3){
                                if (rasmId[0] == rasmId[1] && rasmId[0] == rasmId[2] && rasmId[1] == rasmId[2]){
                                    imageViewAniqlash(imageIndex[0]).visibility = View.INVISIBLE
                                    ochiqRasm--
                                    imageViewAniqlash(imageIndex[1]).visibility = View.INVISIBLE
                                    ochiqRasm--
                                    imageViewAniqlash(imageIndex[2]).visibility = View.INVISIBLE
                                    ochiqRasm--
                                }else{
                                    animationYopilishi(imageViewAniqlash(imageIndex[0]), -1, imageIndex[0])
                                    animationYopilishi(imageViewAniqlash(imageIndex[1]), -1, imageIndex[1])
                                    animationYopilishi(imageViewAniqlash(imageIndex[2]), -1, imageIndex[2])
                                }
                            }
                            animationDoing = false
                            //.......//
                        }

                        override fun onAnimationRepeat(p0: Animation?) {

                        }
                    })
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }
        //........//

        //Animatsia bosilishi
        fun imageClick(imageView: ImageView, rasm:Int, index: Int){
            if (!animationDoing) {
                if (listImageOchiqYopiq[index] == false) {
                    animationOchilishi(imageView, rasm, index)
                } else {
                    animationYopilishi(imageView, rasm, index)
                }
            }
        }
        //..........//

        //Animatsialarni chaqirib qoyilishi
        image_default.setOnClickListener{ imageClick(image_default, R.drawable.barcelona, 0) }

        image_default2.setOnClickListener{ imageClick(image_default2, R.drawable.realmadrid, 1) }

        image_default3.setOnClickListener{ imageClick(image_default3, R.drawable.chelsea, 2) }

        image_default4.setOnClickListener{ imageClick(image_default4, R.drawable.liverpool, 3) }

        image_default5.setOnClickListener{ imageClick(image_default5, R.drawable.chelsea, 4) }

        image_default6.setOnClickListener{ imageClick(image_default6, R.drawable.liverpool, 5) }

        image_default7.setOnClickListener{ imageClick(image_default7, R.drawable.barcelona, 6) }

        image_default8.setOnClickListener{ imageClick(image_default8, R.drawable.realmadrid, 7) }

        image_default9.setOnClickListener{ imageClick(image_default9, R.drawable.liverpool, 8) }

        image_default10.setOnClickListener{ imageClick(image_default10, R.drawable.barcelona, 9) }

        image_default11.setOnClickListener{ imageClick(image_default11, R.drawable.chelsea, 10) }

        image_default12.setOnClickListener{ imageClick(image_default12, R.drawable.realmadrid, 11) }
        //.........//

    }
    //.........//
}