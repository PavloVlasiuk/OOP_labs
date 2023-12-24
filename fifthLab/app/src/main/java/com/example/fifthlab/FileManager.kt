package com.example.fifthlab


import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class FileManager(private val context: Context) {
    fun writeFile(fileName: String, data: String) {
        val file = File(context.filesDir, fileName)
        try {
            val outputStream = FileOutputStream(file)
            outputStream.write(data.toByteArray())
            outputStream.close()
        } catch (e: IOException) {
            Log.e("Exception", "File write failed: $e")
        }
    }
}