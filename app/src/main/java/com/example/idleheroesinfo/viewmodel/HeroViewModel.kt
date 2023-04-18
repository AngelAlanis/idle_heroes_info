package com.example.idleheroesinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idleheroesinfo.model.Hero

class HeroViewModel : ViewModel() {

    val heroModel = MutableLiveData<Hero>()


}