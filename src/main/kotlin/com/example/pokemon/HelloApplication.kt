package com.example.pokemon

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

var arraypoke= ArrayList<Pokemon>()
var enemypoke=ArrayList<PokeEnemy>()
class HelloApplication : Application() {
    override fun start(stage: Stage) {

        //Creación de objetos Pokemon
        val poke1=Pokemon("Alakazam","src\\main\\resources\\com\\example\\pokemon\\Images\\alakazam1.gif",180,50,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.gif","src\\main\\resources\\com\\example\\pokemon\\Images\\alakazam1_combate.gif")
        val poke2=Pokemon("Arcanine","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1.gif",210,50,"src\\main\\resources\\com\\example\\pokemon\\Images\\Hembra.gif","src\\main\\resources\\com\\example\\pokemon\\Images\\arcanine1_combate.gif")
        val poke3=Pokemon("Golem","src\\main\\resources\\com\\example\\pokemon\\Images\\golem1.gif",250,50,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.gif","src\\main\\resources\\com\\example\\pokemon\\Images\\golem1_combate.gif")
        val poke4=Pokemon("Gyarados","src\\main\\resources\\com\\example\\pokemon\\Images\\gyarados1.gif",230,50,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.gif","src\\main\\resources\\com\\example\\pokemon\\Images\\gyarados1_combate.gif")
        val poke5=Pokemon("Nidoking","src\\main\\resources\\com\\example\\pokemon\\Images\\nidoking1.gif",200,50,"file:","src\\main\\resources\\com\\example\\pokemon\\Images\\nidoking1_combate.gif")
        val poke6=Pokemon("Zapdos","src\\main\\resources\\com\\example\\pokemon\\Images\\zapdos1.gif",190,54,"src\\main\\resources\\com\\example\\pokemon\\Images\\Macho.gif","src\\main\\resources\\com\\example\\pokemon\\Images\\zapdos1_combate.gif")
        //Creacción de objetos Pokemon enemigos
        val pokeEnemy1=PokeEnemy("Deoxys","src\\main\\resources\\com\\example\\pokemon\\Images\\deoxys_enemigo.gif",50,190)
        val pokeEnemy2=PokeEnemy("Lugia","src\\main\\resources\\com\\example\\pokemon\\Images\\lugia_enemigo.gif",50,210)
        val pokeEnemy3=PokeEnemy("Scizor","src\\main\\resources\\com\\example\\pokemon\\Images\\scizor_enemigo.gif",50,230)
        val pokeEnemy4=PokeEnemy("Metagross","src\\main\\resources\\com\\example\\pokemon\\Images\\metagross_enemigo.gif",50,250)
        //Rellenar lista de Pokemon Enemigo
        enemypoke.add(pokeEnemy1)
        enemypoke.add(pokeEnemy2)
        enemypoke.add(pokeEnemy3)
        enemypoke.add(pokeEnemy4)

        //Rellenar la lista de Pokemon
        arraypoke.add(poke1)
        arraypoke.add(poke2)
        arraypoke.add(poke3)
        arraypoke.add(poke4)
        arraypoke.add(poke5)
        arraypoke.add(poke6)


        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("seleccion_pokemon_menu.fxml"))
        val scene = Scene(fxmlLoader.load(), 663.0, 397.0)

        stage.title = "Pokemon"
        stage.scene = scene
        stage.isResizable=false
        stage.show()
    }
}

fun main() {

    Application.launch(HelloApplication::class.java)


}