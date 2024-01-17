package com.mohammedfares.phones.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.MohammedFares.ecomerce_project.comon.Resource
import com.mohammedfares.phones.data.Phone
import com.mohammedfares.phones.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val repo: Repository
): ViewModel() {

    private val _phonesListMutable = MutableStateFlow<List<Phone>>(emptyList())
    val phonesListMutable = _phonesListMutable.asStateFlow()

    private val _namesMutableStateFlow = MutableStateFlow<List<String>>(emptyList())
    val namesStateFlow = _namesMutableStateFlow.asStateFlow()


    private val _addStaeFlow = MutableStateFlow<Resource<Long>>(Resource.Empty())
    val addStateFlow = _addStaeFlow.asStateFlow()


    init {
        getAll()
    }

    fun getAll() {
        viewModelScope.launch {
            _phonesListMutable.value = repo.getAll()
        }
    }

    fun getNames(name: String) {
        viewModelScope.launch {
            _namesMutableStateFlow.value = repo.search(name)
        }
    }

    fun addPhone(phone: Phone) {
        viewModelScope.launch {
            val created = repo.create(phone)

            if (created != (-1).toLong()){
                _addStaeFlow.value = Resource.Success(created)
            } else {
                _addStaeFlow.value = Resource.Error("fail to add")
            }
        }
    }


}