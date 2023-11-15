package com.example.khw2_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var set_drink: EditText
    private lateinit var rg1: RadioGroup
    private lateinit var rg2: RadioGroup
    private lateinit var btn_send: Button
    private var sugar = "無糖"
    private var ice_opt = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById(R.id.radioGroup)
        rg1.setOnCheckedChangeListener { _, i ->
            sugar = when (i) {
                R.id.radioButton1 -> "無糖"
                R.id.radioButton2 -> "少糖"
                R.id.radioButton3 -> "無糖"
                R.id.radioButton4 -> "全糖"
                else -> sugar
            }
        }

        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener { _, i ->
            ice_opt = when (i) {
                R.id.radioButton5 -> "去冰"
                R.id.radioButton6 -> "微冰"
                R.id.radioButton7 -> "少冰"
                R.id.radioButton8 -> "正常冰"
                else -> ice_opt
            }
        }

        btn_send = findViewById(R.id.btn_send)
        btn_send.setOnClickListener {
            set_drink = findViewById(R.id.ed_drink)
            val drink = set_drink.text.toString()
            val intent = Intent()
            val b = Bundle()
            b.putString("drink", drink)
            b.putString("sugar", sugar)
            b.putString("ice", ice_opt)
            intent.putExtras(b)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}