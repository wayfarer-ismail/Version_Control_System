package svcs

class Commands {

    /*
    * a static function that prints the help message.
     */
    companion object {
        fun help() {
            println("""
                These are SVCS commands:
                config     Get and set a username.
                add        Add a file to the index.
                log        Show commit logs.
                commit     Save changes.
                checkout   Restore a file.
            """.trimIndent())
        }

        fun config(args: Array<String>) {
            println("Get and set a username.")
        }

        fun add(args: Array<String>) {
            println("Add a file to the index.")
        }

        fun log(args: Array<String>) {
            println("Show commit logs.")
        }

        fun commit(args: Array<String>) {
            println("Save changes.")
        }

        fun checkout(args: Array<String>) {
            println("Restore a file.")
        }
    }

}