package com.grappim.walletobserver.di.component

import com.grappim.walletobserver.di.module.DaggerModule
import com.grappim.walletobserver.ui.intro.IntroActivity
import dagger.Component

@Component(modules = [DaggerModule::class])
interface DaggerComponent {

  fun inject(introActivity: IntroActivity)

}