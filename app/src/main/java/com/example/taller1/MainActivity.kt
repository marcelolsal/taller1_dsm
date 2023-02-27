package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater
import android.view.MenuItem;
import android.view.View
import android.widget.*

lateinit var nombre: EditText
lateinit var nota1: EditText
lateinit var nota2: EditText
lateinit var nota3: EditText
lateinit var nota4: EditText
lateinit var nota5: EditText
lateinit var resultado: TextView
lateinit var salario: EditText
var radioGroup: RadioGroup? = null
lateinit var radioButton: RadioButton
lateinit var valor1: EditText
lateinit var valor2: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.item1 -> {
                setContentView(R.layout.grade_calculator)
            }
            R.id.item2 -> {
                setContentView(R.layout.salary_calculator)
            }
            R.id.item3 -> {
                setContentView(R.layout.basic_calculator)
            }
        }
        return super.onOptionsItemSelected(item);
    }
    fun CalculateGrade (view: View){
        nombre = findViewById(R.id.TxtNombre)
        nota1 = findViewById(R.id.TxtNota1)
        nota2 = findViewById(R.id.TxtNota2)
        nota3 = findViewById(R.id.TxtNota3)
        nota4 = findViewById(R.id.TxtNota4)
        nota5 = findViewById(R.id.TxtNota5)
        resultado = findViewById(R.id.lblResultado)
        var nombreUsuario: String = nombre.text.toString()
        var promedio: Float = (nota1.text.toString().toFloat()+nota2.text.toString().toFloat()+nota3.text.toString().toFloat()+nota4.text.toString().toFloat()+nota5.text.toString().toFloat())/5
        var aprobado: String = "Aprovado";
        if(promedio<6){
            aprobado = "Reprobado";
        }
        resultado.setText("El Alumno: "+nombreUsuario+"\nObtubo una nota de: "+promedio.toString()+"\nPor lo que el almuno esta: "+aprobado)
    }
    fun CalculateSalary (view: View){
        nombre = findViewById(R.id.TxtNombre)
        salario = findViewById(R.id.TxtSalario)
        resultado = findViewById(R.id.lblResultado)
        var nombreUsuario: String = nombre.text.toString()
        var deduccions: Double = (salario.text.toString().toFloat()*0.03)+(salario.text.toString().toFloat()*0.04)+(salario.text.toString().toFloat()*0.05);
        var salarioNeto: Double = salario.text.toString().toFloat()-deduccions;
        resultado.setText("El Obrero: "+nombreUsuario+"\nTiene un salario neto de: "+salarioNeto.toString());
    }
    fun CalculateBasic (view: View){
        valor1 = findViewById(R.id.TxtNum1)
        valor2 = findViewById(R.id.TxtNum2)
        radioGroup = findViewById(R.id.radioGroup1)
        resultado = findViewById(R.id.lblResultado)
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId
        radioButton = findViewById(selectedOption)
        var operacion: String = "";
        when(radioButton.text.toString()){
            "Suma" -> {
                operacion= (valor1.text.toString().toDouble()+valor2.text.toString().toDouble()).toString();
            }
            "Resta" -> {
                operacion= (valor1.text.toString().toDouble()-valor2.text.toString().toDouble()).toString();
            }
            "Multiplicacion" -> {
                operacion= (valor1.text.toString().toDouble()*valor2.text.toString().toDouble()).toString();
            }
            "Division" -> {
                if (valor2.text.toString().toDouble()!=0.0){
                    operacion= (valor1.text.toString().toDouble()/valor2.text.toString().toDouble()).toString();
                } else {
                    operacion= "INF";
                }
            }
        }
        resultado.setText("El resultado es: "+operacion);
    }

}