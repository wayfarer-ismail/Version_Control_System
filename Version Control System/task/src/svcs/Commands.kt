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
            val configFile = getFile("config.txt")

            if (args.size == 1) {

                if (configFile.readText().isEmpty()) {
                    println("Please, tell me who you are.")
                } else {
                    println("The username is ${configFile.readText()}.")
                }
            } else {
                configFile.writeText(args[1])
                println("The username is ${args[1]}.")
            }

        }

        private fun getFile(fileName: String): File {
            val workingDir = System.getProperty("user.dir")
            val path = "${workingDir}${sprtr}vcs${sprtr}${fileName}"
            return File(path)
        }


        fun add(args: Array<String>) {
            val indexFile = getFile("index.txt")

            if (args.size == 1) {
                if (indexFile.readText().isEmpty()) {
                    println("Add a file to the index.")
                } else {
                    println("Tracked files:")
                    println(indexFile.readText())
                }
            } else {
                val fileName = args[1]
                val file = File(fileName)

                if (!file.exists()) {
                    println("Can't find '${args[1]}'.")
                } else {
                    indexFile.appendText(fileName + "\n")
                    println("The File '$fileName' is tracked.")
                }
            }

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