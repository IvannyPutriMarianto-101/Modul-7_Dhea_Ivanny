package com.example.modu7

import android.database.Cursor
import com.example.modu7.data.Homework
import com.example.modu7.database.DatabaseContract

object MappingHelper {

    fun mapCursorToArrayList(homeworkCursor: Cursor?): ArrayList<Homework> {
        val homeworkList = ArrayList<Homework>()

        homeworkCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns.DATE))
                homeworkList.add(Homework(id, title, description, date))
            }
        }
        return homeworkList
    }
}