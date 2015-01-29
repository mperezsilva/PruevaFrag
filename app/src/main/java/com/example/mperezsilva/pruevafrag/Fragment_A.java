package com.example.mperezsilva.pruevafrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mperezsilva on 23/01/15.
 */
public class Fragment_A extends Fragment {
    public Fragment_A() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment1, container, false);
        Button llamaFragment = (Button) rootView.findViewById(R.id.llamaFragment);
        // le añadimos funcionalidad al 'click'
        llamaFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().findViewById(R.id.container2) != null) {
                    getFragmentManager().beginTransaction()
                    .add(R.id.container2, new Fragment_B())
                    .commit();
                }else{
                    Intent i = new Intent(getActivity(), MainActivity2.class);
                    abreFragment();
                    startActivity(i);
                }
            }
        });

        return rootView;
    }

    private void abreFragment() {
        //ponemos una TOAST para probar
        CharSequence text = "Abriendooooo...";
        int duration = Toast.LENGTH_SHORT;
        // utilizamos getActivity ya que el contexto es el de la Activity que tiene al fragment
        Toast toast = Toast.makeText(getActivity(), text, duration);
        toast.show();
    }
}
