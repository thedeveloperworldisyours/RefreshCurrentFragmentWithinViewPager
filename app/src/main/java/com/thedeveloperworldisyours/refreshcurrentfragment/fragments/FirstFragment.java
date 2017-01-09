package com.thedeveloperworldisyours.refreshcurrentfragment.fragments;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.thedeveloperworldisyours.refreshcurrentfragment.R;

public class FirstFragment extends Fragment {
    RelativeLayout mView;
    Context mContext;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mView = (RelativeLayout) view.findViewById(R.id.fragment_first_view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        onAnimationStart();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public void onAnimationStart() {
        Log.d("FirstFragment","onAnimationStart()");

        // get the center for the clipping circle
        int cx = (mView.getRight());
        int cy = (mView.getBottom());

        // get the final radius for the clipping circle
        int finalRadius = Math.max(mView.getWidth(), mView.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(mView, cx, cy, 0, finalRadius);
        anim.setDuration(1000);

        // make the view visible and start the animation
        mView.setVisibility(View.VISIBLE);
        anim.start();
    }

}
