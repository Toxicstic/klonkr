package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class AboutDirections private constructor() {
  companion object {
    fun actionAboutToHome(): NavDirections = ActionOnlyNavDirections(R.id.action_about_to_home)

    fun actionAboutToCredits(): NavDirections =
        ActionOnlyNavDirections(R.id.action_about_to_credits)
  }
}
