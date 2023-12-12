package com.example.hw_android3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainFragment extends Fragment {

    private TextView textView;
    private Button increaseBtn;
    private Button decreaseBtn;
    private Button goToNextFragmentBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();

        increaseBtn.setOnClickListener(fnView -> {
            int number = Integer.parseInt(textView.getText().toString()) + 1;
            textView.setText(String.valueOf(number));
        });
        decreaseBtn.setOnClickListener(fnView -> {
            int number = Integer.parseInt(textView.getText().toString()) - 1;
            textView.setText(String.valueOf(number));
        });

        goToNextFragmentBtn.setOnClickListener(fnView -> {
            Bundle bundle = new Bundle();
            bundle.putString("number", textView.getText().toString());
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, secondFragment)
                    .addToBackStack(null).commit();
        });
    }

    private void initViews() {
        textView = requireActivity().findViewById(R.id.textView);
        increaseBtn = requireActivity().findViewById(R.id.increaseBtn);
        decreaseBtn = requireActivity().findViewById(R.id.decreaseBtn);
        goToNextFragmentBtn = requireActivity().findViewById(R.id.nextFragmentBtn);
    }
}