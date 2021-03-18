package com.joseortale.unrd.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.joseortale.unrd.AppCons;
import com.joseortale.unrd.model.Story;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Services responsible to handle Story data
 *
 */
public class StoryService {
    private static StoryService instance;
    private DatabaseHelper dbHelper;

    private StoryService(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public static StoryService getInstance(Context context) {
        if (instance == null) {
            instance = new StoryService(context);
        }

        return instance;
    }

    /**
     *
     * Saves story and their food pairing to local database.
     *
     * @param story
     */
    public void save(Story story) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppCons.STORIES_TABLE_ID, story.getStoryId());
        values.put(AppCons.STORIES_TABLE_NAME, story.getName());
        values.put(AppCons.STORIES_TABLE_SHORT_SUMMARY, story.getShortSummary());
        values.put(AppCons.STORIES_TABLE_FULL_SUMMARY, story.getFullSummary());

        if (!storyExists(story)) {
            db.insert(AppCons.STORIES_TABLE, null, values);
        }

        else {
            String selection = AppCons.STORIES_TABLE_ID + " = ?";
            String[] selectionArgs = { story.getStoryId().toString() };

            db.update(
                    AppCons.STORIES_TABLE,
                    values,
                    selection,
                    selectionArgs);
        }
    }

    /**
     *
     * Checks if story already exists in order to save a new record or update the existing one.
     *
     * @param story
     * @return
     */
    private boolean storyExists(Story story) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + AppCons.STORIES_TABLE + " WHERE _id=?",
                new String[]{story.getStoryId().toString()});

        boolean exists = cursor.moveToFirst();

        cursor.close();

        return exists;
    }

    /**
     *
     * Returns all the story stored on local database
     *
     * @return
     */
    public List<Story> getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                AppCons.STORIES_TABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<Story> stories = new ArrayList<>();
        while(cursor.moveToNext()) {
            Story story = new Story();

            long id = cursor.getLong(cursor.getColumnIndexOrThrow(AppCons.STORIES_TABLE_ID));
            story.setStoryId((int)id);

            String name = cursor.getString(cursor.getColumnIndexOrThrow(AppCons.STORIES_TABLE_NAME));
            story.setName(name);

            String shortSummary = cursor.getString(cursor.getColumnIndexOrThrow(AppCons.STORIES_TABLE_SHORT_SUMMARY));
            story.setShortSummary(shortSummary);

            String fullSummary = cursor.getString(cursor.getColumnIndexOrThrow(AppCons.STORIES_TABLE_FULL_SUMMARY));
            story.setFullSummary(fullSummary);

            stories.add(story);
        }

        cursor.close();

        return stories;
    }
}
