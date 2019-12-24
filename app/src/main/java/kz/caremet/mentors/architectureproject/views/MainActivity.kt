package kz.caremet.mentors.architectureproject.views

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


class MainActivity : AppCompatActivity(), OnQuestionFragmentInteractionListener {

    val questionRepository: QuestionRepository by inject()

    var questionListFragment: QuestionListFragment? = null
    var questionDetailsFragment: QuestionDetailsFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        questionRepository.fetchData()
//        questionRepository.getQuestions().observeOn(AndroidSchedulers.mainThread()).subscribe {
//            Log.d("DATA_TEST", ArrayList(it).toString())
//
//        }

        val questionService: QuestionService? =
            createService<QuestionService>(createOkHttpClient(LoggerImpl()), "https://qa.pbo.kz/") as? QuestionService

        questionService?.
            getQuestions("Bearer hlSW-aQskBhA-aTBDDR37rhQGYQQJ59H3NWHurw208c", 133)?.subscribe { it ->

            Log.d("DATA_FROM_SERVICE", ArrayList(it).toString())
        }

        questionService?.getAnswerByQuestionId("Bearer hlSW-aQskBhA-aTBDDR37rhQGYQQJ59H3NWHurw208c", 133, "FD38D469-6E66-41BD-AB5D-4403D6D9D7C2")?.doOnError {
            Log.d("dsfsdfdsfsdfsdfsdfsdf", it.message)
        }?.observeOn(AndroidSchedulers.mainThread())?.subscribe{ it ->
            Log.d("ANSWERS", ArrayList(it).toString())
        }

        questionDetailsFragment = QuestionDetailsFragment.newInstance()
        questionListFragment = QuestionListFragment.newInstance()

        questionListFragment?.let {
            supportFragmentManager.beginTransaction().add(R.id.firstContainer, it).commit()
        }

        questionDetailsFragment?.let {
            supportFragmentManager.beginTransaction().add(R.id.secondContainer, it).commit()
        }

    }

    override fun increaseCounter(){
       questionDetailsFragment?.increaseCounter()
    }
}
