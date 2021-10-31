package com.kipkoech.petfinderip.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kipkoech.petfinderip.Constants;
import com.kipkoech.petfinderip.R;
import com.kipkoech.petfinderip.models.Animal;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.Image1)
    ImageView mImageLabel;
    @BindView(R.id.NameTextView)
    TextView mNameLabel;
    @BindView(R.id.TextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.savePetButton) TextView mSavePetButton;

    private Animal mPets;

    public PetDetailFragment() {
        // Required empty public constructor
    }


    public static PetDetailFragment newInstance(Animal genders) {
        PetDetailFragment restaurantDetailFragment = new PetDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("genders", Parcels.wrap(genders));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mPets = Parcels.unwrap(getArguments().getParcelable("genders"));

//
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_pet_detail, container, false);
        ButterKnife.bind(this, view);
        for(int i=0;i<mPets.getPhotos().size();i++){
//            Log.d("Photo","photo sizes"+mPets.getPhotos().get(i));
            String photo = mPets.getPhotos().get(i).getFull();
            Picasso.get().load(photo).into(mImageLabel);
        }
        mWebsiteLabel.setOnClickListener(this);
        mSavePetButton.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);



        mNameLabel.setText(mPets.getName());
        mWebsiteLabel.setText(mPets.getUrl());
//        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        mRatingLabel.setText((mPets.getGender()));
        mPhoneLabel.setText(mPets.getContact().toString());
        mAddressLabel.setText(mPets.getAge());



        return view;
    }

    @Override
    public void onClick(View v) {

        if (v == mPhoneLabel){
            Intent phoneIntent = new Intent (Intent.ACTION_DIAL, Uri.parse("tell:"+ mPets.getContact()));
            startActivity(phoneIntent);
        }
        if (v== mWebsiteLabel){
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mPets.getUrl()));
            startActivity(webIntent);
        }

        if(v==mSavePetButton){
            DatabaseReference petsave = FirebaseDatabase.getInstance()
                    .getReference(Constants.FIREBASE_CHILD_PETS);
            petsave.push().setValue(mPets);
            Toast.makeText(getContext(), "saved", Toast.LENGTH_SHORT).show();
        }

    }
}