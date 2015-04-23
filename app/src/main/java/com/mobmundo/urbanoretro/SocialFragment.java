package com.mobmundo.urbanoretro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class SocialFragment extends Fragment implements AbsListView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private SocialAdapter mAdapter;

    // TODO: Rename and change types of parameters
    public static SocialFragment newInstance(String param1, String param2) {
        SocialFragment fragment = new SocialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SocialFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        List<Social> listSocial = new ArrayList<>();

        Resources res =  getResources();
        Drawable drw_face = res.getDrawable(R.mipmap.ic_face);
        Drawable drw_gplus = res.getDrawable(R.mipmap.ic_gplus);
        Drawable drw_yt = res.getDrawable(R.mipmap.ic_youtube);
        Drawable drw_insta = res.getDrawable(R.mipmap.ic_insta);
        Drawable drw_twitter = res.getDrawable(R.mipmap.ic_twitter);
        listSocial.add(new Social(1, "Blog Urbano & Retro", drw_face));
        listSocial.add(new Social(2, "@urbanoeretro", drw_insta));
        listSocial.add(new Social(3, "+Urbano&Retro", drw_gplus));
        listSocial.add(new Social(4, "urbanoeretro", drw_twitter));
        listSocial.add(new Social(5, "blogurbanoeretro", drw_yt));

        // TODO: Change Adapter to display your content
        mAdapter = new SocialAdapter(getActivity(),listSocial);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Social item = (Social) mAdapter.getItem(position);
                Intent browserIntent;
                switch (item.getId()) {
                    //facebook
                    case 1:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/UrbanoeRetro"));
                        startActivity(browserIntent);
                        break;
                    //instagram
                    case 2:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/urbanoeretro"));
                        startActivity(browserIntent);
                        break;
                    //gplus
                    case 3:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/116502430820379704940/posts"));
                        startActivity(browserIntent);
                        break;
                    //twitter
                    case 4:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/urbanoeretro"));
                        startActivity(browserIntent);
                        break;
                    //youtube
                    case 5:
                        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/blogurbanoeretro"));
                        startActivity(browserIntent);
                        break;
                }
            }
        });
        view.setBackgroundColor(Color.WHITE);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            //mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String id);
    }

}
