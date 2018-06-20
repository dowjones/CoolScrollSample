package com.jordan.coolscroll;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CoolFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = container.getContext();
        RecyclerView layout = (RecyclerView) inflater.inflate(R.layout.cool_fragment, container, false);
        layout.setAdapter(new CoolAdapter());

        if (getArguments() != null) {
            int position = getArguments().getInt("position");
            switch (position) {
                case 0:
                    LinearLayoutManager linearLayoutManagerNoSmooth = new LinearLayoutManager(context);
                    layout.setLayoutManager(linearLayoutManagerNoSmooth);
                    linearLayoutManagerNoSmooth.setSmoothScrollbarEnabled(false);
                    linearLayoutManagerNoSmooth.isSmoothScrollbarEnabled();
                    return layout;
                case 1:
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setSmoothScrollbarEnabled(true);
                    layout.setLayoutManager(linearLayoutManager);
                    return layout;
                case 2:
                    CoolLayoutManager coolLayoutManager = new CoolLayoutManager(context);
                    layout.setLayoutManager(coolLayoutManager);
                    return layout;
            }

        }

        return layout;
    }

}
