package com.example.final_project.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Message.class}, version = 1)
public abstract class ChatDatabase extends RoomDatabase {
    public abstract MessageDao messageDao();

    private static volatile ChatDatabase INSTANCE;

    public static ChatDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ChatDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ChatDatabase.class,
                            "chat_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}
