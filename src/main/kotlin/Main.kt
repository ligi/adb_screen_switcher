import se.vidstige.jadb.JadbConnection

fun main(args: Array<String>) {
    val wanted = when (args.firstOrNull()) {
        "on" -> true
        "off" -> false
        else ->  throw IllegalArgumentException("you musst pass either 'on' or 'off'")
    }
    JadbConnection().devices.forEach { device ->
        val isScreenOn = device.executeShell("dumpsys input_method").reader().readText().contains("mInteractive=true")
        if (wanted.xor(isScreenOn)) {
            // we need to read the text for the command to be executed - https://github.com/vidstige/jadb/issues/125
            device.executeShell("input keyevent KEYCODE_POWER").reader().readText()
        }
    }
}