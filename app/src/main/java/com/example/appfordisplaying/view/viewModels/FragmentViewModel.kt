package com.example.appfordisplaying.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfordisplaying.view.repository.ListUseCase
import com.example.appfordisplaying.view.models.Item
import kotlinx.coroutines.launch

class FragmentViewModel(private val listUseCase: ListUseCase): ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    fun loadItemList() {
        viewModelScope.launch {
            try {
                _itemList.value = listUseCase.loadItemList()
            }
            catch (e: Exception){
                _itemList.value = listOf(Item(0, "${e.message}",""))
            }
        }
    }
}