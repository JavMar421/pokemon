package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import java.io.File
import java.util.*
import kotlin.random.Random
import kotlin.system.exitProcess

class PokemonSeleccionadoController() {
    @FXML
    private lateinit var imagePokeSelect:ImageView
    @FXML
    private lateinit var imagePokeEnemy:ImageView
    @FXML
    private lateinit var nombreAtacante:Label
    @FXML
    private lateinit var progressAtacante: ProgressBar
    @FXML
    private lateinit var borderAtacante: BorderPane
    @FXML
    private lateinit var nivelAtacante: Label
    @FXML
    private lateinit var borderEnemy: BorderPane
    @FXML
    private lateinit var progressEnemy: ProgressBar
    @FXML
    private lateinit var nivelEnemy: Label
    @FXML
    private lateinit var nombreEnemy: Label
    @FXML
    private  lateinit var psAtacante: Label
    @FXML
    private lateinit var psEnemy: Label
    @FXML
    private lateinit var ataqueMenu:BorderPane
    @FXML
    private lateinit var atacarLabel: Label
    @FXML
    private lateinit var ataqueSeguro: Label
    @FXML
    private lateinit var ataqueArriesgado: Label
    @FXML
    private lateinit var ataqueMuyArriesgado: Label
    @FXML
    private lateinit var curarLabel: Label
    @FXML
    private lateinit var cancelarAtack: Label
    @FXML
    private lateinit var borderMenu: BorderPane
    @FXML
    private lateinit var anchorMuerto: AnchorPane
    @FXML
    private lateinit var textoMuerto: Label
    @FXML
    private lateinit var imagenMuerto: ImageView
    @FXML
    private lateinit var continuarMuerto: Button



    //Intefazes Pokemon
    class InterfazPokeCombatSelect(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView)
    class InterfazPokeCombatEnemy(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView, var pokeEnemy: PokeEnemy)
    var pokeselec=Pokemon("Arcanine","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1_combate.gif")

    //Cargar Seleccionado
    fun cargarPokemon(pokemon :Pokemon) {
        pokemon.click=false
        pokeselec = pokemon

        val atackInterfaz=InterfazPokeCombatSelect(nombreAtacante,progressAtacante,psAtacante,nivelAtacante,imagePokeSelect)

        inicializarSeleccion(atackInterfaz)

    }

    //Inicializa Pokemon Default
    fun inicializarSeleccion(interfazPokeCombat: InterfazPokeCombatSelect){

        val pokeSelect= File(pokeselec.imagenCombate)
        interfazPokeCombat.imagen.image=Image(pokeSelect.toURI().toString())

        interfazPokeCombat.nombre.text=pokeselec.nombre
        interfazPokeCombat.ps.text="PS"
        interfazPokeCombat.nivel.text="Nvl "+pokeselec.nivel
        interfazPokeCombat.vida.progress=pokeselec.vidaRest.toDouble()/pokeselec.vidaMax
        if(interfazPokeCombat.vida.progress>0.5)
            interfazPokeCombat.vida.style="-fx-accent: #20ee31"
        else
            if(interfazPokeCombat.vida.progress>0.25)
                interfazPokeCombat.vida.style="-fx-accent: #ff8929"
            else
                if (interfazPokeCombat.vida.progress<0.25)
                    interfazPokeCombat.vida.style="-fx-accent:red"
                  else
                      if (interfazPokeCombat.vida.progress<0.5)
                           interfazPokeCombat.vida.style="-fx-accent:#ff8929"


    }

    //Enemigo
    var enemy=Random.nextInt(0, enemypoke.size)
    var enemigo= enemypoke[enemy]
    var arrayCopia=copiarArray(enemypoke)

