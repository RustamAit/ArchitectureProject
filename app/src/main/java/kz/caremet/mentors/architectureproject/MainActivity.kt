package kz.caremet.mentors.architectureproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import kz.caremet.mentors.data.repository.QuestionRepository
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    val questionRepository: QuestionRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionRepository.fetchData()
        questionRepository.getQuestions().observeOn(AndroidSchedulers.mainThread()).subscribe {
            Log.d("DATA_TEST", ArrayList(it).toString())
        }
    }
}
