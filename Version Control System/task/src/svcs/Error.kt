package svcs

class Error {
    companion object {
        fun invalidCommand(s: String) {
            println("'$s' is not a SVCS command.")
        }
    }
}