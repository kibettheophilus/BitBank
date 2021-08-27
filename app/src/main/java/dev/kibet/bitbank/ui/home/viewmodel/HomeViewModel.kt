package dev.kibet.bitbank.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kibet.bitbank.repository.HomeRepository
import javax.inject.Inject


class HomeViewModel (
    private val homeRepository: HomeRepository
): ViewModel() {
}