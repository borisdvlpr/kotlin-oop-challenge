package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoDesligadoException(override val message: String = "500 - Vehicle not turned on."): Exception(message)
