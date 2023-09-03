package matias.peralta.sameono

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.verify

class NumberComparisonViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockObserver: Observer<String>

    private lateinit var viewModel: NumberComparisonViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = NumberComparisonViewModel()
        viewModel.comparisonResult.observeForever(mockObserver)
    }

    @Test
    fun testCompareNumbers_equal() {
        viewModel.compareNumbers(5, 5)
        // Verifica que la observación se actualiza correctamente
        verify(mockObserver).onChanged("Los números son iguales")
    }

    @Test
    fun testCompareNumbers_notEqual() {
        viewModel.compareNumbers(3, 7)
        // Verifica que la observación se actualiza correctamente
        verify(mockObserver).onChanged("Los números no son iguales")
    }
}
