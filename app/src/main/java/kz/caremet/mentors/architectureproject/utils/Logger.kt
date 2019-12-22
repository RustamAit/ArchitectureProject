package kz.caremet.mentors.architectureproject.utils

import android.util.Log
import kz.caremet.mentors.remote.services.Logger

class LoggerImpl: Logger  {

    fun msg(tag: String, msg: Any?) {
        Log.i(tag, "$msg")
    }

    fun msg(msg: Any?) {
        msg("MSG", "$msg")
    }

   override fun api(msg: String?) {
        msg("API", "$msg")
    }
}