package com.example.di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //code start here...
        car.startTheCar()
    }
}

class Car(val engine: Engine, val number: Int){

    fun startTheCar(){
        engine.startTheEngine()
        Log.d("IAmIronMan", "${number} car is started")
    }
}

class Engine @Inject constructor(
    val piston: Piston
){
    fun startTheEngine(){
        piston.startThePistion()
        Log.d("IAmIronMan", "start the engine")
    }
}

class Piston(val numberOfPistion: NumberOfPistion){
    fun startThePistion(){
        numberOfPistion.pistonNumber()
        Log.d("IAmIronMan", "start the piston")
    }
}

interface NumberOfPistion{
    fun pistonNumber()
}

class NumberOfPistionImpl(): NumberOfPistion{
    override fun pistonNumber() {
        Log.d("IAmIronMan", "piston number is 4")
    }
}