package com.db.williamchart.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import com.db.williamchart.data.ChartEntry


class VerticalAnimation(
        override val entries: MutableList<ChartEntry>,
        var start: Float) : ChartAnimation(entries) {

    override fun animate(callback: () -> Unit) : ChartAnimation{

        entries.forEach { entry ->
            val eAnimator: ObjectAnimator = ObjectAnimator.ofFloat(entry, "y", start, entry.y)
            eAnimator.duration = duration
            eAnimator.start()
        }
        val animator: ValueAnimator = ValueAnimator.ofInt(0,1)
        animator.addUpdateListener { callback.invoke() }
        animator.duration = duration
        animator.start()
        return this
    }
}