package matias.peralta.sameono




import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberComparisonViewModel : ViewModel() {
    private val _comparisonResult = MutableLiveData<String>()
    val comparisonResult: LiveData<String> = _comparisonResult

    fun compareNumbers(num1: Int, num2: Int) {
        _comparisonResult.value = if (num1 != num2) {
            "Los números no son iguales"
        } else {
            "Los números son iguales"
        }
    }
}
