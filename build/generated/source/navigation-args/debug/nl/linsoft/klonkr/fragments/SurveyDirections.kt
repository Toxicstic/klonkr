package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class SurveyDirections private constructor() {
  companion object {
    fun actionSurveyToSurveyEnd(): NavDirections =
        ActionOnlyNavDirections(R.id.action_survey_to_surveyEnd)
  }
}
