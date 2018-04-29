package ru.alexsumin.timer.timerapplication.util

import android.content.Context
import android.preference.PreferenceManager
import ru.alexsumin.timer.timerapplication.TimerActivity

class PrefUtil {
    companion object {
        fun getTimerLength(context: Context): Int {
            //placeHolder
            return 1
        }

        private const val PREVIOUS_TIMER_LENGTH_SECODNS_ID = "ru.alexsumin.timer.previous_timer_length_seconds"

        fun getPreviousTimerLengthSeconds(context: Context): Long {
            val prefences = PreferenceManager.getDefaultSharedPreferences(context)
            return prefences.getLong(PREVIOUS_TIMER_LENGTH_SECODNS_ID, 0)
        }

        fun setPreviousTimerLengthSeconds(seconds: Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(PREVIOUS_TIMER_LENGTH_SECODNS_ID, seconds)
            editor.apply()
        }

        private const val TIMER_STATE_ID = "ru.alexsumin.timer.timer_state"

        fun getTimerState(context: Context): TimerActivity.TimerState {
            val prefences = PreferenceManager.getDefaultSharedPreferences(context)
            val ordinal = prefences.getInt(TIMER_STATE_ID, 0)
            return TimerActivity.TimerState.values()[ordinal]

        }

        fun setTimerState(state: TimerActivity.TimerState, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            val ordinal = state.ordinal
            editor.putInt(TIMER_STATE_ID, ordinal)
            editor.apply()
        }

        private const val SECONDS_REMAINING_ID = "ru.alexsumin.timer.seconds_remaining"

        fun getSecondsRemaining(context: Context): Long {
            val prefences = PreferenceManager.getDefaultSharedPreferences(context)
            return prefences.getLong(SECONDS_REMAINING_ID, 0)
        }

        fun setSecondsRemaining(seconds: Long, context: Context) {
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(SECONDS_REMAINING_ID, seconds)
            editor.apply()
        }
    }
}