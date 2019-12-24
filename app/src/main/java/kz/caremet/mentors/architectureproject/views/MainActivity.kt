package kz.caremet.mentors.architectureproject.views

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import kz.caremet.mentors.architectureproject.R
import kz.caremet.mentors.architectureproject.retrofit.QuestionService
import kz.caremet.mentors.architectureproject.retrofit.createOkHttpClient
import kz.caremet.mentors.architectureproject.retrofit.createService
import kz.caremet.mentors.architectureproject.utils.LoggerImpl
import kz.caremet.mentors.data.repository.QuestionRepository
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), OnQuestionFragmentInteracrtionListener {

    val questionRepository: QuestionRepository by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, QuestionListFragment.newInstance())
            .commit()


    }


}
