package nl.linsoft.klonkr.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_credits.view.*
import nl.linsoft.klonkr.R

class Credits : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_credits, container, false)
        view.creditsReturnButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_credits_to_about)
        }
        return view

    }
}