    fun copiarArray(arrayEnemy: ArrayList<PokeEnemy>):ArrayList<PokeEnemy>{
        val arrayCopia:ArrayList<PokeEnemy>?=ArrayList()
        arrayEnemy.forEach { pokeEnemy ->
            arrayCopia?.add(pokeEnemy)
        }
        return if (arrayCopia!=null)
            arrayCopia
        else
            arrayEnemy
    }
    fun alertaArrayVacio(){
        anchorMuerto.visibleProperty().set(true)
        textoMuerto.text="No quedan enemigos"
        continuarMuerto.disableProperty().set(true)
    }
    fun inicializarEnemy(interfazPokeCombatEnemy: InterfazPokeCombatEnemy){


        val pokeEnemy=File(enemigo.image)
        interfazPokeCombatEnemy.imagen.image=Image(pokeEnemy.toURI().toString())

        interfazPokeCombatEnemy.nombre.text= enemigo.nombre
        interfazPokeCombatEnemy.ps.text="PS"
        interfazPokeCombatEnemy.nivel.text="Nvl "+enemigo.nivel
        interfazPokeCombatEnemy.vida.progress=enemigo.vidaRest.toDouble()/enemigo.vidaMax
        if(interfazPokeCombatEnemy.vida.progress>0.5)
            interfazPokeCombatEnemy.vida.style="-fx-accent: #20ee31"
        else
            if(interfazPokeCombatEnemy.vida.progress>0.25)
                interfazPokeCombatEnemy.vida.style="-fx-accent:#ff8929"
            else
                if (interfazPokeCombatEnemy.vida.progress<0.25)
                    interfazPokeCombatEnemy.vida.style="-fx-accent:red"
                else{
                    if (interfazPokeCombatEnemy.vida.progress<0.5)
                        interfazPokeCombatEnemy.vida.style="-fx-accent:#ff8929"
        }
    }

