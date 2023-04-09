package jcsahnwaldt.android.animation

import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener

class OnAnimationEndListener(private val lambda: (Animation) -> Unit) : AnimationListener {

    override fun onAnimationEnd(animation: Animation) {
        lambda(animation)
    }

    override fun onAnimationStart(animation: Animation) {}
    override fun onAnimationRepeat(animation: Animation) {}
}