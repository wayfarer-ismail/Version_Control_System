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
            val workingDir = File(System.getProperty("user.dir"))
            return if (workingDir.resolve(fileName).exists()) {
                workingDir.resolve(fileName)
            } else {
                workingDir.resolve("vcs").resolve(fileName)
            }
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
            val logFile = getFile("log.txt")

            if (args.size == 1) {
                if (logFile.readText().isEmpty()) {
                    println("No commits yet.")
                } else {
                    println(logFile.readText().split("\n\n").reversed().joinToString("\n\n").trim())
                }
            } else {
                println("Incorrect parameters.")
            }
        }

        fun commit(args: Array<String>) {

            if (args.size < 2) {
                println("Message was not passed.")
            } else {
                val message:String = args[1]

                //calculate hash of commit files
                val indexFile = getFile("index.txt")
                val commitFiles = indexFile.readText().split("\n").dropLast(1) //drop last empty line
                val commitHash = commitFiles.joinToString("") { getFile(it).readText() }.hashCode()

                //save changes to commit directory
                val commitDir = getFile("commits")

                if (commitDir.resolve(commitHash.toString()).isDirectory) {
                    println("Nothing to commit.")

                } else {
                    commitDir.resolve(commitHash.toString()).mkdir()
                    commitFiles.forEach {
                        val file = File(it)
                        file.copyTo(commitDir.resolve(commitHash.toString()).resolve(it))
                    }

                    //add commit info to log
                    val logFile = getFile("log.txt")
                    val commitInfo = """
                        commit $commitHash
                        Author: ${getFile("config.txt").readText()}
                        $message
                    """.trimIndent()
                    logFile.appendText(commitInfo + "\n\n")

                    println("Changes are committed.")
                }
            }
        }

        fun checkout(args: Array<String>) {
            println("Restore a file.")
        }
    }

}