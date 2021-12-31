package com.jdm.toursamcheok.response.state

sealed class BaseState {
    object Uninitialized: BaseState()

    object Loading: BaseState()

    data class Error(
        val error: Throwable
    ) : BaseState()

    data class Success<T>(
        val resp: T
    ): BaseState()
    data class Fail<T>(
        val resp: T
    ): BaseState()
}
