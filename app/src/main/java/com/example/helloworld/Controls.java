package com.example.helloworld;

/**
 * Created by meiliang on 23/04/2017.
 */

public enum Controls {

    TextView, Button, ToggleButton, CheckBox, RadioButton, CheckedTextView, Spinner, ProgressBar,
    SeekBar, QuickContactBadge, RatingBar, Switch, TextField, ImageButton, ImageView, VideoView,
    TimePicker, DatePicker, CalendarView, Chronometer, TextClock, CardView, RecycleView;

    @Override
    public String toString() {
        return this.name();
    }

    public Class<?> mappedClass() {
        Class<?> mappedClass = null;

        return mappedClass;
    }
}
