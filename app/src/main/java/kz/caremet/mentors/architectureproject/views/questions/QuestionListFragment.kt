package kz.caremet.mentors.architectureproject.views.questions

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_question_list.*

import kz.caremet.mentors.architectureproject.R
import kz.caremet.mentors.architectureproject.views.adapters.QuestionAdapter
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questionList.QuestionListViewModel
import org.koin.android.ext.android.inject


class QuestionListFragment() : Fragment(), OnItemQuestionClicked {

    var listener: OnQuestionFragmentInteracrtionListener? = null
    val viewModel: QuestionListViewModel by inject()

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


        recList.layoutManager = LinearLayoutManager(context)
        viewModel.getQuestionList().observeOn(AndroidSchedulers.mainThread()).subscribe{
            recList?.adapter = QuestionAdapter(it, this)
        }
    }

    override fun startDetailsFragment(uuid: String) {
        listener?.startDetailsFragment(uuid)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is OnQuestionFragmentInteracrtionListener){
            listener = context
        }

    }


    companion object {
        @JvmStatic
        fun newInstance() =
            QuestionListFragment()
    }
}
