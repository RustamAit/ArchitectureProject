package kz.caremet.mentors.architectureproject.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_question_list.*

import kz.caremet.mentors.architectureproject.R

class QuestionListFragment : Fragment() {

    var listener: OnQuestionFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeColorButton?.setOnClickListener {
            listener?.increaseCounter()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is OnQuestionFragmentInteractionListener){

            listener = context
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = QuestionListFragment()
    }
}
