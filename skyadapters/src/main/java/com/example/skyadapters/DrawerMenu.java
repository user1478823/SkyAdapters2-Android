package com.example.skyadapters;

import android.app.Activity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;

/**
 * Created by ttlnisoffice on 11/28/17.
 */

public class DrawerMenu {

    private Menu menu;

    public DrawerMenu(Activity a, int id) {
        menu = new PopupMenu(a, null).getMenu();
        a.getMenuInflater().inflate(id, menu);
    }

    public Menu getMenu() {
        return menu;
    }
}
