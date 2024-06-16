package com.adsalam.android.newsjob.NewsFragments;


import android.content.Intent;
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
public class OnlineNewsFragment extends Fragment {




    public OnlineNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);




        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("https://news.zoombangla.com", "news zoombangla",R.drawable.news_zoombangla));
        words.add(new Word("https://sangathansangbad.com", "sangathansangbad.",R.drawable.sangathansangbad));
        words.add(new Word("https://bbc24news.com", "bbc24news",R.drawable.bbc24news));
        words.add(new Word("https://www.jjdin.com", "Jayjay din",R.drawable.jayjaydin ));
        words.add(new Word("https://www.dailyinqilab.com", "Daily inqilab",R.drawable.inkilab));




        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);


                Toast.makeText(getActivity(), "" + word.getMiwokTranslation(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getActivity(), NewsFeed.class);
                i.putExtra("url", word.getDefaultTranslation());
                i.putExtra("name", word.getMiwokTranslation() + " Newspaper");
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
