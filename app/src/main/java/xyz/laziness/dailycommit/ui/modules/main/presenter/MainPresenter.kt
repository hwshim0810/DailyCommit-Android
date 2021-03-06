package xyz.laziness.dailycommit.ui.modules.main.presenter

import xyz.laziness.dailycommit.ui.base.presenter.BasePresenter
import xyz.laziness.dailycommit.ui.modules.main.interactor.MainInteractor
import xyz.laziness.dailycommit.ui.modules.main.view.MainView


interface MainPresenter<V: MainView, I: MainInteractor> : BasePresenter<V, I> {

    fun userInfoRequest()

    fun onDrawerLogoutItemClick()

    fun setUserStatusDisplay(): Unit?

    fun onAddFriendDialogOkClick(friendName: String)

}