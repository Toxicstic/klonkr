package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class HomeDirections private constructor() {
  companion object {
    fun actionHomeToAbout(): NavDirections = ActionOnlyNavDirections(R.id.action_home_to_about)

    fun actionHomeToSettings(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_settings)

    fun actionHomeToSurvey(): NavDirections = ActionOnlyNavDirections(R.id.action_home_to_survey)

    fun actionHomeToQuestions(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_questions)
  }
}
