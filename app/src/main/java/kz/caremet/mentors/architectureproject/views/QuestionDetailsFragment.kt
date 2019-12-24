package kz.caremet.mentors.architectureproject.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_question_details.*

import kz.caremet.mentors.architectureproject.R


class QuestionDetailsFragment : Fragment() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun increaseCounter(){
        count += 1
        counterTextView?.text = count.toString()
    }

    companion object {

        @JvmStatic
        fun newInstance() = QuestionDetailsFragment()
    }
}
