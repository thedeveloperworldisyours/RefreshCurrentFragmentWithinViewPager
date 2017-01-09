package com.thedeveloperworldisyours.refreshcurrentfragment.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.thedeveloperworldisyours.refreshcurrentfragment.R;

public class SecondFragment extends Fragment {

    ImageView mImageView;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        mImageView = (ImageView) view.findViewById(R.id.fragment_second_image_view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        onAnimation();
    }

    public void onAnimation() {

        ObjectAnimator animY = ObjectAnimator.ofFloat(mImageView, "y", 100f);
        ObjectAnimator animYSecond = ObjectAnimator.ofFloat(mImageView, "y", -10f);
        animY.setDuration(1000);
        animYSecond.setDuration(1000);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.play(animY).before(animYSecond);
        animSetXY.start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
