package in.nitjsr.ojass19.Fragments.MajorEventsFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import in.nitjsr.ojass19.Adapters.SubEventsAdapter;
import in.nitjsr.ojass19.R;

import static in.nitjsr.ojass19.Utils.Constants.EventList;

public class RiseOfMachines extends Fragment {
    List<String> subEvents = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.riseofmachines,container,false);
        RecyclerView rView = view.findViewById(R.id.rview);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));
        rView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation));
        SubEventsAdapter mAdapter = new SubEventsAdapter(getSubEvents());
        mAdapter.notifyDataSetChanged();
        rView.scheduleLayoutAnimation();
        rView.setAdapter(mAdapter);
        rView.setAdapter(mAdapter);
        return view;
    }
    List<String> getSubEvents(){
        subEvents.clear();
        for(int i = 0;i<EventList[0].length;i++){
            subEvents.add(EventList[0][i]);
        }
        Log.e("TAG",subEvents.toString());
        return subEvents;
    }
}