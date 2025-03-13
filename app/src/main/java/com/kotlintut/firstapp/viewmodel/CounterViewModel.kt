package com.kotlintut.firstapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = mutableIntStateOf(0)
    val count: State<Int> = _count

    fun up() {
        _count.intValue++
    }

    fun down() {
        if (_count.intValue > 0) _count.intValue--
    }

    fun upByFive() {
        _count.intValue += 5
    }
}