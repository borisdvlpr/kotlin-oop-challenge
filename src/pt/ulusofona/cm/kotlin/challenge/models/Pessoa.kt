package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Date): Movimentavel {
    var veiculos: MutableList<Veiculo> = mutableListOf()
    var carta: Carta? = null
    var posicao: Posicao = Posicao()
    val dateFormatter: DateTimeFormatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val birthDate = LocalDate.parse(dataDeNascimento.toString(), dateFormatter)

    fun temCarta(): Boolean {
       return carta != null
    }

    fun tirarCarta() {
        val current = LocalDate.parse(Date().toString(), dateFormatter)
        val period = Period.between(birthDate, current)

        if(period.years < 18) {
            throw MenorDeIdadeException()
        }

        carta = Carta()
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for(temp in veiculos) {
            if(temp.identificador == identificador) {
                return temp
            }
        }

        throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {

    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        for(temp in veiculos) {
            if(temp.identificador == identificador) {
                temp.moverPara(x, y)
            }
        }
    }

    override fun moverPara(x: Int, y: Int) {
        if(posicao.x == x && posicao.y == y) {
            throw AlterarPosicaoException()
        }

        posicao.x = x
        posicao.y = y
    }

    override fun toString(): String {
        return "Pessoa | $nome | $printableBirth | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}
