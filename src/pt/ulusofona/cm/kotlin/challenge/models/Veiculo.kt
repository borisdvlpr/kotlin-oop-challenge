package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.Date

abstract class Veiculo(val identificador: String): Movimentavel {
    var posicao: Posicao = Posicao()
    val dateFormatter: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    val dataDeAquisicao: String = dateFormatter.format(Date())

    abstract fun requerCarta(): Boolean

    override fun moverPara(x: Int, y: Int) {
        if(posicao.x == x && posicao.y == y) {
            throw AlterarPosicaoException()
        }

        posicao.x = x
        posicao.y = y
    }
}
