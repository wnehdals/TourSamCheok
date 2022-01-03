package com.jdm.toursamcheok.response.state

sealed class BaseState {
    object Uninitialized: BaseState()

    object Loading: BaseState()

    object Error: BaseState()

    object Success: BaseState()
    object Fail: BaseState()
}
