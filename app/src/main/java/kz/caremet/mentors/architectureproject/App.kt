package kz.caremet.mentors.architectureproject

import android.app.Application
import kz.caremet.mentors.architectureproject.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModules)
            androidContext(this@App)
        }

    }
}