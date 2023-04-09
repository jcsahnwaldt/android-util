package jcsahnwaldt.android.animation

import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener

class OnAnimationRepeatListener(private val lambda: (Animation) -> Unit) : AnimationListener {

    override fun onAnimationRepeat(animation: Animation) {
        lambda(animation)
    }

    override fun onAnimationStart(animation: Animation) {}
    override fun onAnimationEnd(animation: Animation) {}
}