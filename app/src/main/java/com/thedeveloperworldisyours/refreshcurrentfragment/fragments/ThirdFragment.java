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

public class ThirdFragment extends Fragment {

    Context mContext;
    ImageView mImageView;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        mImageView = (ImageView) view.findViewById(R.id.fragment_third_image_view);

        startObjectAnimator();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        startObjectAnimator();
    }

    public void startObjectAnimator() {

        ObjectAnimator animX = ObjectAnimator.ofFloat(mImageView, "x", 500f);
        ObjectAnimator animY = ObjectAnimator.ofFloat(mImageView, "y", 1000f);
        ObjectAnimator animXSecond = ObjectAnimator.ofFloat(mImageView, "x", 0f);
        ObjectAnimator animYSecond = ObjectAnimator.ofFloat(mImageView, "y", -10f);
        animX.setDuration(1000);
        animY.setDuration(1000);
        animXSecond.setDuration(1000);
        animYSecond.setDuration(1000);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.play(animX).with(animY).before(animXSecond).before(animYSecond);
        animSetXY.start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
