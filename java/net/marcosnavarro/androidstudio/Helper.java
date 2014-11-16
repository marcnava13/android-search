package net.marcosnavarro.androidstudio;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Admin on 14/11/2014.
 */

public class Helper {
    public static void getListViewSize(ListView myListView) {
        ListAdapter myListAdapter = myListView.getAdapter();
        if (myListAdapter == null) {
            //do nothing return null
            return;
        }
        //set listAdapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount(); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);
        // print height of adapter on log
        Log.i("height of listItem:", String.valueOf(totalHeight));
    }

    public static void overlay(ListView myListView, LinearLayout.LayoutParams paramsLinearLayout) {
        ListAdapter myListAdapter = myListView.getAdapter();
        if (myListAdapter == null) {
            //do nothing return null
            return;
        }
        //set listAdapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount(); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        System.out.println("totalHeight :: "+totalHeight);
        //setting marginTop the next element
        if(totalHeight>0) {
            int marginTop = (totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1))) * -1;
            paramsLinearLayout.setMargins(0,marginTop,0,0);
            System.out.println("marginTop :: "+marginTop);
        }else{
            System.out.println("nada :: totalHeight "+totalHeight);
            paramsLinearLayout.setMargins(0,0,0,0);
        }
    }
}