package nl.linsoft.klonkr.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_questions.view.*
import kotlinx.android.synthetic.main.questions_row.view.*
import nl.linsoft.klonkr.R
import nl.linsoft.klonkr.data.User
import nl.linsoft.klonkr.data.UserDao
import nl.linsoft.klonkr.data.UserRepository
import nl.linsoft.klonkr.data.UserViewModel

class QuestionsAdapter: RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>(){

    private var userList: ArrayList<User> = ArrayList<User>()
    private lateinit var mUserViewModel: UserViewModel

    //recyclerView
    private val view = inflater.inflate(R.layout.fragment_survey, container, false)
    private val recyclerView = view?.questionsQuestions
    recyclerView?.adapter = QuestionsAdapter()
    recyclerView?.layoutManager =
    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

    // UserViewModel
    mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
        if (recyclerView != null) {
            (recyclerView.adapter as QuestionsAdapter).setData(user)
        }
    })

    class QuestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        return QuestionsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.questions_row, parent, false))
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {

        val currentItem = userList[position]
        holder.itemView.rowQuestion.text = currentItem.question
        if (currentItem.mode=="true") {
            holder.itemView.rowModeText.text = "Y/N"
        } else {
            holder.itemView.rowModeText.text = "A"
        }
        holder.itemView.rowDeleteButton.setOnClickListener {
            userList.removeAt(position)
            mUserViewModel.deleteUser(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user as ArrayList<User>
        notifyDataSetChanged()
    }

}
