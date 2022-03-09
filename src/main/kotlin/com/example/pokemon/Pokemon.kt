package com.example.pokemon

import kotlin.random.Random

data class Pokemon(val nombre:String,val image:String,val vidaMax:Int,var nivel:Int,val genero:String,var imagenCombate:String,var fotoestado:String,var vidaRest:Int=vidaMax, var click:Boolean=false, var estado:Int=Random.nextInt(3)+1) {

        // 0= sin estado
        // 1= envenenado
        // 2= quemado
        // 3= congelado

    fun checkEstado(){
        if (estado == 0) {
            fotoestado = ""
        }
        if (estado == 1) {
            fotoestado = "src\\main\\resources\\com\\example\\pokemon\\Images\\veneno.png"
        }
        if (estado == 2) {
            fotoestado = "src\\main\\resources\\com\\example\\pokemon\\Images\\fuego.png"
        }
        if (estado == 3) {
            fotoestado = "src\\main\\resources\\com\\example\\pokemon\\Images\\frio.png"
        }
    }

    fun isAliveSelect():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }

    fun recibirAtack(i:Int){
        var atack2=0
        var atack3=0

        if (estado==1){vidaRest-=10}
        if (this.isAliveSelect())
            //ataque seguro
            if (i==1)
                if (vidaRest-20<0)
                    vidaRest=0
                else{
                    if (estado==2) {vidaRest-=10}
                    vidaRest-=20}
        //ataque arriesgado
            else if (i==2)
                   atack2=  Random.nextInt(10,26)
                    println(atack2)
                if (vidaRest-atack2<0)
                    vidaRest=0

                else{
                    if (estado==2){vidaRest-=atack2/2}
                    vidaRest-=atack2}
        //ataque muy arriesgado
                 if (i==3)
                     atack3=Random.nextInt(0,51)
                    println(atack3)
                    if (vidaRest-atack3<0)
                        vidaRest=0
                    else{
                        if (estado==2){vidaRest-=atack3/2}
                        vidaRest-=atack3}


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
                else{
                    if (arraypoke[i].estado==3){vidaRest+=10}
                    vidaRest-=20}
            else if (i==2)

                atack2=  Random.nextInt(10,26)
                if (vidaRest-atack2<0)
                    vidaRest=0
                else{
                    vidaRest-=atack2
                     if (arraypoke[i].estado==3){vidaRest+=atack2/2}}
                    if (i==3)
                            atack3=Random.nextInt(0,51)
                        if (vidaRest-atack3<0)
                            vidaRest=0
                        else{
                            if (arraypoke[i].estado==3){vidaRest+=atack2/2}
                            vidaRest-=atack3}

    }

    fun curarEnemy(){
        var curarEnemigo=Random.nextInt(25,76)
        if (vidaRest+curarEnemigo>vidaMax)
            vidaRest=vidaMax
        else
            vidaRest+=curarEnemigo
    }
}