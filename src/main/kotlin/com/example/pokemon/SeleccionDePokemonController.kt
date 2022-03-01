package com.example.pokemon

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.io.File
import java.io.IOException

class SeleccionDePokemonController {



    //POKEMON 0,0
    @FXML
    private lateinit var vBox00: VBox

    @FXML
    private lateinit var nombre00: Label

    @FXML
    private lateinit var nivel00: Label

    @FXML
    private lateinit var border00: BorderPane

    @FXML
    private lateinit var pokemon00: ImageView

    @FXML
    private lateinit var genero00: ImageView

    @FXML
    private lateinit var psImage00: ImageView

    @FXML
    private lateinit var vida00: ProgressBar

    @FXML
    private lateinit var ps00: Label

    //Pokemon 1,0
    @FXML
    private lateinit var vBox10: VBox

    @FXML
    private lateinit var nombre10: Label

    @FXML
    private lateinit var nivel10: Label

    @FXML
    private lateinit var border10: BorderPane

    @FXML
    private lateinit var pokemon10: ImageView

    @FXML
    private lateinit var genero10: ImageView

    @FXML
    private lateinit var psImage10: ImageView

    @FXML
    private lateinit var vida10: ProgressBar

    @FXML
    private lateinit var ps10: Label

    //Pokemon 2,0
    @FXML
    private lateinit var vBox20: VBox

    @FXML
    private lateinit var nombre20: Label

    @FXML
    private lateinit var nivel20: Label

    @FXML
    private lateinit var border20: BorderPane

    @FXML
    private lateinit var pokemon20: ImageView

    @FXML
    private lateinit var genero20: ImageView

    @FXML
    private lateinit var psImage20: ImageView

    @FXML
    private lateinit var vida20: ProgressBar

    @FXML
    private lateinit var ps20: Label

    //Pokemon 0,1
    @FXML
    private lateinit var vBox01: VBox

    @FXML
    private lateinit var nombre01: Label

    @FXML
    private lateinit var nivel01: Label

    @FXML
    private lateinit var border01: BorderPane

    @FXML
    private lateinit var pokemon01: ImageView

    @FXML
    private lateinit var genero01: ImageView

    @FXML
    private lateinit var psImage01: ImageView

    @FXML
    private lateinit var vida01: ProgressBar

    @FXML
    private lateinit var ps01: Label

    //Pokemon 1,1
    @FXML
    private lateinit var vBox11: VBox

    @FXML
    private lateinit var nombre11: Label

    @FXML
    private lateinit var nivel11: Label

    @FXML
    private lateinit var border11: BorderPane

    @FXML
    private lateinit var pokemon11: ImageView

    @FXML
    private lateinit var genero11: ImageView

    @FXML
    private lateinit var psImage11: ImageView

    @FXML
    private lateinit var vida11: ProgressBar

    @FXML
    private lateinit var ps11: Label

    //Pokemon 2,1
    @FXML
    private lateinit var vBox21: VBox

    @FXML
    private lateinit var nombre21: Label

    @FXML
    private lateinit var nivel21: Label

    @FXML
    private lateinit var border21: BorderPane

    @FXML
    private lateinit var pokemon21: ImageView

    @FXML
    private lateinit var genero21: ImageView

    @FXML
    private lateinit var psImage21: ImageView

    @FXML
    private lateinit var vida21: ProgressBar

    @FXML
    private lateinit var ps21: Label

    //Continuar
    @FXML
    private lateinit var continuar:Label
    companion object var stage: Stage? =null

    //pokemons
    class InterfazPokemon(var nombre: Label,var nivel: Label,var ps: Label,var imagenPokemon: ImageView,var imagenGenero : ImageView,var vida : ProgressBar,var border: BorderPane,var pokemon: Pokemon)
    var listInterfaces = mutableListOf<InterfazPokemon>()

    @FXML
    fun initialize(){

        listInterfaces = mutableListOf(
            InterfazPokemon(nombre00,nivel00,ps00,pokemon00,genero00,vida00,border00,arraypoke[0]),
            InterfazPokemon(nombre10,nivel10,ps10,pokemon10,genero10,vida10,border10,arraypoke[1]),
            InterfazPokemon(nombre20,nivel20,ps20,pokemon20,genero20,vida20,border20,arraypoke[2]),
            InterfazPokemon(nombre01,nivel01,ps01,pokemon01,genero01,vida01,border01,arraypoke[3]),
            InterfazPokemon(nombre11,nivel11,ps11,pokemon11,genero11,vida11,border11,arraypoke[4]),
            InterfazPokemon(nombre21,nivel21,ps21,pokemon21,genero21,vida21,border21,arraypoke[5]),
        )

        listInterfaces.forEachIndexed { index, interfazPokemon ->
            inicializar(interfazPokemon,index)
        }

        //initialize continuar
        continuar.disableProperty().set(true)
    }

