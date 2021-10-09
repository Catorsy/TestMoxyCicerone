package com.example.testmoxycicerone

import android.content.Context

val Context.app: App
get() {
    return applicationContext as App
}