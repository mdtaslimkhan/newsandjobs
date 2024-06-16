package com.adsalam.android.newsjob.NewsFragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.adsalam.android.newsjob.JobsAdapter;
import com.adsalam.android.newsjob.NewsFeed;
import com.adsalam.android.newsjob.R;
import com.adsalam.android.newsjob.Word;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobsFragment extends Fragment {


    public JobsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.jobs_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("https://www.bdjobs.com","Bd Jobs", R.drawable.bdjobs_logo));


        JobsAdapter adapter = new JobsAdapter(getActivity(), words, R.color.category_colors);
        GridView gridView = (GridView)rootView.findViewById(R.id.jobslist);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);


                Toast.makeText(getActivity(), "" + word.getMiwokTranslation(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getActivity(), NewsFeed.class);
                i.putExtra("url", word.getDefaultTranslation());
                i.putExtra("name", word.getMiwokTranslation());
                startActivity(i);


            }
        });

        return rootView;


    }

    @Override
    public void onStop() {
        super.onStop();  // Always call the superclass method first

    }






}
