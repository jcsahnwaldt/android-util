package jcsahnwaldt.android.animation

import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener

class OnAnimationStartListener(private val lambda: (Animation) -> Unit) : AnimationListener {

    override fun onAnimationStart(animation: Animation) {
        lambda(animation)
    }

    override fun onAnimationRepeat(animation: Animation) {}
    override fun onAnimationEnd(animation: Animation) {}
}