package org.treinchauffeur.seintje.io;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.treinchauffeur.seintje.MainActivity;
import org.treinchauffeur.seintje.misc.Constants;

import java.util.ArrayList;
import java.util.Collections;

public class IOFactory {

    private final Context context;
    private final MainActivity activity;
    public static final String TAG = "IOFactory";

    public IOFactory(MainActivity activity, Context c) {
        this.activity = activity;
        this.context = c;
    }

    public void saveImageIDs(LinearLayout toSave, boolean shouldNotifyUser) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_STRING, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < toSave.getChildCount(); i++) {
            View child = toSave.getChildAt(i);
            if (child instanceof ImageView) {
                int drawableResId = (Integer) child.getTag();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("type", child.getClass().getName());
                    jsonObject.put("drawableResId", drawableResId);
                } catch (JSONException e) {
                    Log.e(TAG, "saveImageIDs: ", e);
                }
                jsonArray.put(jsonObject);
            }
        }
        String json = jsonArray.toString();

        editor.putString("linear_layout_children", json);
        editor.apply();
        if(shouldNotifyUser) Toast.makeText(context, "Er zijn "+jsonArray.length()+" items opgeslagen!", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "saveImageIDs: saved json: "+json);
    }

    public ArrayList<ImageView> loadLayout(boolean shouldInsert) {
        ArrayList<ImageView> list = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_STRING, MODE_PRIVATE);
        String json = sharedPreferences.getString("linear_layout_children", "");
        if(json.equals("")) return list;
        Log.d(TAG, "loadLayout: loaded json: "+json);
        JSONArray jsonArray;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            Log.e(TAG, "loadLayout: ", e);
            return null;
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int drawableResId = jsonObject.getInt("drawableResId");

                ImageView child = new ImageView(context);
                child.setTag(drawableResId);

                list.add(child);
            } catch (JSONException e) {
                Log.e(TAG, "loadLayout: ", e);
            }
        }
        Collections.reverse(list);
        for(ImageView toAdd : list) {
            if(shouldInsert) activity.insertPiece((Integer) toAdd.getTag());
        }
        return list;
    }
}
