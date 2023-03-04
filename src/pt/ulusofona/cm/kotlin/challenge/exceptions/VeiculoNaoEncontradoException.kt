package pt.ulusofona.cm.kotlin.challenge.exceptions

class VeiculoNaoEncontradoException(override val message: String = "404 - Vehicle not found."): Exception(message)
