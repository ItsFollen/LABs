package com.example.pr3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pr3_3.Model.PersonModelClass
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personsList: ArrayList<PersonModelClass> = ArrayList()

        try {
            val obj = JSONObject(getJSONFromAssets()!!)

            val personsArray = obj.getJSONArray("persons")

            for (i in 0 until personsArray.length()) {

                val person = personsArray.getJSONObject(i)

                val id = person.getInt("id")
                val sex = person.getString("sex")
                val name = person.getString("name")
                val phoneNumber = person.getString("phoneNumber")

                val personDetails = PersonModelClass(id, sex, name, phoneNumber)

                personsList.add(personDetails)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        rvPersonsList.layoutManager = LinearLayoutManager(this)

        val itemAdapter = PersonAdapter(this, personsList)

        rvPersonsList.adapter = itemAdapter
    }

    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myPersonsJSonFile = assets.open("Persons.json")
            val size = myPersonsJSonFile.available()
            val buffer = ByteArray(size)
            myPersonsJSonFile.read(buffer)
            myPersonsJSonFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}