package com.example.cupcake.test


import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.cupcake.ui.SelectOptionScreen
import org.junit.Rule

import org.junit.Test

@get:Rule
val composeTestRule = createAndroidComposeRule<ComponentActivity>()

@Test
fun selectOptionScreen_verifyContent() {
    val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
    val subtotal = "$100"
    composeTestRule.setContent {
        SelectOptionScreen(subtotal = subtotal, options = flavors)
    }
    flavors.forEach { flavor ->
        composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
    }
    composeTestRule.onNodeWithText(
        composeTestRule.activity.getString(
            R.string.subtotal_price,
            subtotal
        )
    ).assertIsDisplayed()
    composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
}
