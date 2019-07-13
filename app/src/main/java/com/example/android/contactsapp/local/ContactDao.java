package com.example.android.contactsapp.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

//In dao we define methods for accessing database
@Dao
public interface ContactDao {

    @Query("SELECT * FROM  contacts") //contacts is table name in ContactEntity Class
    LiveData<List<ContactEntity>> loadContactsFromDB();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveContacts(List<ContactEntity>  contacts);
}
