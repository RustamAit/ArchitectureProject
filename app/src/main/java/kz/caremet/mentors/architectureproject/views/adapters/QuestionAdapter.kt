package kz.caremet.mentors.architectureproject.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_question.view.*
import kz.caremet.mentors.architectureproject.R
import kz.caremet.mentors.domain.models.Question

class QuestionAdapter(private val dataset: List<Question>): RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(dataset[position])
    }


    inner class QuestionViewHolder(v: View): RecyclerView.ViewHolder(v){
        fun bind(p: Question){
            itemView.questionText.text = p.text
        }
    }

}