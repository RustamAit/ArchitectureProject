package kz.caremet.mentors.architectureproject.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_question_list.*

import kz.caremet.mentors.architectureproject.R
import kz.caremet.mentors.architectureproject.retrofit.QuestionService
import kz.caremet.mentors.architectureproject.retrofit.createOkHttpClient
import kz.caremet.mentors.architectureproject.retrofit.createService
import kz.caremet.mentors.architectureproject.utils.LoggerImpl
import kz.caremet.mentors.architectureproject.views.adapters.QuestionAdapter


class QuestionListFragment : Fragment() {

    var listener: OnQuestionFragmentInteracrtionListener? = null

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


        val questionService: QuestionService? =
            createService<QuestionService>(createOkHttpClient(LoggerImpl()), "https://qa.pbo.kz/") as? QuestionService

        questionService?.getQuestions("Bearer hlSW-aQskBhA-aTBDDR37rhQGYQQJ59H3NWHurw208c", 133)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { it ->
            recList.adapter = QuestionAdapter(it)
        }
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
