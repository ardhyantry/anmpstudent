package com.ubaya.studentproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.studentproject.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch(studentId: String) {
        val students = listOf(
            Student("16055", "Nonie", "1998/03/28", "5718444778",
                "http://dummyimage.com/75x100.jpg/cc0000/ffffff"),
            Student("13312", "Rich", "1994/12/14", "3925444073",
                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff"),
            Student("11204", "Dinny", "1994/10/07", "6827808747",
                "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
        )

        studentLD.value = students.find { it.id == studentId }
    }


}
