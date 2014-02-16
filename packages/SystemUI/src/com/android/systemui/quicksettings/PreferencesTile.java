/*
 * Copyright (C) 2012 The Android Open Source Project
 * Copyright (C) 2013 CyanogenMod Project
 * Copyright (C) 2013 The SlimRoms Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.quicksettings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.content.Intent;
import android.view.View;

import com.android.systemui.R;
import com.android.systemui.statusbar.phone.QuickSettingsController;

public class PreferencesTile extends QuickSettingsTile {

    private Context mContext;

    public PreferencesTile(Context context, QuickSettingsController qsc) {
        super(context, qsc);

        mContext = context;
        mOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSettingsActivity(android.provider.Settings.ACTION_SETTINGS);
            }
        };
    }

    @Override
    public void onFlingRight() {
        super.onFlingRight();
        Intent intent = new Intent();
                intent.setComponent(new ComponentName(
                        "org.androidx.settings",
                        "org.androidx.settings.SettingsActivity"));
                startSettingsActivity(intent);
    }

    @Override
    public void onFlingLeft() {
        super.onFlingLeft();
        Intent intent = new Intent();
                intent.setComponent(new ComponentName(
                        "org.androidx.settings",
                        "org.androidx.settings.SettingsActivity$QSSettingsActivity"));
                startSettingsActivity(intent);
    }

    @Override
    void onPostCreate() {
        updateTile();
        super.onPostCreate();
    }

    @Override
    public void updateResources() {
        updateTile();
        super.updateResources();
    }

    private synchronized void updateTile() {
        mDrawable = R.drawable.ic_qs_settings;
        mLabel = mContext.getString(R.string.quick_settings_settings_label);
    }
}
