package com.mohammedfares.phones.ui

import androidx.lifecycle.ViewModel
import com.mohammedfares.phones.data.Phone
import com.mohammedfares.phones.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val repo: Repository
): ViewModel() {

    private val _phonesListMutable = MutableStateFlow<List<Phone>>(emptyList())
    val phonesListMutable = _phonesListMutable.asStateFlow()


    init {
        _phonesListMutable.value = repo.getAll()
    }
}