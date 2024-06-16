package com.adsalam.android.newsjob.NewsFragments;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.adsalam.android.newsjob.NewsFeed;
import com.adsalam.android.newsjob.R;
import com.adsalam.android.newsjob.Word;
import com.adsalam.android.newsjob.WordAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OthersNewsFragment extends Fragment {


    private MediaPlayer mediaPlayer;


    public OthersNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("https://www.dainikdestiny.com", "Doinik Destiny",R.drawable.destiny ));
        words.add(new Word("https://www.sorejominbarta.com", "Sorejomin Barta",R.drawable.sorejomin));





        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
