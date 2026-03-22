package com.absentia.app

import android.app.Application
import com.absentia.app.repository.AbsentiaRepository

class AbsentiaApp : Application() {
    val repository by lazy { AbsentiaRepository(this) }
}
