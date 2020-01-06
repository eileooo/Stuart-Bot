package core.framework

class Help {

    lateinit var text: String

    init {
        var sb = StringBuilder()
        for (set in sets) {
            for (command in set.commands) {
                sb.append("${command.label}\n")
            }
        }
        text = sb.toString()
    }

}