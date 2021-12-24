package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class SettingsDirections private constructor() {
  companion object {
    fun actionSettingsToHome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settings_to_home)

    fun actionSettingsToQuestions(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settings_to_questions)
  }
}
