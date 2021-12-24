package nl.linsoft.klonkr.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_questions.*
import kotlinx.android.synthetic.main.fragment_questions.view.*
import nl.linsoft.klonkr.recyclerview.QuestionsAdapter
import nl.linsoft.klonkr.R
import nl.linsoft.klonkr.data.User
import nl.linsoft.klonkr.data.UserViewModel

class Questions: Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_questions, container, false)
        //return button
        view.questionsReturnButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_questions_to_settings)
        }
        //add button
        view.questionsAddButton.setOnClickListener {
            insertDataToDatabase()
            view.questionsTextField.setText("")
        }
        //delete button
        view.questionsDeleteButton.setOnClickListener {
            deleteAllUsers()
        }

        //recyclerView
        val recyclerView = view?.questionsQuestions
        recyclerView?.adapter = QuestionsAdapter()
        recyclerView?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            if (recyclerView != null) {
                (recyclerView.adapter as QuestionsAdapter).setData(user)
            }
        })

        return view
    }

    private fun insertDataToDatabase() {
        val question = questionsTextField.text.toString()
        val mode = questionsModeButton.isChecked.toString()

        if (inputCheck(question, mode)) {
            //Create User Object
            val user = User(0, question, mode)
            //Add data to database
            mUserViewModel.addUser(user)
        } else {
            Toast.makeText(activity, "Something went wrong!", LENGTH_LONG).show()
        }
    }
    private fun inputCheck(question: String, mode: String): Boolean {
        return !(TextUtils.isEmpty(question) && TextUtils.isEmpty(mode))
    }
    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("YES") { _, _ ->
            mUserViewModel.deleteAllUsers()
            Toast.makeText(
                activity,
                "Successfully deleted",
                LENGTH_LONG).show()
        }
        builder.setNegativeButton("NO") { _, _ -> }
        builder.setTitle("Delete all questions?")
        builder.setMessage("Are your sure you want to delete all questions?")
        builder.create().show()
    }
}
