package kz.caremet.mentors.domain.models


data class Question(
    val uuid: String?,
    val id: Int?,
    val text: String,
    val status: Status,
    val answer_count: Int,
    val created_at: String,
    val sender: Person,
    val pending_read: Boolean,
    val unread_answers_count:Int
//    val check_lists: List<CheckListFromApi>,
    //   val attached_conversation: List<EmailConversation>?,
)