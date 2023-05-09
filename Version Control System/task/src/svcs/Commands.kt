package svcs

import java.io.File

class Commands {

    /*
    * a static function that prints the help message.
     */
    companion object {
        private val sprtr = File.separator

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
            initConfig()

            val name: String = if (args.size == 1) {
                println("Please, tell me who you are.")
                readln()
            } else {
                args[1]
            }

            println("The username is $name.")
        }

        private fun initConfig() {
            val workingDir = System.getProperty("user.dir")
            val path = "${workingDir}${sprtr}vcs${sprtr}config.txt"
            val file = File(path)
            if (!file.exists()) {
                File("vcs").mkdir()
                file.createNewFile()
            }
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