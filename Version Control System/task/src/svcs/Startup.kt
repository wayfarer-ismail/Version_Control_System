package svcs

import java.io.File

class Startup {
    companion object {
        private val sprtr = File.separator
        private val workingDir: String = System.getProperty("user.dir")

        fun init() {

            val path = "${workingDir}${sprtr}vcs"
            val file = File(path)
            if (!file.exists()) {
                file.mkdir()
            }
            
            createFile("${workingDir}${sprtr}vcs${sprtr}config.txt")

            createFile("${workingDir}${sprtr}vcs${sprtr}index.txt")
        }

        private fun createFile(path: String) {
            val file = File(path)
            if (!file.exists()) {
                file.createNewFile()
            }
        }
    }
}