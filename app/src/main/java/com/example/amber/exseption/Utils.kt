package com.example.amber.exseption

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.ShowTost(msg:String){
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}
fun Fragment.ShowTost(msg:Int){
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}