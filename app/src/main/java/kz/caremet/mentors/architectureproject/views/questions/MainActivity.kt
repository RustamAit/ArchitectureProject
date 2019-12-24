package kz.caremet.mentors.architectureproject.views.questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.caremet.mentors.architectureproject.R
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questions.questionActivity.QuestionActivityViewModel

import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), OnQuestionFragmentInteracrtionListener {

    val viewModel: QuestionActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,
                QuestionListFragment.newInstance()
            )
            .commit()
        viewModel.fetchData()
    }

    override fun startDetailsFragment(uuid: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,
                QuestionDetailsFragment.newInstance(uuid)
            )
            .addToBackStack(null)
            .commit()
    }

}
