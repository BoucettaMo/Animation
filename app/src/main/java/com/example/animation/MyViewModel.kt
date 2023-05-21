package com.example.animation

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
     val alphabet= arrayListOf("🐶","🐱","🐭","🐹","🐰","🦊","🐻","🐼","🐻‍","🐯","🦁","🐮","🐷","🐽","🐸","🐵"
        ,"🙈","🙉","🙊","🦆","🐔","🐧","🐦","🐤","🐣","🦄")
     var colors= mutableListOf<Int>()
     var position = 0
     var isPeriodic=true
     var isCountDownTimerOn=false

}