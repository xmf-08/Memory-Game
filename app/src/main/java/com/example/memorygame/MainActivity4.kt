package com.example.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main2.image_default
import kotlinx.android.synthetic.main.activity_main2.image_default2
import kotlinx.android.synthetic.main.activity_main2.image_default3
import kotlinx.android.synthetic.main.activity_main2.image_default4
import kotlinx.android.synthetic.main.activity_main2.image_default5
import kotlinx.android.synthetic.main.activity_main2.image_default6
import kotlinx.android.synthetic.main.activity_main3.image_default10
import kotlinx.android.synthetic.main.activity_main3.image_default11
import kotlinx.android.synthetic.main.activity_main3.image_default12
import kotlinx.android.synthetic.main.activity_main3.image_default7
import kotlinx.android.synthetic.main.activity_main3.image_default8
import kotlinx.android.synthetic.main.activity_main3.image_default9
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    //Arraylist malumotlar markazi
    var listImageOchiqYopiq = arrayOf(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false)
    //..........//
    val imageIndex = arrayOfNulls<Int>(4)
    var rasmId = arrayOfNulls<Int>(4)
    var ochiqRasm = 0
    var animationDoing = false

    //OnCreat Projekt boshlanishi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

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
                12-> imageView = image_default13
                13-> imageView = image_default14
                14-> imageView = image_default15
                15-> imageView = image_default16
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
                    val animation2 = AnimationUtils.loadAnimation(this@MainActivity4, R.anim.anim_2)
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
                    val animation2 = AnimationUtils.loadAnimation(this@MainActivity4, R.anim.anim_2)
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

                                if (ochiqRasm == 4) {
                                    if (rasmId[0] == rasmId[1] && rasmId[0] == rasmId[2] && rasmId[0] == rasmId[3] &&
                                        rasmId[1] == rasmId[2] && rasmId[1] == rasmId[3] &&
                                        rasmId[2] == rasmId[3]
                                    ) {
                                        imageViewAniqlash(imageIndex[0]).visibility = View.INVISIBLE
                                        ochiqRasm--
                                        imageViewAniqlash(imageIndex[1]).visibility = View.INVISIBLE
                                        ochiqRasm--
                                        imageViewAniqlash(imageIndex[2]).visibility = View.INVISIBLE
                                        ochiqRasm--
                                        imageViewAniqlash(imageIndex[3]).visibility = View.INVISIBLE
                                        ochiqRasm--
                                    } else {
                                        animationYopilishi(
                                            imageViewAniqlash(imageIndex[0]),
                                            -1,
                                            imageIndex[0]
                                        )
                                        animationYopilishi(
                                            imageViewAniqlash(imageIndex[1]),
                                            -1,
                                            imageIndex[1]
                                        )
                                        animationYopilishi(
                                            imageViewAniqlash(imageIndex[2]),
                                            -1,
                                            imageIndex[2]
                                        )
                                        animationYopilishi(
                                            imageViewAniqlash(imageIndex[3]),
                                            -1,
                                            imageIndex[3]
                                        )
                                    }
                                }
                                animationDoing = false
                                //.......//
                        }

                        override fun onAnimationRepeat(p0: Animation?) {}
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
        image_default.setOnClickListener{ imageClick(image_default, R.drawable.messi1, 0) }

        image_default2.setOnClickListener{ imageClick(image_default2, R.drawable.cristiano, 1) }

        image_default3.setOnClickListener{ imageClick(image_default3, R.drawable.suarez, 2) }

        image_default4.setOnClickListener{ imageClick(image_default4, R.drawable.salah, 3) }

        image_default5.setOnClickListener{ imageClick(image_default5, R.drawable.suarez, 4) }

        image_default6.setOnClickListener{ imageClick(image_default6, R.drawable.salah, 5) }

        image_default7.setOnClickListener{ imageClick(image_default7, R.drawable.messi1, 6) }

        image_default8.setOnClickListener{ imageClick(image_default8, R.drawable.cristiano, 7) }

        image_default9.setOnClickListener{ imageClick(image_default9, R.drawable.salah, 8) }

        image_default10.setOnClickListener{ imageClick(image_default10, R.drawable.messi1, 9) }

        image_default11.setOnClickListener{ imageClick(image_default11, R.drawable.suarez, 10) }

        image_default12.setOnClickListener{ imageClick(image_default12, R.drawable.cristiano, 11) }

        image_default13.setOnClickListener{ imageClick(image_default13, R.drawable.cristiano, 12) }

        image_default14.setOnClickListener{ imageClick(image_default14, R.drawable.salah, 13) }

        image_default15.setOnClickListener{ imageClick(image_default15, R.drawable.messi1, 14) }

        image_default16.setOnClickListener{ imageClick(image_default16, R.drawable.suarez, 15) }

        //.........//

    }
    //.........//
}