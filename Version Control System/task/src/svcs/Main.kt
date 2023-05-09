package svcs

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        Commands.help()
        return
    } else {
        Startup.init() // create the vcs directory and the config.txt and index.txt files

        when(args[0]) {
            "config" -> Commands.config(args)
            "add" -> Commands.add(args)
            "log" -> Commands.log(args)
            "commit" -> Commands.commit(args)
            "checkout" -> Commands.checkout(args)
            "--help" -> Commands.help()
            else -> Error.invalidCommand(args[0])
        }
    }
}