    //Asignaciones  por su array
    fun inicializar(interfazPokemon: InterfazPokemon,i:Int){
        interfazPokemon.nombre.text=arraypoke[i].nombre
        interfazPokemon.nivel.text="Nv "+arraypoke[i].nivel.toString()
        interfazPokemon.ps.text=arraypoke[i].vidaRest.toString() + "/" + arraypoke[i].vidaMax.toString()
        val filePokemon= File(arraypoke[i].image)
        interfazPokemon.imagenPokemon.image=Image(filePokemon.toURI().toString())
        val fileGenero=File(arraypoke[i].genero)
        interfazPokemon.imagenGenero.image=Image(fileGenero.toURI().toString())
        interfazPokemon.vida.progress= arraypoke[i].vidaRest.toDouble()/ arraypoke[i].vidaMax.toDouble()
        if (interfazPokemon.vida.progress<0.25)
            interfazPokemon.vida.style="-fx-accent:red"
        else{
            if (interfazPokemon.vida.progress<0.5)
                interfazPokemon.vida.style="-fx-accent:#ff8929"
        }


    }
    fun styleClicked(interfazPokemon: InterfazPokemon){
        interfazPokemon.nombre.textFill= Color.web("#38e8fc")
        interfazPokemon.nivel.textFill=Color.web("#38e8fc")
        interfazPokemon.ps.textFill=Color.web("#38e8fc")
        interfazPokemon.border.style="-fx-border-color:white; -fx-background-color:#c650c4; -fx-border-width:3"
        interfazPokemon.pokemon.click=true
        if (interfazPokemon.pokemon.vidaRest<=0)
            continuar.disableProperty().set(true)
    }
    fun reset(interfazPokemon: InterfazPokemon){
        interfazPokemon.nombre.textFill= Color.web("white")
        interfazPokemon.nivel.textFill=Color.web("white")
        interfazPokemon.ps.textFill=Color.web("white")
        interfazPokemon.border.style= "-fx-border-color: #47175e; -fx-background-color:#61355e; -fx-border-width:3"
        interfazPokemon.pokemon.click=false

    }


    fun vBoxClicked(posicion:Int){
        listInterfaces.forEach {
            reset(it)
        }
        styleClicked(listInterfaces[posicion])

    }
    //Clicked 00
    @FXML
    fun onVBox00Clicked(){

        arraypoke[0].click=false

        //Continuar
        continuar.disableProperty().set(false)

        vBoxClicked(0)
    }

    //Click 10
    @FXML
    fun onVBox10Clicked(){
        arraypoke[1].click=false
        //Continuar
        continuar.disableProperty().set(false)

        vBoxClicked(1)

    }

    //Click 20
    @FXML
    fun onVBox20Clicked(){
        arraypoke[2].click=false

        //Continuar
        continuar.disableProperty().set(false)

        vBoxClicked(2)

    }

    //Click 01
    @FXML
    fun onVBox01Clicked(){
        arraypoke[3].click=false

        //Continuar
        continuar.disableProperty().set(false)

        vBoxClicked(3)

    }

    //Click 11
    @FXML
    fun onVBox11Clicked(){
        arraypoke[4].click=false

        //Continuar
        continuar.disableProperty().set(false)

        vBoxClicked(4)

    }
    //Click 21
    @FXML
    fun onVBox21Clicked(){
        arraypoke[5].click=false

        //Continuar
        continuar.disableProperty().set(false)

        vBoxClicked(5)

    }


    @FXML
    fun continuarClicked(){

        try {
            if(stage==null) {

            var pokeSelection:PokemonSeleccionadoController
            stage = Stage()
            stage?.isResizable = false
            val loader = FXMLLoader(HelloApplication::class.java.getResource("pokemon_seleccionado.fxml"))
            val scene = Scene(loader.load(), 600.0, 350.0)
            stage?.title = "Pokemon"
            stage?.scene = scene
            stage?.show()

                val controller = loader.getController<PokemonSeleccionadoController>()

                var select: Pokemon

                arraypoke.forEachIndexed { index, pokemon ->
                    println(arraypoke[index].click)
                    if (pokemon.click) {
                        select = arraypoke[index]

                        controller.cargarPokemon(select)
                        controller.enviarDatosMenuSeleccion(this)
                        pokeSelection = PokemonSeleccionadoController()

                    }
                }
            }
        }catch (e: IOException){
            e.printStackTrace()
        }
    }


    fun actualizarEstado(pokemon: Pokemon){
        listInterfaces.forEachIndexed { index, interfazPokemon ->
            if (pokemon.nombre.equals(interfazPokemon.pokemon.nombre)){
                interfazPokemon.ps.text=pokemon.vidaRest.toString() + "/" + pokemon.vidaMax.toString()
                interfazPokemon.vida.progress= pokemon.vidaRest.toDouble()/ pokemon.vidaMax.toDouble()
            if (interfazPokemon.vida.progress<0.25)
                interfazPokemon.vida.style="-fx-accent:red"
            else{
                if (interfazPokemon.vida.progress<0.5)
                    interfazPokemon.vida.style="-fx-accent:#ff8929"
            }
            }
        }
    }

}