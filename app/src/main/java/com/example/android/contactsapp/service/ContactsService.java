package com.example.android.contactsapp.service;

import com.example.android.contactsapp.service.model.ContactListModel;
import com.example.android.contactsapp.service.model.ContactsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsService {

    @GET("")
    Call<List<ContactsModel>> getContactList();
}
