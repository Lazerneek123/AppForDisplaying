package com.example.appfordisplaying.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfordisplaying.view.models.Item
import com.example.appfordisplaying.view.repository.ListRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val listRepository: ListRepository = TODO()

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    fun loadList() {
        viewModelScope.launch {
            _itemList.value = listRepository.getItemList()
        }
    }
}