package com.example.amphibians
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.model.Amphibian
import com.example.amphibians.repository.AnimalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val animalRepo: AnimalRepo) : ViewModel() {


    //Retrofit
    private var _amphibian = MutableLiveData<Amphibian>()
    val amphibian: LiveData<Amphibian> = _amphibian


    private val _amphibians = MutableLiveData<List<Amphibian>>()
    val amphibians: LiveData<List<Amphibian>> = _amphibians


    init {
        getApiResponse()
    }

    fun getApiResponse()  {
        viewModelScope.launch {
            try {
                _amphibians.value = animalRepo.getAmphibianList()
                Log.d("AmphibiansResponse","Success")
            }
            catch (e:Exception) {
                Log.d("AmphibiansResponse","Error")
            }
        }
    }


}