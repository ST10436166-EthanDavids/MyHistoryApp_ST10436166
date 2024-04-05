package za.ac.iie.myhistoryapp3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    //List of Historical Figures along with the age they died
    enum class HistoricalFigures(val age: Int, val description: String) {
      Figure_1( 52,"Shakespeare died in Stratford-upon-Avon on 23 April 1616 at the age of 52") ,
      Figure_2(55,"Christopher Columbus died of heart failure on May 24 at the age of 55")  ,
      Figure_3(24," Christopher Wallace was an American Rapper who was murdered in a drive by shooting at the age of 24") ,
      Figure_4(90,"Desmond Tutu, an Archbishop and anti apartheid shop in South Africa died in 2021 at the age of 90")  ,
      Figure_5(84,"Isaac Newton passed away in his sleep at the age of 84 as a result of an unknown Death")  ,
      Figure_6(78, "Gandhi was assassinated on the 30 January 1948 in a mansion in Central New Delhi")  ,
      Figure_7(56,"Adolf Hitler died by suicide via a gunshot to the head at the age of 56")  ,
      Figure_8(73,"Charles Darwin was a English Scientist who died at the age of 73")  ,
      Figure_9(48,"Whitney Houston died from a drug related accidental drowning at the age of 48") ,
      Figure_10(33,"Bon Scott was a singer and musician who was born in Scotland and died at the age of 33 in 1980") ,


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting  layout Components
        val editText= findViewById<EditText>(R.id.editAge)
        val btnclick = findViewById<Button>(R.id.btnclick)
        val btnclear = findViewById<Button>(R.id.btnclear)
        val textResult = findViewById<TextView>(R.id.textResult)


        // If user presses the Generate Age Button
        btnclick?.setOnClickListener()
        {
            val Age = editText.text.toString().toInt()
            //Getting the values of the ages in the list of Historical Figures
            if (Age != null && Age in 20..100) {
                val personAge = HistoricalFigures.values().map { it.age }


                val person = when (Age) {

                    in personAge -> {
                        val person = HistoricalFigures.values().find { it.age == Age }
                        listOf("At age907878 $Age: ${person?.description ?: "person"}")
                    }
                    //the map function will transform each enum constant into its corresponding age value
                    //this statement will be run if the Age is one year before the Historical Figures
                    in personAge.map { it - 1 } -> {
                        val event = HistoricalFigures.values().find { it.age == Age + 1 }
                        listOf("Your Age is one year before the historical figure of " +
                                    "${event?.description ?: "person"}"
                        )
                    }

                    //This statement will run id the Age is one year after the historical figure
                    in personAge.map { it - 1 } -> {
                        val event = HistoricalFigures.values().find { it.age == Age - 1 }
                        listOf("Your Age is one year after the historical figure of " +
                                    "${event?.description ?: " person"}")


                    }
                    //this statement will be run if the age is not the same class to the year
                    else -> listOf("No historical figure found for $Age.")

                }
                textResult.text = person.joinToString("\n")

            } else {


                textResult.text = "No person has been found from the input of your Age"

            }

        }

        // if user presses the Clear button
        btnclear?.setOnClickListener() {
            editText.text.clear()
            textResult.text = ""
        }

        }
    }













