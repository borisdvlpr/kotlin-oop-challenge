package pt.ulusofona.cm.kotlin.challenge.exceptions

class MenorDeIdadeException(override val message: String = "Under aged, cannot have a driver's license."): Exception(message)
