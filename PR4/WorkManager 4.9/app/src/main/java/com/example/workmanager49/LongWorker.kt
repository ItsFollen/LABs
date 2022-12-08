package com.example.workmanager49

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class LongWorker(val context: Context, val workParametr: WorkerParameters) :
    CoroutineWorker(context, workParametr) {
    @SuppressLint("RestrictedApi")
    override suspend fun doWork(): Result {

        Log.e("long_worker_start", "doWork: ", )
        val data1 = inputData.getString("data_is")
        val data2 = inputData.getInt("data2", 1)

        var i = (1 until data1!!.length * 10000).random()
        val j = (1..data2).random()

        var p = 0
        while (i > 0) {
            p += i % j

            i /= j
        }


        return Result.Success(workDataOf("p" to p))
    }
}