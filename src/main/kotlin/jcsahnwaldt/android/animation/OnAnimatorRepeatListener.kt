package jcsahnwaldt.android.animation

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.annotation.TargetApi

@TargetApi(11)
class OnAnimatorRepeatListener(private val lambda: (Animator) -> Unit) : AnimatorListener {

    override fun onAnimationRepeat(animator: Animator) {
        lambda(animator)
    }

    override fun onAnimationStart(animator: Animator) {}
    override fun onAnimationCancel(animator: Animator) {}
    override fun onAnimationEnd(animator: Animator) {}
}
