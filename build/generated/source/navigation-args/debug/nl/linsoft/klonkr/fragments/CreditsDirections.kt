package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class CreditsDirections private constructor() {
  companion object {
    fun actionCreditsToAbout(): NavDirections =
        ActionOnlyNavDirections(R.id.action_credits_to_about)
  }
}
