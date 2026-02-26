package com.example.taskmax.uiscreens

import android.provider.Contacts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(
    contacts: List<Contact>
    modifier: Modifier = Modifier
){
    Box(modifier) {
        val listState = rememberLazyListState()

        LazyColumn {
            state=listState,
            modifier = Modifier.fillMaxWidth(){
                //FIXME: This should be done in the Viewmodel
                val grouped = contacts.groupBy {it.firstName[0]}

                grouped.forEach {initial,contacts ->
                    stickyHeader {
                        characterHeader(char = inital, Modifier.fillParentMaxWidth())
                    }

                    items(contacts){
                        contact ->
                        ContactListItem(
                            contact = contact,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
