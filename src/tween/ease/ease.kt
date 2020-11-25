package com.kappalab.tween.ease

import android.view.animation.BaseInterpolator
import kotlin.math.*

/**
 * see also https://github.com/CreateJS/TweenJS/blob/master/src/tweenjs/Ease.js
 */

private const val PIf = PI.toFloat()

class SineIn : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = 1f - cos(input * PIf / 2f)
}

class SineOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = sin(input * PIf / 2f)
}

class SineInOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = -0.5f * (cos(PIf * input) - 1)
}

class QuadIn : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = input.pow(2)
}

class QuadOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowOut(input, 2)
}

class QuadInOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowInOut(input, 2)
}

class CubicIn : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = input.pow(3)
}

class CubicOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowOut(input, 3)
}

class CubicInOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowInOut(input, 3)
}

class QuartIn : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = input.pow(4)
}

class QuartOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowOut(input, 4)
}

class QuartInOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowInOut(input, 4)
}

class QuintIn : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = input.pow(5)
}

class QuintOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowOut(input, 5)
}

class QuintInOut : BaseInterpolator() {
    override fun getInterpolation(input: Float): Float = getPowInOut(input, 5)
}

private fun getPowOut(input: Float, exp: Int): Float {
    return 1f - (1f - input).pow(exp)
}

private fun getPowInOut(input: Float, exp: Int): Float {
    val n = input * 2f
    if (n < 1f) return 0.5f * n.pow(exp)
    return 1f - 0.5f * abs((2 - n).pow(exp))
}
