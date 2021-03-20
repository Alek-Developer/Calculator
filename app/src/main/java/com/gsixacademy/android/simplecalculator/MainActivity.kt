package com.gsixacademy.android.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.content_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Number Buttons*/

        btnOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        btnTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btnThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btnFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btnFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btnSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btnSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btnEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btnNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btnZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        btnAdd.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        btnSubtract.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        btnMultiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        btnDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        btnDecimal.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        btnClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

// Nedovrshena e funkcijata za Percentage (%) !!!
//        btnPercentage.setOnClickListener {
//            val percentage = (tvExpression * 100) / totalCount
//            if (tvResult.text.isNotEmpty())
//        }

        btnEqual.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {

                tvResult.text = result.toString()
            }
        }

        btnBack.setOnClickListener {
            val text = tvExpression.text.toString()
            if (text.isNotEmpty()) {
                tvExpression.text = text.drop(1)
            }

            tvResult.text = ""
        }
    }

    fun evaluateExpression(string: String, clear: Boolean) = if (clear) {
        tvResult.text = ""
        tvExpression.append(string)
    } else {
        tvExpression.append(tvResult.text)
        tvExpression.append(string)
        tvResult.text = ""
    }
}

