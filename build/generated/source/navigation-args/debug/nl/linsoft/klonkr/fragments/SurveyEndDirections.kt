package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class SurveyEndDirections private constructor() {
  companion object {
    fun actionSurveyEndToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_surveyEnd_to_home)
  }
}
