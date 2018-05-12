package com.example.zz.zz.chat;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zz.zz.R;
import com.example.zz.zz.adapter.ChatListAdapter;
import com.example.zz.zz.model.ChatListInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link user_chat_list.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link user_chat_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class user_chat_list extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public user_chat_list() {
        setHasOptionsMenu(true);
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment user_chat_list.
     */
    // TODO: Rename and change types and number of parameters
    public static user_chat_list newInstance(String param1, String param2) {
        user_chat_list fragment = new user_chat_list();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private List<ChatListInfo> chatListInfoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ChatListAdapter chatListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_chat_list, container,
                false);
        getActivity().setTitle("Общий чат");

        ImageView ivBackground;

        ivBackground=(ImageView) rootView.findViewById(R.id.background_image);
        ivBackground.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide
                .with(this)
                .load(R.drawable.background)
                .into(ivBackground);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.user_chat_list_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        FragmentManager fragmentManager = getFragmentManager();
        chatListAdapter= new ChatListAdapter(chatListInfoList,fragmentManager);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(chatListAdapter);

        PopulateEmployeeData();


        return rootView;
    }

    private void PopulateEmployeeData() {
        ChatListInfo chatListInfo = new ChatListInfo("Общий чат","");
        chatListInfoList.add(chatListInfo);
        chatListAdapter.notifyDataSetChanged();
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
