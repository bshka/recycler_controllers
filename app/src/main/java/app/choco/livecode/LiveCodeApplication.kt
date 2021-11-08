package app.choco.livecode

import android.app.Application
import app.choco.livecode.di.serviceModule
import app.choco.livecode.di.viewModelModule
import org.koin.core.context.startKoin

class LiveCodeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(serviceModule, viewModelModule)
        }
    }

}
