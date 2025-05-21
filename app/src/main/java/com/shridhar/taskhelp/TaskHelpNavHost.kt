package com.shridhar.taskhelp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shridhar.taskhelp.viewmodel.TaskViewModel


@Composable
fun TaskHelpNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            val viewModel: TaskViewModel = hiltViewModel()
            HomeScreen(viewModel = viewModel) {
                navController.navigate("create")
            }
        }

        composable("create") {
            val viewModel: TaskViewModel = hiltViewModel()
            CreateTaskScreen(viewModel = viewModel) {
                navController.popBackStack()
            }
        }
    }
}