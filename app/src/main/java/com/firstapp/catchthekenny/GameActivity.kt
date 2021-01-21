package com.firstapp.catchthekenny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class GameActivity : AppCompatActivity() {

    var score = 0
    var imageArray = ArrayList<ImageView>()

    var handler = Handler()
    var runnable = Runnable {  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        score = 0
        var tvTimer = findViewById<TextView>(R.id.tvTimer)

        var ivKenny1 = findViewById<ImageView>(R.id.ivKenny1)
        var ivKenny2 = findViewById<ImageView>(R.id.ivKenny2)
        var ivKenny3 = findViewById<ImageView>(R.id.ivKenny3)
        var ivKenny4 = findViewById<ImageView>(R.id.ivKenny4)
        var ivKenny5 = findViewById<ImageView>(R.id.ivKenny5)
        var ivKenny6 = findViewById<ImageView>(R.id.ivKenny6)
        var ivKenny7 = findViewById<ImageView>(R.id.ivKenny7)
        var ivKenny8 = findViewById<ImageView>(R.id.ivKenny8)
        var ivKenny9 = findViewById<ImageView>(R.id.ivKenny9)
        var ivKenny10 = findViewById<ImageView>(R.id.ivKenny10)
        var ivKenny11 = findViewById<ImageView>(R.id.ivKenny11)
        var ivKenny12 = findViewById<ImageView>(R.id.ivKenny12)
        var ivKenny13 = findViewById<ImageView>(R.id.ivKenny13)
        var ivKenny14 = findViewById<ImageView>(R.id.ivKenny14)
        var ivKenny15 = findViewById<ImageView>(R.id.ivKenny15)
        var ivKenny16 = findViewById<ImageView>(R.id.ivKenny16)
        var ivKenny17 = findViewById<ImageView>(R.id.ivKenny17)
        var ivKenny18 = findViewById<ImageView>(R.id.ivKenny18)
        var ivKenny19 = findViewById<ImageView>(R.id.ivKenny19)
        var ivKenny20 = findViewById<ImageView>(R.id.ivKenny20)

        val alert = AlertDialog.Builder(this)
        alert.setTitle("GAME OVER")
        alert.setMessage("Would you like to play again?")
        alert.setPositiveButton("Yes") { x,y ->
            startActivity(Intent(this, MainActivity::class.java))
        }
        alert.setNegativeButton("No"){ x,y ->
            finishAffinity()
        }


        imageArray = arrayListOf(ivKenny1,ivKenny2,ivKenny3,ivKenny4,ivKenny5,ivKenny6,ivKenny7,ivKenny8,ivKenny9,ivKenny10,ivKenny11,ivKenny12,ivKenny13,ivKenny14,ivKenny15,ivKenny16,ivKenny17,ivKenny18,ivKenny19,ivKenny20)

        hiddenImages()

        object : CountDownTimer(17000,1000){
            override fun onTick(millisUntilFinished: Long) {
                tvTimer.text = "Time: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                tvTimer.text = "TIME UP"
                tvTimer.setTextColor(resources.getColor(R.color.red))

                handler.removeCallbacks(runnable)
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                alert.show()
            }

        }.start()
    }

    fun hiddenImages(){

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val index = random.nextInt(20-0)
                imageArray[index].visibility = View.VISIBLE
                handler.postDelayed(runnable,700)
            }
        }

        handler.post(runnable)
    }

    fun increaseScore(view: View){
        var tvScore = findViewById<TextView>(R.id.tvScore)
        score++

        tvScore.text = "Score: $score"
    }

}