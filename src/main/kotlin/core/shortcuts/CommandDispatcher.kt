package core.shortcuts

import java.awt.Color

inline fun successEmbed(x: String) = embed {
    color = Color.GREEN
    description = x
}