package es.juliogtrenard.calculadorakotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.juliogtrenard.calculadorakotlin.databinding.ActivityMainBinding

/**
 * Actividad principal de la aplicación. Representa la actividad principal de la aplicación.
 *
 * @author [Julio González]
 * @version [1.0]
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    /**
     * Primer número de la operación
     */
    private var primerNum = 0.0

    /**
     * Segundo número de la operación
     */
    private var segundoNum = 0.0

    /**
     * Operación que se va a realizar
     */
    private var operacion: String? = null

    /**
     * Hace referencia a los elementos del XML sin instanciarlos antes
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * Método llamado cuando se crea la actividad.
     *
     * Se inicializan los componentes de la interfaz de usuario
     * y se establecen las acciones para la interacción del usuario.
     *
     * @param savedInstanceState Estado de la instancia anterior, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Asociamos la raiz del xml a la clase
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operacion = null //Empezar sin ninguna operacion

        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btnMas.setOnClickListener(this)
        binding.btnMenos.setOnClickListener(this)
        binding.btnMultiplicar.setOnClickListener(this)
        binding.btnDivision.setOnClickListener(this)
        binding.btnComa.setOnClickListener(this)
        binding.btnLimpiar.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
    }

    /**
     * Escuchador para cada botón
     */
    override fun onClick(view: View) {
        when (view) {
            binding.btn0 -> {
                onNumberPressed("0")
            }
            binding.btn1 -> {
                onNumberPressed("1")
            }
            binding.btn2 -> {
                onNumberPressed("2")
            }
            binding.btn3 -> {
                onNumberPressed("3")
            }
            binding.btn4 -> {
                onNumberPressed("4")
            }
            binding.btn5 -> {
                onNumberPressed("5")
            }
            binding.btn6 -> {
                onNumberPressed("6")
            }
            binding.btn7 -> {
                onNumberPressed("7")
            }
            binding.btn8 -> {
                onNumberPressed("8")
            }
            binding.btn9 -> {
                onNumberPressed("9")
            }
            binding.btnMas -> {
                onNumberPressed("+")
            }
            binding.btnMenos -> {
                onNumberPressed("-")
            }
            binding.btnComa -> {
                onNumberPressed(",")
            }
            binding.btnMultiplicar -> {
                onNumberPressed("*")
            }
            binding.btnDivision -> {
                onNumberPressed("/")
            }
        }
    }

    /**
     * Comprueba el tipo de operación que realizamos
     */
    private fun onNumberPressed(num: String) {
        renderScreen(num)
        checkOperation()
    }

    /**
     * Renderizar los numeros en pantalla
     */
    private fun renderScreen(num: String) {
        val result: String = if (binding.screen.text == "0" && num != ",")
            num
        else
            "${binding.screen.text}$num"

        binding.screen.text = result
    }

    /**
     * Mira si hay una operación o no. Si se pulsa la operacion lo nuevo
     * va al segundo operador, de lo contrario al primero
     */
    private fun checkOperation() {
        if (operacion == null)
            primerNum = binding.screen.text.toString().toDouble()
        else
            segundoNum = binding.screen.text.toString().toDouble()
    }
}