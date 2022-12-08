package com.example.workmanager49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import com.example.workmanager49.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

var chars = "abcdifjhijklmnopqrstuvwxyz"


class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.clicker.apply {

            setOnClickListener {
                count++
                text = count.toString()
            }
        }





        binding.start.setOnClickListener {

           var  textWorkerRequest = OneTimeWorkRequestBuilder<TextWorker>()
                .build()
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(textWorkerRequest.id)
                .observe(
                    this
                ) { workInfo ->

                    if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {

                        val data1 = workInfo.outputData.getString("data_is")

                        WorkManager.getInstance(this).cancelWorkById(workInfo.id)
                        Log.e("text_worker_stop", "stop:  ${data1}")


                        startLongWorker(workInfo.outputData)

                    }
                }

    }

    }


    private fun startLongWorker(data1: Data) {
        val data2 = workDataOf("data2" to 100)
      var   longWorkerRequest = OneTimeWorkRequestBuilder<LongWorker>()
            .setInputData(data1)
            .setInputData(data2)
            .build()

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(longWorkerRequest.id)
            .observe(this) { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    var p = workInfo.outputData.getInt("p", 0)

                    Log.e("TAG", "long_worker_stop with rezult $p ")
                    WorkManager.getInstance(this).cancelWorkById(workInfo.id)

                }


            }

    }

    override fun onDestroy() {
        super.onDestroy()
        WorkManager.getInstance(baseContext).cancelAllWork()
    }
}


