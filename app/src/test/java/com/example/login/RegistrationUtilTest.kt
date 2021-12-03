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
        var result = RegistrationUtil.validatePassword("32BigSaladsAndASandwich", "32BigSaladsAndASandwich")
        assertThat(result).isTrue()
    }

    @Test
    fun validateName_emptyName_returnsFalse() {
        var result = RegistrationUtil.validateName("")
        assertThat(result).isFalse()
    }

    @Test
    fun validateName_goodName_returnsTrue() {
        var result = RegistrationUtil.validateName("Paul Simon")
        assertThat(result).isTrue()
    }

    @Test
    fun validateUserName_emptyUsername_returnsFalse() {
        var result = RegistrationUtil.validateUserName("", "Pablo")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUserName_usedUsername_returnsFalse() {
        var result = RegistrationUtil.validateUserName("ToadForSteam", "Pablo")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUserName_tooShort_returnsFalse() {
        var result = RegistrationUtil.validateUserName("AllDone", "Pablo")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUserName_usesRealName_returnsFalse() {
        var result = RegistrationUtil.validateUserName("Pablo1234", "Pablo")
        assertThat(result).isFalse()
    }

    @Test
    fun validateUserName_goodUsername_returnsTrue() {
        var result = RegistrationUtil.validateUserName("TheLargeMan", "Pablo")
        assertThat(result).isTrue()
    }

    @Test
    fun validateEmail_emptyEmail_returnsFalse() {
        var result = RegistrationUtil.validateEmail("")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_usedEmail_returnsFalse() {
        var result = RegistrationUtil.validateEmail("bob@bob.bob")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_noAtSymbolOrPeriod_returnsFalse() {
        var result = RegistrationUtil.validateEmail("saladTongs")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_noAtSymbol_returnsFalse() {
        var result = RegistrationUtil.validateEmail("salad.Tongs")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_noPeriodAfterAtSymbol_returnsFalse() {
        var result = RegistrationUtil.validateEmail("sal.lad@Tongs")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_noDomain_returnsFalse() {
        var result = RegistrationUtil.validateEmail("saladTongs@.com")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_hasSpace_returnsFalse() {
        var result = RegistrationUtil.validateEmail("salad Tongs@meme.org")
        assertThat(result).isFalse()
    }

    @Test
    fun validateEmail_goodEmail_returnsTrue() {
        var result = RegistrationUtil.validateEmail("sand.wich@yah.net")
        assertThat(result).isTrue()
    }
}