package com.example.animation

import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.lifecycle.ViewModelProvider
import com.example.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    private var countDownTimer= object:CountDownTimer(26000,1000) {

        override fun onTick(millisUntilFinished: Long) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,BlankFragment(viewModel.alphabet,viewModel.colors,viewModel.position)).commit()
                viewModel.position++
            }

        }

        override fun onFinish() {
             viewModel.position=0
            if (viewModel.isPeriodic) {
                    this.start()
                }
        }
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.colors.addAll(arrayListOf(R.color.yellow,R.color.orange,R.color.keppel,
            R.color.orange_clear,R.color.green,R.color.turquoise,R.color.green_see,
        R.color.peter,R.color.emerald,R.color.spiro,R.color.orchid,
            R.color.pine,R.color.honey))
        viewModel.colors+=viewModel.colors


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,BlankFragment(viewModel.alphabet,viewModel.colors,viewModel.position)).commit()
        }

        binding.start.setOnClickListener {
            viewModel.colors.shuffle()
            viewModel.alphabet.shuffle()
            if (viewModel.isCountDownTimerOn) return@setOnClickListener
            viewModel.isPeriodic=true
            viewModel.isCountDownTimerOn=true
            countDownTimer.start()
        }

        binding.stop.setOnClickListener {
            viewModel.isPeriodic=false
            viewModel.isCountDownTimerOn=false
            countDownTimer.cancel()
            viewModel.position=0

        }



    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.isCountDownTimerOn=false
        viewModel.isPeriodic=false
        countDownTimer.cancel()
        viewModel.position=0

    }

    override fun onStop() {

        super.onStop()
        viewModel.isCountDownTimerOn=false
        viewModel.isPeriodic=false
        countDownTimer.cancel()
        viewModel.position=0
    }
}