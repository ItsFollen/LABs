package com.example.workmanager49

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf


class TextWorker(val context: Context, val workParametr: WorkerParameters) :
    Worker(context, workParametr) {
    override fun doWork(): Result {

        Log.e("TAG", "doWork:sfd " )
        val i = 'f'
        val j = 'r'
        val p = 'i'
        val k = 'e'
        val l = 'n'
        val m = 'd'
        val s=i.toString().plus(j).plus(k).plus(p).plus(l).plus(m)
        var c = ""
        while (c != "friend") {
            c = (0..5)
                .map { s.random() }
                .joinToString("")
            Log.e("TAG", "doWork: $c", )
        }

        Log.e("TAG", "doWork: $c", )
        val d = workDataOf("data_is" to c)
        return Result.success(d)
    }
}