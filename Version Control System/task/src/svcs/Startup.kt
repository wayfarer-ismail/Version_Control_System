package svcs

import java.io.File

class Startup {
    companion object {
        private val sprtr = File.separator
        private val workingDir: String = System.getProperty("user.dir")

        fun init() {

            val path = "${workingDir}${sprtr}vcs"
            val dir = File(path)
            if (!dir.exists()) {
                dir.mkdir()
            }

            dir.resolve("config.txt").createNewFile()
            dir.resolve("index.txt").createNewFile()
        }

    }
}