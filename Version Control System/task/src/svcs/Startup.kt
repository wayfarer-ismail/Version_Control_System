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

            file.resolve("config.txt").createNewFile()

            file.resolve("index.txt").createNewFile()

            file.resolve("log.txt").createNewFile()

            file.resolve("commits").mkdir()
        }
    }
}