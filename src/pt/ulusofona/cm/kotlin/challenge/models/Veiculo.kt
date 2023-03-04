package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

abstract class Veiculo(val identificador: String): Movimentavel {
    var posicao: Posicao = Posicao()
    val dateFormatter: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    val dataDeAquisicao: String = dateFormatter.format(Date())

    abstract fun requerCarta(): Boolean
}
