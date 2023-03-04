package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Carro(identificador: String, var motor: Motor): Veiculo(identificador), Ligavel, Movimentavel {
    override fun ligar() {
        if(motor.estaLigado()) {
            throw VeiculoLigadoException()
        }

        motor.ligar()
    }

    override fun desligar() {
        if(!motor.estaLigado()) {
            throw VeiculoDesligadoException()
        }

        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun requerCarta(): Boolean {
        return true
    }

    override fun toString(): String {
        return "Carro | $identificador | $dataDeAquisicao | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}