package kz.caremet.mentors.architectureproject.retrofit

import io.reactivex.Single
import kz.caremet.mentors.domain.models.Question
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface QuestionService {
    @Headers("Client-ID: cGJvLWNsaWVudC1hcHA=" , "Client-Secret: aW9z")
    @GET("api/v1/entities/{entity_id}/questions")
    fun getQuestions(@Header("Authorization") token: String?, @Path("entity_id") entity_id: Int): Single<List<Question>>

    @Headers("Client-ID: cGJvLWNsaWVudC1hcHA=" , "Client-Secret: aW9z")
    @GET("api/v1/entities/{entity_id}/questions/{question_id}")
    fun getAnswerByQuestionId(@Header("Authorization") token: String?, @Path("entity_id") entity_id: Int, @Path("question_id") question_id: String): Single<List<Question>>

}