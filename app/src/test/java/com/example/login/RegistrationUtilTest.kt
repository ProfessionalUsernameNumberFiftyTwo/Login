package com.example.login

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    // methodName_someCondition_expectedResult
    @Test
    fun validatePassword_emptyPassword_returnsFalse() {
        var result = RegistrationUtil.validatePassword("", "")
        // assertThat(actualValue).isEqual(desiredValue)
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDoNotMatch_returnsFalse() {
        var result = RegistrationUtil.validatePassword("13Salads", "sdalaS31")
        assertThat(result).isFalse()
    }

    // Make tests for failures of
        // min 8 chars
        // at least one digit
        // at least one capital letter
    // Make a test for a good matching password that works

    @Test
    fun validatePassword_passwordTooShort_returnsFalse() {
        var result = RegistrationUtil.validatePassword("Small02", "Small02")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordNoDigit_returnsFalse() {
        var result = RegistrationUtil.validatePassword("NoNumber", "NoNumber")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordNoCaps_returnFalse() {
        var result = RegistrationUtil.validatePassword("12monkeys", "12monkeys")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_goodMatchingPassword_returnTrue() {
        var result = RegistrationUtil.validatePassword("32BigSaladsAndSandwiches", "32BigSaladsAndSandwiches")
        assertThat(result).isTrue()
    }

}