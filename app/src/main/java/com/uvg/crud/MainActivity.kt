package com.uvg.crud

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador(
        { clickListener -> showItemClick(clickListener)}
        ,{ clickListener -> onItemLongClicked(clickListener)}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")*/

        //val  adaptador = Adaptador(items)


        val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")


        adaptador.setItems(items)


        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador

        Agregar.setOnClickListener(){
            var nuevo:String=""
            nuevo=generador()
            items.add(nuevo)
            adaptador.setItems(items)
        }
    }

    fun showItemClick(position: Int){
        //val item = adaptador.getItem(position)
        //Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
        adaptador.deleteItem(position)
    }

    fun onItemLongClicked(position: Int){
        adaptador.updateItem(position,"Actualizado")

    }

    //generador pequeño de texto al azar
    fun generador(): String {
        val x = arrayOf(
            "texto al azar 1",
            "texto al azar 2",
            "texto al azar 3",
            "texto al azar 4",
            "texto al azar 5",
            "texto al azar 6",
            "texto al azar 7",
        )
        val rand = Random()

        val n: Int = rand.nextInt(7)
        val z = x[n]

        return z
    }
}