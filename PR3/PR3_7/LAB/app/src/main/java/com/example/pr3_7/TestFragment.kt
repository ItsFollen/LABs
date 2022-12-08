package com.example.pr3_7

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.pr3_7.databinding.FragmentTestBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var content: FragmentTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        content = FragmentTestBinding.inflate(inflater, container, false)
        return content.root
    }

    fun setState(hour: Int, minute: Int, sunbyDay: Boolean, moonNight: Boolean) {

        Log.e("TAG", "setState: ${hour} ", )
        content.root.apply {
            if (hour in 6..18) {
                setBackgroundColor(Color.GRAY)
                content.moon.apply { isVisible=false }
                content.sun.apply {
                    isVisible = sunbyDay
                }
                content.background.apply {
                    isVisible = false
                }

            } else {
                content.sun.apply { isVisible=false }
                content.moon.apply {
                    isVisible = moonNight
                }
                if (moonNight)
                    content.background.apply {
                        isVisible=true
                        setBackgroundResource(R.drawable.img)
                    } else
                    setBackgroundColor(Color.BLACK)
            }
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TestFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TestFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
            }
    }
}