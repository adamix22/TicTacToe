package com.example.tictactoe

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.support.v7.app.AlertDialog
import android.support.v7.widget.AlertDialogLayout
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun  ButtonClick(view:View){
     val buttonSelected = view as Button
        var cellId =0
        when(buttonSelected.id){
            R.id.button1 -> cellId=1
            R.id.button2 -> cellId=2
            R.id.button3 -> cellId=3
            R.id.button4 -> cellId=4
            R.id.button5 -> cellId=5
            R.id.button6 -> cellId=6
            R.id.button7 -> cellId=7
            R.id.button8 -> cellId=8
            R.id.button9 -> cellId=9

        }
        //Toast.makeText(this,"ID: $cellId",Toast.LENGTH_SHORT).show()
        playGame(cellId, buttonSelected)

    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
     fun playGame(cellId : Int,buttonSelected : Button){


        if (activePlayer==1){
            buttonSelected.setText("X")
            buttonSelected.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            activePlayer=2
        }
        else
         {
           buttonSelected.setText("0")
            buttonSelected.setBackgroundColor(Color.GREEN)
             player2.add(cellId)
            activePlayer=1
        }
        buttonSelected.isEnabled =false
        checkWinner()

    }

     fun checkWinner(){
        var winner= -1
        // first row
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // second row
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // third row
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // first col
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // second col
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // third col
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        if (winner!= -1){
            if (winner==1){
                Toast.makeText(this,"Player 1 (X) wins the game!",Toast.LENGTH_SHORT).show()
                dialog()

            }
            if (winner==2){
                Toast.makeText(this,"Player 2 (O) wins the game!",Toast.LENGTH_SHORT).show()
                dialog()
            }
        }
    }
    fun dialog(){
        val alertDialog =AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("GAME FINISHED")
        alertDialog.setMessage("Replay Game?")
        alertDialog.setPositiveButton("yes"){ dialog, which ->
            Toast.makeText(this," Started new game",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)


        }
        alertDialog.setNegativeButton("Exit"){dialog, which ->
            Toast.makeText(this," Bye",Toast.LENGTH_SHORT).show()
            finish()

        }
        alertDialog.show()

    }
}
