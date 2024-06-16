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
public class PopularNewsFragment extends Fragment {



    public PopularNewsFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("https://www.ittefaq.com.bd","Daily Ittefaq", R.drawable.daily_ittefaq));
        words.add(new Word("https://www.prothom-alo.com","Prothom Alo", R.drawable.prothomalo));
        words.add(new Word("https://www.kalerkantho.com","Kaler Kontho", R.drawable.kaler_kontho));
        words.add(new Word("https://www.bd-pratidin.com","Bangladesh Protidin",R.drawable.bangladesh_protidin));
        words.add(new Word("https://www.dailynayadiganta.com","Naya digonto", R.drawable.naya_digonto));
        words.add(new Word("https://www.jugantor.com","Jugantor", R.drawable.jugantor));
        words.add(new Word("https://www.mzamin.com", "Manab zamin",R.drawable.manab_jamin ));
        words.add(new Word("https://banglanews24.com", "banglanews24",R.drawable.banglanews24));
        words.add(new Word("https://www.ajkerpatrika.com", "Ajker patrika",R.drawable.ajker_patrika ));
        words.add(new Word("https://www.dailyvorerpata.com", "Vhorer pata",R.drawable.vhorer_pata));
        words.add(new Word("https://www.dailybartoman.com", "Doinik Bortoman",R.drawable.bartaman));
        words.add(new Word("https://www.dainikdestiny.com", "Doinik Destiny",R.drawable.destiny ));


        //  LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                Toast.makeText(getActivity(),""+word.getMiwokTranslation(),Toast.LENGTH_SHORT).show();


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
