package com.example.android.contactsapp.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities ={ContactEntity.class},version = 1,exportSchema = false)
@TypeConverters({Converter.class})
public abstract class ContactDatabase extends RoomDatabase {

    private static ContactDatabase instance;
    public abstract ContactDao getContactDao();

    // Get a database instance
    public static synchronized ContactDatabase getInstance(Context context){
        if(instance==null){
            instance=create(context);
        }
        return instance;
    }

    // Create the database
    static ContactDatabase create(Context context){
        RoomDatabase.Builder<ContactDatabase> builder= Room.databaseBuilder(context.getApplicationContext(),
                ContactDatabase.class, "contact_database");
        return builder.build();
    }
}
