package com.example.courses

import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.unit.dp
import com.example.courses.ui.theme.CoursesTheme
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CoursesGridTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun firstTopicsShareARowAndLastTopicIsReachable() {
        composeRule.setContent {
            CoursesTheme { CoursesGrid(Modifier.height(240.dp)) }
        }
        val architecture = composeRule.onNodeWithContentDescription("Architecture, 58 courses")
        val crafts = composeRule.onNodeWithContentDescription("Crafts, 121 courses")
        architecture.assertIsDisplayed()
        crafts.assertIsDisplayed()
        val left = architecture.fetchSemanticsNode().boundsInRoot
        val right = crafts.fetchSemanticsNode().boundsInRoot
        assertEquals(left.top, right.top, 1f)
        assertTrue(left.right <= right.left)

        composeRule.onNode(hasScrollAction())
            .performScrollToNode(androidx.compose.ui.test.hasText("Tech"))
        composeRule.onNodeWithText("Tech").assertIsDisplayed()
        composeRule.onNodeWithContentDescription("Tech, 118 courses").assertIsDisplayed()
    }
}
