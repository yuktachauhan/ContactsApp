package com.example.android.contactsapp.service.model;

import com.example.android.contactsapp.local.ContactEntity;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactListModel {

    @SerializedName("contacts")
    private List<ContactEntity> contactsModelList;


}
