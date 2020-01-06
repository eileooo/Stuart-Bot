package core.framework

class Set(val category: String) {

    var commands = mutableListOf<Command>()

    inline fun command(label: String, noinline dsl: Command.() -> Unit) {
        var command = Command(label, category)
        command.apply(dsl)
        command.run = dsl

        commands.add(command)
    }

}