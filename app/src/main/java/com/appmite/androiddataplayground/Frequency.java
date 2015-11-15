package com.appmite.androiddataplayground;

import android.content.Context;

/*
 * Enum order must match order in repeat-frequency string
 * array in strings.xml
 */
public enum Frequency {

    Daily,
    Weekly,
    Monthly,
    Quarterly,
    Yearly;

    public String getLabel(Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.repeat_frequency);
        return (stringArray[this.ordinal()]);
    }
}