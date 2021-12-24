package nl.linsoft.klonkr.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_about.view.*
import nl.linsoft.klonkr.R

class About : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about, container, false)
        view.aboutReturnButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_about_to_home)
        }
        view.aboutContactButton.setOnClickListener {
            Toast.makeText(activity, "Contact:\nDiscord: Cials#0179", LENGTH_LONG).show()
        }
        view.aboutCreditsButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_about_to_credits)
        }
        return view
    }
}