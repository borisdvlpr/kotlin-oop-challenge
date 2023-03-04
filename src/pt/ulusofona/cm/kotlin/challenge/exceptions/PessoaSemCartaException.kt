package pt.ulusofona.cm.kotlin.challenge.exceptions

class PessoaSemCartaException(override val message: String = "Doesn't have a driver's license!!"): Exception(message)
