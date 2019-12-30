package core.commands

import core.framework.Command
import core.framework.Container
import javafx.scene.image.Image
import javafx.scene.image.WritableImage
import net.dv8tion.jda.api.Permission
import java.io.File

class Test : Command() {

    override var label: String = "test"
    override var aliases: List<String> = listOf()
    override var description: String = "Just a test bro"
    override var permissions: List<Permission> = listOf()

    override fun run(container: Container) {
        val img = Image("resources/image.png")
        val image = WritableImage(img.pixelReader, img.width.toInt(), img.height.toInt())

        val pixelReader = image.pixelReader
        val pixelWriter = image.pixelWriter

        for (i in 0 until 400) {
            for (j in 0 until 400) {
                val color = pixelReader.getColor(i, j)
                pixelWriter.setColor(i, j, color.desaturate())
            }
        }

        container.channel.sendFile(File("resources/image.png")).queue()
    }
}