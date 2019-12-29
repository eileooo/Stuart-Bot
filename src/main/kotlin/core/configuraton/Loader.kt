package core.configuraton

import java.io.File

class Loader {

    companion object {
        var br = hashMapOf<String, String>()

        fun setup() {
            File("resources/pt-br.yml").readLines().forEach {
                br[it.split(": ")[0]] = it.split(": ")[1]
            }
        }

    }

}