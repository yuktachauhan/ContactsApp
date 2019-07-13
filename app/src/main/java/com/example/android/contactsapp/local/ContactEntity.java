package com.example.android.contactsapp.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import android.support.annotation.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(tableName = "contacts")

public class ContactEntity {


    @PrimaryKey
    @SerializedName("id")
    @NonNull
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    @SerializedName("gender")
    private String gender;

    @SerializedName("phone")
    private HashMap<String,String> phone = new HashMap<String,String>();
}
