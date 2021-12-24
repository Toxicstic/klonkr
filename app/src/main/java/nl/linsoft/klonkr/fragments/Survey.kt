package nl.linsoft.klonkr.fragments

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_questions.view.*
import kotlinx.android.synthetic.main.fragment_survey.view.*
import nl.linsoft.klonkr.R
import nl.linsoft.klonkr.data.UserViewModel
import nl.linsoft.klonkr.recyclerview.QuestionsAdapter
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class Survey : Fragment() {

    private var c: Date = Calendar.getInstance().time
    private var df: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    private var formattedDate: String = df.format(c)
    private val fileName = "$formattedDate.txt"
    private lateinit var mUserViewModel: UserViewModel
    private var ansList: ArrayList<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //recyclerView
        val recyclerView = view?.questionsQuestions
        recyclerView?.adapter = QuestionsAdapter()
        recyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            if (recyclerView != null) {
                (recyclerView.adapter as QuestionsAdapter).setData(user)
            }
        })

        //Init
        val view = inflater.inflate(R.layout.fragment_survey, container, false)
        var counter = 0

        //survey button logic
        view.surveyYes.setOnClickListener {
            if (mUserViewModel.readAllData.value?.size!! <= counter) {
                ansList.add("Yes")
                save()
                Navigation.findNavController(view).navigate(R.id.action_survey_to_surveyEnd)
            } else {
                view?.surveyQuestion?.text = loadQuestion(counter)
                counter += 1
                ansList.add("Yes")
            }

        }
        view.surveyNo.setOnClickListener {
            if (mUserViewModel.readAllData.value?.size!! <= counter) {
                ansList.add("No")
                save()
                Navigation.findNavController(view).navigate(R.id.action_survey_to_surveyEnd)
            } else {
                view?.surveyQuestion?.text = loadQuestion(counter)
                counter += 1
                ansList.add("No")
            }
        }
        view.surveyForwardButton.setOnClickListener {
            val answer = view.surveyAnswerField.text.toString()

            when {
                mUserViewModel.readAllData.value?.size!! <= counter -> {
                    ansList.add(answer)
                    println(ansList)
                    save()
                    Navigation.findNavController(view).navigate(R.id.action_survey_to_surveyEnd)
                }
                counter == 0 -> {
                    view?.surveyQuestion?.text = loadQuestion(counter)
                    counter += 1
                }
                answer.isBlank() -> {
                    Toast.makeText(
                        requireContext(),
                        "Please give a valid answer to the question!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    view?.surveyQuestion?.text = loadQuestion(counter)
                    ansList.add(answer)
                    counter += 1
                }
            }
        }

        return view
    }

    private fun isExternalStorageWritable(): Boolean {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            Log.i("State", "Yes, it is writable!")
            true
        } else {
            false
        }
    }

    private fun checkPermission(permission: String?): Boolean {
        val check = ContextCompat.checkSelfPermission(requireContext(), permission!!)
        return check == PackageManager.PERMISSION_GRANTED
    }

    private fun save() =
        if(isExternalStorageWritable() && checkPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            val textFile = File(
                requireContext().getExternalFilesDir("/answers/"),
                fileName
            )
        try{
            val text: String = ansList.joinToString("\n")
            val fos = FileOutputStream(textFile)
            fos.write(text.toByteArray())
            fos.close()
            Toast.makeText(requireContext(), "File Saved!", LENGTH_LONG).show()
        }catch (e: IOException) {
            Log.i("STATUS","EXTERNAL STORAGE ERROR")
            e.printStackTrace()
        }} else {
            Toast.makeText(requireContext(), "Whoops, could not save the file!", LENGTH_LONG).show()
        }

    private fun loadQuestion(index: Int): String {
        val mode = mUserViewModel.readAllData.value?.get(index)?.mode.toString()
        val prefix = mUserViewModel.readAllData.value?.get(index)?.question.toString()
        if (mode == "true") {
            view?.surveyAnswerField?.isVisible = false
            view?.surveyYes?.isVisible = true
            view?.surveyNo?.isVisible = true
            view?.surveyForwardButton?.isVisible = false
        } else {
            view?.surveyAnswerField?.isVisible = true
            view?.surveyYes?.isVisible = false
            view?.surveyNo?.isVisible = false
            view?.surveyForwardButton?.isVisible = true
        }
        view?.surveyAnswerField?.setText("")
        return prefix
    }
}