package com.mrizkyyuhari.samsung;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mrizkyyuhari.samsung.adapter.MusicPlayerAdapter;
import com.mrizkyyuhari.samsung.model.MusicDataModel;
import com.mrizkyyuhari.samsung.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicPlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicPlayerFragment extends Fragment implements MusicPlayerAdapter.MusicListener {

    private RecyclerView recyclerView;
    private MusicPlayerAdapter musicPlayerAdapter;
    private List<MusicModel> musicModelArrayList = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MusicPlayerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicPlayerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicPlayerFragment newInstance(String param1, String param2) {
        MusicPlayerFragment fragment = new MusicPlayerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);
        recyclerView= view.findViewById(R.id.rv_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        musicModelArrayList.addAll(MusicDataModel.MusicPlayer());
        showGridProjek();
        return view;
    }

    private void showGridProjek() {

        MusicPlayerAdapter gridProjekAdapter = new MusicPlayerAdapter(musicModelArrayList,this);
        recyclerView.setAdapter(gridProjekAdapter);
    }


    @Override
    public void musicClick(int position) {

        musicModelArrayList.get(position);
        Intent intent = new Intent(getContext(),MusicController.class);
        intent.putExtra("position",String.valueOf(position));
        startActivity(intent);
    }
}