package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vamshi on 6/11/2017.
 */

public class BodyPartFragment extends Fragment {

    private List<Integer> imageIDs;
    private int index;

    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if(savedInstanceState!= null){
            imageIDs = savedInstanceState.getIntegerArrayList("IMAGE_ID");
            index = savedInstanceState.getInt("INDEX");
        }

        View rootView = inflater.inflate(R.layout.body_part_fragment, container, false);
        final ImageView body_part_image = (ImageView)rootView.findViewById(R.id.body_part_fragment);
        body_part_image.setImageResource(imageIDs.get(index));

        body_part_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index == imageIDs.size()-1){
                    index = 0;
                    body_part_image.setImageResource(imageIDs.get(index));
                }else{
                    index ++;
                    body_part_image.setImageResource(imageIDs.get(index));
                }
            }
        });

        return rootView;
    }

    public void setImageIDs(List<Integer> imageIDs) {
        this.imageIDs = imageIDs;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putIntegerArrayList("IMAGE_ID", (ArrayList<Integer>)imageIDs);
        outState.putInt("INDEX", index);

        super.onSaveInstanceState(outState);
    }
}
