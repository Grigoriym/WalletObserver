package com.example.walletobserver.ui.add_record

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddRecordViewModel : ViewModel() {

  private val _currentExpression = MutableLiveData<String>()
  val currentExpression: LiveData<String>
    get() = _currentExpression

  private val _result = MutableLiveData<String>()
  val result: LiveData<String>
    get() = _result

  private var isNumberPositive = true

  private val STRING_COMMA = "."
  private val PERCENTAGE = "%"
  private val SCIENTIFIC_NOTATION_CHAR = "E"
  private val INFINITY = "Infinity"
  private val validOperators = listOf("+", "-", "/", "*")

  fun onOperatorAdd(addedValue:String){

  }

  fun onClearExpression(){

  }

  fun onCalculateResult(){

  }

  fun onExpressionSignChange(){

  }

  private fun currentExpressionIsInvalid(){
    
  }

  private fun isValueAnOperator(value: String): Boolean {
    return false
  }

  private fun clearLastValuefItIsAnOperator(){

  }

  private fun clearLastCharOfExpression(){

  }

  private fun getLastCharOfExpression():Char{
    return '1'
  }

  private fun isValueInteger(number:Double):Boolean{
    return false
  }

  private fun isScientificNotation(numberString:String):Boolean{
    return false
  }

}