    @FXML
    fun initialize(){
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy,enemigo)
        while (arrayCopia[enemy].vidaRest==0) {
            arrayCopia.removeAt(enemy)
            if (arrayCopia.size>0) {
                enemy = Random.nextInt(0, arrayCopia.size)
                enemigo = arrayCopia[enemy]
            }
        }
           inicializarEnemy(enemyInterfaz)

    }
    fun verVida(label: Label){
        label.text=pokeselec.vidaRest.toString()
    }
    fun resetVerVida(label: Label){
        label.text="PS"
    }

    fun verVidaEnemy(label: Label){
        label.text=enemigo.vidaRest.toString()
    }
    fun resetVerVidaEnemy(label: Label){
        label.text="PS"
    }
    @FXML
    fun onMouseAtackEntered(){
        verVida(psAtacante)
    }

    @FXML
    fun onMouseAtackExited(){
        resetVerVida(psAtacante)
    }

    @FXML
    fun onMouseEnemyEntered(){
        verVidaEnemy(psEnemy)
    }
    fun onMouseEnemyExited(){
        resetVerVidaEnemy(psEnemy)
    }
    @FXML
    fun ataqueClicked(){
        borderMenu.visibleProperty().set(false)
        ataqueMenu.visibleProperty().set(true)
    }

    @FXML
    fun underlineTrue(label:Label){
        label.underlineProperty().set(true)
    }
    @FXML
    fun underlineFalse(label:Label){
        label.underlineProperty().set(false)
    }


    @FXML
    fun atackEntered(){
        underlineTrue(atacarLabel)
    }
    @FXML
    fun atackExited(){
        underlineFalse(atacarLabel)
    }
    @FXML
    fun ataqueSeguroEntered(){
        underlineTrue(ataqueSeguro)
    }
    @FXML
    fun ataqueSeguroExited(){
        underlineFalse(ataqueSeguro)
    }
    @FXML
    fun ataqueArriesgadoEntered(){
        underlineTrue(ataqueArriesgado)
    }
    @FXML
    fun ataqueArriesgadoExited(){
        underlineFalse(ataqueArriesgado)
    }
    @FXML
    fun ataqueMuyArriesgadoEntered(){
        underlineTrue(ataqueMuyArriesgado)
    }
    @FXML
    fun ataqueMuyArriesgadoExited(){
        underlineFalse(ataqueMuyArriesgado)
    }
    @FXML
    fun curarLabelEntered(){
        underlineTrue(curarLabel)
    }
    @FXML
    fun curarLabelExited(){
        underlineFalse(curarLabel)
    }
    @FXML
    fun cancelarAtackEntered(){
        underlineTrue(cancelarAtack)
    }
    @FXML
    fun cancelarAtackExited(){
        underlineFalse(cancelarAtack)
    }
    @FXML
    fun cancelarAtackClicked(){
        borderMenu.visibleProperty().set(true)
        ataqueMenu.visibleProperty().set(false)

    }
    var seleccionDePokemonController=SeleccionDePokemonController()
    @FXML
    fun ataqueSeguroClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            enemigo.recibirAtackPlayer(1)
            val enemyInterfaz =
                InterfazPokeCombatEnemy(nombreEnemy, progressEnemy, psEnemy, nivelEnemy, imagePokeEnemy, enemigo)
            inicializarEnemy(enemyInterfaz)
        }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            pokeselec.recibirAtack(1)
            seleccionDePokemonController.actualizarEstado(pokeselec)
            cargarPokemon(pokeselec)
        }
        if (!enemigo.isAliveEnemy()) {
            if (arrayCopia.size == 1)
                continuarMuerto.disableProperty().set(true)
            alertaEnemy(enemigo)
        }
        if(!pokeselec.isAliveSelect())
            alertaSelec(pokeselec)
    }
    @FXML
    fun ataqueArriesgadoClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
        enemigo.recibirAtackPlayer(2)
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy,enemigo)
        inicializarEnemy(enemyInterfaz)
        }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            pokeselec.recibirAtack(2)
            seleccionDePokemonController.actualizarEstado(pokeselec)
            cargarPokemon(pokeselec)
        }
        if (!enemigo.isAliveEnemy()) {
            if (arrayCopia.size == 1)
                continuarMuerto.disableProperty().set(true)
            alertaEnemy(enemigo)
        }
        if(!pokeselec.isAliveSelect())
            alertaSelec(pokeselec)
    }
    @FXML
    fun ataqueMuyArriesgadoClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            enemigo.recibirAtackPlayer(3)
            val enemyInterfaz =
                InterfazPokeCombatEnemy(nombreEnemy, progressEnemy, psEnemy, nivelEnemy, imagePokeEnemy, enemigo)
            inicializarEnemy(enemyInterfaz)
        }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            pokeselec.recibirAtack(3)
            seleccionDePokemonController.actualizarEstado(pokeselec)
            cargarPokemon(pokeselec)
        }
        if (!enemigo.isAliveEnemy()) {
            if (arrayCopia.size == 1)
                continuarMuerto.disableProperty().set(true)
            alertaEnemy(enemigo)
        }
        if(!pokeselec.isAliveSelect())
            alertaSelec(pokeselec)
    }

    @FXML
    fun curarLabelClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            if (enemigo.vidaRest<enemigo.vidaMax) {
               enemigo.curarEnemy()
               val enemyInterfaz = InterfazPokeCombatEnemy(nombreEnemy, progressEnemy, psEnemy, nivelEnemy, imagePokeEnemy, enemigo)
               inicializarEnemy(enemyInterfaz)
           }
       }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
         if (pokeselec.vidaRest<pokeselec.vidaMax) {
               pokeselec.curarSelect()
               seleccionDePokemonController.actualizarEstado(pokeselec)
               cargarPokemon(pokeselec)
           }
       }
    }

    fun alertaSelec(pokemon: Pokemon){

        val alert = Alert(Alert.AlertType.CONFIRMATION)

        alert.headerText = null
        alert.title = "POKEMON DEBILITADO"
        alert.contentText = pokemon.nombre + " se debilito"
        val pokeMuerto=File(pokemon.image)
        alert.graphic = ImageView(Image(pokeMuerto.toURI().toString()))

        val action = alert.showAndWait()
        if (action.get() == ButtonType.OK) {
            continuar()
        } else {
            salir()
        }
    }
    fun alertaEnemy(pokemon: PokeEnemy){

        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.headerText = null
        alert.title = "POKEMON ENEMIGO DEBILITADO"
        alert.contentText = pokemon.nombre + " enemigo se debilito"
        val pokeMuerto=File(pokemon.image)
        alert.graphic = ImageView(Image(pokeMuerto.toURI().toString()))

        val action = alert.showAndWait()

        if (action.get() == ButtonType.OK) {
            continuar()
        } else {
            salir()
        }
    }
    fun salir() {
        exitProcess(0)
    }

    fun continuar() {

        val stage = ataqueMenu.scene.window as Stage
        stage.close()
       seleccionDePokemonController.stage=null

    }


    fun enviarDatosMenuSeleccion(seleccionDePokemonController: SeleccionDePokemonController){
        this.seleccionDePokemonController=seleccionDePokemonController
    }

}