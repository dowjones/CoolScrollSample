/*
Copyright 2018 Dow Jones & Company, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.jordan.coolscroll;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class CoolLayoutManager extends LinearLayoutManager {
    private static final int SMOOTH_VALUE = 100;

    CoolLayoutManager(Context context) {
        super(context);
        setSmoothScrollbarEnabled(false);
    }

    //Computes the vertical size of the scrollbar indicator (thumb)
    @Override
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        final int count = getChildCount();
        if (count > 0) {
            return SMOOTH_VALUE * 3;
        }
        return 0;
    }

    //Computes the vertical size of all the content (scrollbar track)
    @Override
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return Math.max((getItemCount() - 1) * SMOOTH_VALUE, 0);
    }

    //Computes the vertical distance from the top of the screen (scrollbar position)
    @Override
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        final int count = getChildCount();

        if (count <= 0) {
            return 0;
        }
        if (findLastCompletelyVisibleItemPosition() == getItemCount() - 1) {
            return Math.max((getItemCount() - 1) * SMOOTH_VALUE, 0);
        }

        int heightOfScreen;
        int firstPos = findFirstVisibleItemPosition();
        if (firstPos == RecyclerView.NO_POSITION) {
            return 0;
        }
        View view = findViewByPosition(firstPos);
        if (view == null) {
            return 0;
        }
        // Top of the view in pixels
        final int top = getDecoratedTop(view);
        int height = getDecoratedMeasuredHeight(view);
        if (height <= 0) {
            heightOfScreen = 0;
        } else {
            heightOfScreen = Math.abs(SMOOTH_VALUE * top / height);
        }
        if (heightOfScreen == 0 && firstPos > 0) {
            return SMOOTH_VALUE * firstPos - 1;
        }
        return (SMOOTH_VALUE * firstPos) + heightOfScreen;
    }
}
