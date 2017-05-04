package com.example.helloworld.control;

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

        switch (this) {
            case Button:
                mappedClass = ButtonActivity.class;
                break;

            case CheckBox:
                mappedClass = CheckBoxActivity.class;
                break;

            case RadioButton:
                mappedClass = RadioButtonActivity.class;
                break;

            case ToggleButton:
                mappedClass = ToggleButtonActivity.class;
                break;

            case Spinner:
                mappedClass = SpinnerActivity.class;
                break;

            default:
                break;
        }

        return mappedClass;
    }
}
