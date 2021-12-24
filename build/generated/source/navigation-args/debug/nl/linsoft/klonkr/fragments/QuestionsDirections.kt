package nl.linsoft.klonkr.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import nl.linsoft.klonkr.R

class QuestionsDirections private constructor() {
  companion object {
    fun actionQuestionsToSettings(): NavDirections =
        ActionOnlyNavDirections(R.id.action_questions_to_settings)
  }
}
