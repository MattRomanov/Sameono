package matias.peralta.sameono

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        compareButton = findViewById(R.id.compareButton)
        resultText = findViewById(R.id.resultText)

        compareButton.setOnClickListener {
            val num1 = editText1.text.toString().toIntOrNull()
            val num2 = editText2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                if (num1 > num2) {
                    resultText.text = "$num1 es mayor que $num2"
                } else if (num1 < num2) {
                    resultText.text = "$num2 es mayor que $num1"
                } else {
                    resultText.text = "Los números son iguales"
                }


            } else {
                resultText.text = "Ingrese números válidos en ambos campos"
            }
        }
    }
}
