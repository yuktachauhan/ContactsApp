package com.example.android.contactsapp.service;

import com.example.android.contactsapp.service.model.ContactListModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactsService {

    @GET("")
    Call<ContactListModel> getContactList();
}
