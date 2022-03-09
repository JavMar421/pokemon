package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.ImageView

class MochilaController() {

    @FXML
    private lateinit var antidoto:ImageView
    @FXML
    private lateinit var antiquemar:ImageView
    @FXML
    private lateinit var descongelante:ImageView




    @FXML
    fun antidotoclicked(){
        val id=1
        alertaCura(id)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()
    }
    @FXML
    fun antiquemarclicked(){
        val id=2
        alertaCura(id)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()
    }
    @FXML
    fun descongelanteclicked(){
        val id=3
        alertaCura(id)
        pokemonSeleccionadoController.cargarPokemon(pokeselec)
        pokemonSeleccionadoController.actualizar()

    }


    fun alertaCura(id: Int){
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.headerText = null
        alert.title = "Curar Pokemon"
        println("$id <-pocion  estado-> ${pokeselec.estado}")
        if(id==pokeselec.estado){
            alert.contentText = "Pokemon Curado con Exito"
            pokeselec.estado=0; pokeselec.fotoestado=" "
        }
        else{
            alert.contentText = "El objeto no tiene efecto"}
        val action = alert.showAndWait()
    }



    var pokemonSeleccionadoController=PokemonSeleccionadoController()

    var pokeselec=Pokemon("Arcanine","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1_combate.gif","")

    fun enviarDatosMochila(seleccionMohcilaController: PokemonSeleccionadoController){
        this.pokemonSeleccionadoController=seleccionMohcilaController
    }

    fun cargarPokemonMochila(pokemon :Pokemon) {
        pokemon.click=false
        pokeselec = pokemon
    }

}