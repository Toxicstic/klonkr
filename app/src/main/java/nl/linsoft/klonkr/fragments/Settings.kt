package nl.linsoft.klonkr.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_settings.view.*
import nl.linsoft.klonkr.R


class Settings : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        view.settingsReturnButton.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_settings_to_home)
        }
        view.settingsEditQuestions.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_settings_to_questions)
        }

        return view
    }
}
