package com.example.pokemon

import kotlin.random.Random

data class Pokemon(val nombre:String,val image:String,val vidaMax:Int,var nivel:Int,val genero:String,var imagenCombate:String,var vidaRest:Int=vidaMax, var click:Boolean=false) {

    fun isAliveSelect():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }

    fun recibirAtack(i:Int){
        var atack2=0
        var atack3=0
        if (this.isAliveSelect())
            if (i==1)
                if (vidaRest-20<0)
                    vidaRest=0
                else
                    vidaRest-=20
            else if (i==2)
                   atack2=  Random.nextInt(10,26)
                if (vidaRest-atack2<0)
                    vidaRest=0
                else
                    vidaRest-=atack2
                 if (i==3)
                     atack3=Random.nextInt(0,51)
                    if (vidaRest-atack3<0)
                        vidaRest=0
                    else
                        vidaRest-=atack3


    }

    fun curarSelect(){
        var curarAliado=Random.nextInt(25,76)
        if (vidaRest+curarAliado>vidaMax)
            vidaRest=vidaMax
        else
            vidaRest+=curarAliado
    }
}
data class PokeEnemy(val nombre: String,val image: String,val nivel: Int,val vidaMax: Int,var vidaRest: Int=vidaMax){
    fun isAliveEnemy():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }
    fun recibirAtackPlayer(i:Int){
        var atack2=0
        var atack3=0
        if (this.isAliveEnemy())
            if (i==1)
                if (vidaRest-20<0)
                    vidaRest=0
                else
                    vidaRest-=20
            else if (i==2)
                atack2=  Random.nextInt(10,26)
                if (vidaRest-atack2<0)
                    vidaRest=0
                else
                    vidaRest-=atack2
                    if (i==3)
                            atack3=Random.nextInt(0,51)
                        if (vidaRest-atack3<0)
                            vidaRest=0
                        else
                            vidaRest-=atack3

    }

    fun curarEnemy(){
        var curarEnemigo=Random.nextInt(25,76)
        if (vidaRest+curarEnemigo>vidaMax)
            vidaRest=vidaMax
        else
            vidaRest+=curarEnemigo
    }
}