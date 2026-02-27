package com.example.taskmax

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Data class for list items

data class Person(
    val id: Int,
    val name: String,
    val email: String

)

// Search view component
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    hint: String = "Search...",
    onQueryChange: (String) -> Unit

) {

    var query by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query,
        onValueChange = { newQuery ->
            query = newQuery

            onQueryChange(newQuery)

        },

        modifier = modifier

            .fillMaxWidth()

            .padding(16.dp),

        placeholder = {

            Text(

                text = hint,

                color = Color.Gray

            )

        },

        leadingIcon = {

            Icon(

                imageVector = Icons.Default.Search,

                contentDescription = "Search Icon",

                tint = Color.Gray

            )

        },

        trailingIcon = {

            if (query.isNotEmpty()) {

                IconButton(

                    onClick = {

                        query = ""

                        onQueryChange("")

                    }

                ) {

                    Icon(

                        imageVector = Icons.Default.Clear,

                        contentDescription = "Clear Icon",

                        tint = Color.Gray

                    )

                }

            }

        },

        singleLine = true,

        shape = RoundedCornerShape(12.dp),

        colors = TextFieldDefaults.outlinedTextFieldColors(

            focusedBorderColor = MaterialTheme.colorScheme.primary,

            unfocusedBorderColor = Color.Gray

        )

    )

}



// Filterable list component

@Composable

fun FilterableList(

    items: List,

    query: String

) {

    val filteredItems = remember(query, items) {

        if (query.isEmpty()) {

            items

        } else {

            items.filter { item ->

                item.name.contains(query, ignoreCase = true) ||

                        item.email.contains(query, ignoreCase = true)

            }

        }

    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {

        items(filteredItems) { person ->
            PersonCard(person = person)

        }

    }

}



// Card component for each person

@Composable

fun PersonCard(person: Int) {
    ElevatedCard (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),

        elevation = CardDefaults.cardElevation()

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()

        ) {

            Text(
                text = person.name,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = person.email,
                style = MaterialTheme.typography.bodyMedium,

                color = Color.Gray

            )

        }

    }

}



// Main screen composable

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable

fun SearchScreen() {

    var searchQuery by remember { mutableStateOf("") }



    // Sample data

    val people = remember {
        listOf(
            Person(1, "John Doe", "john.doe@example.com"),
            Person(2, "Jane Smith", "jane.smith@example.com"),
            Person(3, "Bob Johnson", "bob.johnson@example.com"),

            Person(4, "Alice Brown", "alice.brown@example.com"),

            Person(5, "Charlie Wilson", "charlie.wilson@example.com")

        )

    }



    Column(

        modifier = Modifier

            .fillMaxSize()
            .background(Color.White)

    ) {

        // Top app bar

        TopAppBar(
            title = { Text("Search People") },
            colors = TopAppBarColors(

                containerColor = MaterialTheme.colorScheme.primary,
                scrolledContainerColor = Color.White,
                navigationIconContentColor = Color.Green,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            )



        // Search view

        SearchView(
            hint = "Search by task name...",
            onQueryChange = { query ->
                searchQuery = query
            }
        )



        // Filtered list

        FilterableList(
            items = people,
            query = searchQuery
        )
    }
}



// Optional: Add animations

@Composable

fun AnimatedFilterableList(
    items: List,
    query: String

) {

    val filteredItems = remember(query, items) {
        if (query.isEmpty()) {
            items
        } else {
            items.filter {item ->
                item.name.contains(query, ignoreCase = true) ||
                        item.email.contains(query, ignoreCase = true)
            }
        }
    }



    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(filteredItems) { person ->
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()

            ) {

                PersonCard(person = person)

            }

        }

    }

}