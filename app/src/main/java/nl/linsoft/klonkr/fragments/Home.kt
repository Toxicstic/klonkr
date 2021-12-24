package nl.linsoft.klonkr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_questions.view.*
import nl.linsoft.klonkr.R
import nl.linsoft.klonkr.data.UserViewModel
import nl.linsoft.klonkr.recyclerview.QuestionsAdapter

class Home : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

        /*

        BUTTONS BUTTONS BUTTONS BUTTONS BUTTONS BUTTONS BUTTONS BUTTONS BUTTONS BUTTONS

         */
        val view = inflater.inflate(nl.linsoft.klonkr.R.layout.fragment_home, container, false)
        //homeText easter egg
        view.homeText.setOnClickListener {
            Toast.makeText(activity, "Yes, that's what the app is called, ain't it cool?!", LENGTH_SHORT).show()
        }
        //"i" about button -> about menu
        view.aboutButton.setOnClickListener {
            Navigation.findNavController(view).navigate(nl.linsoft.klonkr.R.id.action_home_to_about)
        }
        //"Take Survey" Button -> take survey fragment
        view.takeSurveyButton.setOnClickListener {
            val pass = mUserViewModel.readAllData.value?.size
            if (pass==0) {
                Toast.makeText(activity, "Make questions, donut!\nSettings > Edit Questions", LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_home_to_questions)
            } else {
                Navigation.findNavController(view).navigate(R.id.action_home_to_survey)
            }
        }
        //cogwheel icon settings button -> settings menu
        view.settingsButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_to_settings)
        }
        return view
    }
}