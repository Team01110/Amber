package com.example.amber.exseption

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(msg:String){
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}
fun Fragment.showToast(msg:Int){
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}
fun Fragment.showLog(msg:String){
    Log.d("ololo", msg)
}