package com.example.courses.data

import com.example.courses.R
import org.junit.Assert.assertEquals
import org.junit.Test

class DataSourceTest {
    @Test
    fun topicsMatchTheExercise() {
        assertEquals(14, DataSource.topics.size)
        assertEquals(14, DataSource.topics.map { it.name }.distinct().size)
        assertEquals(14, DataSource.topics.map { it.imageRes }.distinct().size)
        assertEquals(
            listOf(58, 121, 78, 118, 423, 92, 165, 164, 326, 305, 212, 172, 321, 118),
            DataSource.topics.map { it.availableCourses }
        )
        assertEquals(R.string.architecture, DataSource.topics.first().name)
        assertEquals(R.string.tech, DataSource.topics.last().name)
    }
}
