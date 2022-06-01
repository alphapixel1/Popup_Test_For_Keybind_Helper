package com.example.popuptestforkeybindhelper

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //show button
        val button=findViewById<Button>(R.id.button2)

        val TVs=ArrayList<TextView>()
        for (id in arrayOf(R.id.nameTextView,R.id.KB1TextView,R.id.KB2TextView,R.id.KB3TextView))
            TVs.add(findViewById(id))
        button.setOnClickListener{


            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.edit_keybind_dialog)

            dialog.show()



            //clear buttons
            val clears= arrayOf(0,R.id.EditKeybind_Clear1,R.id.EditKeybind_Clear2,R.id.EditKeybind_Clear3)
            //dialog text views
            val texts= arrayOf(R.id.EditKeybind_Name,R.id.EditKeybind_KB1,R.id.EditKeybind_KB2,R.id.EditKeybind_KB3)

            //loading current text
            for(i in 0..3)
                dialog.findViewById<TextView>(texts[i]).text=TVs[i].text

            //clear button clicks
            for (i in 1..3){
                println(i)
                dialog.findViewById<ImageButton>(clears[i]).setOnClickListener{
                    dialog.findViewById<TextView>(texts[i]).text=""
                }
            }

            //done button
            val doneButton=dialog.findViewById<Button>(R.id.EditKeybindDoneButton)
            doneButton.setOnClickListener{
                //nameTV.text=dialog.findViewById<TextView>(R.id.EditKeybind_Name).text
                for (i in 0..3)
                    TVs[i].text=dialog.findViewById<TextView>(texts[i]).text
                dialog.cancel()
            }

            //cancel button
            val cancelButton=dialog.findViewById<Button>(R.id.EditKeybindCancelButton)
            cancelButton.setOnClickListener{
                dialog.cancel()
            }

        }
    }
}
