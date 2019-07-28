package com.example.walletobserver.ui.add_record

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udojava.evalex.Expression
import timber.log.Timber
import java.math.BigDecimal
import kotlin.math.roundToInt

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

  fun onOperatorAdd(addedValue: String) {
    if (currentExpressionIsInvalid() &&
      (validOperators.contains(addedValue) || STRING_COMMA == addedValue || PERCENTAGE == addedValue)
    ) {
      Timber.d("Sth went wrong")
    } else {
      Timber.d("First stage")
      var isCommaAddedToExpressions = false
      if ((isValueAnOperator(addedValue) || addedValue == PERCENTAGE) &&
        _currentExpression.value!!.isNotEmpty()
      ) {
        Timber.d("Second stage")
        val lastCharacterOfExpression =
          _currentExpression.value!![_currentExpression.value!!.length - 1]
        if (isValueAnOperator(lastCharacterOfExpression.toString())) {
          clearLastCharOfExpression()
        }
      } else if (addedValue == STRING_COMMA) {
        Timber.d("Third stage")
        val expressionArray = _currentExpression.value!!.toCharArray()
        for (c in expressionArray) {
          if (c == STRING_COMMA.toCharArray()[0]) {
            Timber.d("Fourth stage")
            isCommaAddedToExpressions = true
          }
          if (validOperators.contains(c.toString())) {
            Timber.d("Fifth stage")
            isCommaAddedToExpressions = false
          }
        }
        val lastCharacterOfExpression =
          _currentExpression.value!![_currentExpression.value!!.length - 1]
        if (validOperators.contains(lastCharacterOfExpression.toString())) {
          Timber.d("Sixth stage")
          isCommaAddedToExpressions = true
        }
      }
      if (!isCommaAddedToExpressions) {
        Timber.d("Seventh stage")
        if (_currentExpression.value == null) {
          Timber.d("Eighth stage")
          _currentExpression.postValue(addedValue)
        } else {
          Timber.d("Ninth stage")
          _currentExpression.postValue(_currentExpression.value + addedValue)
        }
      }
    }
    _result.postValue(_currentExpression.value)
  }

  fun onClearExpression() {
    Timber.d("onClearExpression")
    _currentExpression.postValue("")
    _result.postValue("")
  }

  fun onCalculateResult() {
    Timber.d("onCalculateResult")
    if (_currentExpression.value == null || _currentExpression.value!!.contains(INFINITY) ||
      _currentExpression.value!!.isEmpty()
    ) {
      Timber.d("Sth went wrong - v2")
    } else {
      clearLastValueIfItIsAnOperator()
      _currentExpression.value = _currentExpression.value!!.replace(PERCENTAGE.toRegex(), "/100")
      val expression = Expression(_currentExpression.value!!)
      val bigDecimalResult = expression.eval()
      val doubleResult = bigDecimalResult.toDouble()
      val stringResult: String
      stringResult =
        if (isValueInteger(doubleResult) && !isScientificNotation(doubleResult.toString())) {
          val roundedValue = doubleResult.roundToInt()
          roundedValue.toString()
        } else {
          doubleResult.toString()
        }
      _currentExpression.postValue(stringResult)
      _result.postValue(stringResult)
    }
  }

  fun onExpressionSignChange() {
    Timber.d("onExpressionSignChange")
    if (currentExpressionIsInvalid()) {
      Timber.d("Sth went wrong - V3")
    } else {
      val newCurrentExpression = if (isNumberPositive) "-${_currentExpression.value}"
      else _currentExpression.value!!.substring(1, _currentExpression.value!!.length)

      _currentExpression.postValue(newCurrentExpression)
      isNumberPositive = !isNumberPositive
    }
  }

  private fun currentExpressionIsInvalid() = _currentExpression.value.isNullOrEmpty()

  private fun isValueAnOperator(value: String): Boolean =
    validOperators.contains(value.toCharArray()[0].toString())

  private fun clearLastValueIfItIsAnOperator() {
    Timber.d("clearLastValueIfItIsAnOperator")
    if (currentExpressionIsInvalid()) {
      Timber.d("Sth went wrong - V4")
    } else if (isValueAnOperator(getLastCharOfExpression().toString())) {
      clearLastCharOfExpression()
    }
  }

  private fun clearLastCharOfExpression() {
    Timber.d("clearLastCharOfExpression")
    _currentExpression.postValue(
      _currentExpression.value!!.substring(
        0,
        _currentExpression.value!!.length - 1
      )
    )
  }

  private fun getLastCharOfExpression(): Char {
    Timber.d("getLastCharOfExpression")
    val currentExpressionLastValuePosition = _currentExpression.value!!.length - 1
    return _currentExpression.value!![currentExpressionLastValuePosition]
  }

  private fun isValueInteger(number: Double): Boolean {
    Timber.d("isValueInteger")
    val roundedValue = number.roundToInt()
    return number % roundedValue == 0.0
  }

  private fun isScientificNotation(numberString: String): Boolean {
    try {
      BigDecimal(numberString)
    } catch (e: NumberFormatException) {
      return false
    }
    return numberString.toUpperCase().contains(SCIENTIFIC_NOTATION_CHAR)
  }

}