package ni.edu.uca.my_uca.ui.see

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is See Fragment"
    }
    val text: LiveData<String> = _text
}