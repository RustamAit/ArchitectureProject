package kz.caremet.mentors.architectureproject.views.questions


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_question_details.*

import kz.caremet.mentors.architectureproject.R
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questionDetails.QuestionDetailsViewModel
import org.koin.android.ext.android.inject

const val QUESTION_UUID = "question_uuid"

class QuestionDetailsFragment : Fragment() {

    var questionUuid: String? = null
    val viewModel: QuestionDetailsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            questionUuid = it.getString(QUESTION_UUID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionText.text = questionUuid
        questionUuid?.let { uuid ->
            viewModel.getQuestion(uuid).observeOn(AndroidSchedulers.mainThread()).subscribe {
                questionText.text = it.text
                questionStatus.text = it.status.name
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(uuid: String) =
            QuestionDetailsFragment().apply {
                this.arguments = Bundle().apply {
                    this.putString(QUESTION_UUID, uuid)
                }
            }
    }
}
