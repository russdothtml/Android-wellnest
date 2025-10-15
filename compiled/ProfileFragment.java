package com.example.wellnestlayoutjournal;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {


    private ImageView profileImage;
    private TextView profileName, profileEmail, profilePhone, followersCount, followingCount;
    private Button btnEditProfile, btnMessage;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        // Initialize Views
        profileImage = view.findViewById(R.id.profile_image);
        profileName = view.findViewById(R.id.profile_name);
        profileEmail = view.findViewById(R.id.profile_email);
        profilePhone = view.findViewById(R.id.profile_phone);
        followersCount = view.findViewById(R.id.followers_count);
        followingCount = view.findViewById(R.id.following_count);
        btnEditProfile = view.findViewById(R.id.btn_edit_profile);


        // Set sample data
        profileName.setText("John Doe");
        profileEmail.setText("johndoe@example.com");
        profilePhone.setText("+63 912 345 6789");
        followersCount.setText("120");
        followingCount.setText("85");


        // You can also load an image from URL using Glide/Picasso
        // Glide.with(this).load("https://your-image-url.com/profile.jpg").into(profileImage);


        // Button Click Listeners
        btnEditProfile.setOnClickListener(v ->
                Toast.makeText(getActivity(), "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        );




        return view;
    }
}
