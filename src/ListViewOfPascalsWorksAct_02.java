package org.vkedco.mobadddev.listviewofpascalsworks_arrayadptrs_02;

/*
 ************************************************************ 
 * IDE: Eclipse Juno
 * OS: Ubuntu 12.04 LTS
 * bugs to vladimir dot kulyukin at gmail dot com
 ************************************************************
 */

import android.os.Bundle;
import android.app.ListActivity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewOfPascalsWorksAct_02 extends ListActivity {
	
	static final int NUM_WORKS = 5;
	static String[] mPascalsWorks = null;
	
	static {
		mPascalsWorks = new String[NUM_WORKS];
	}
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view_of_pascals_works_act_02);
        Resources res = this.getResources();
		mPascalsWorks[0] = res.getString(R.string.discourses);
		mPascalsWorks[1] = res.getString(R.string.geometrical_spirit);
		mPascalsWorks[2] = res.getString(R.string.persuasion);
		mPascalsWorks[3] = res.getString(R.string.vacuum_01);
		mPascalsWorks[4] = res.getString(R.string.vacuum_02);
        this.setListAdapter(new ArrayAdapter<String>(this,
        		R.layout.list_item_layout,
        		mPascalsWorks)
        );
        
        this
        	.getListView()
        	.setOnItemClickListener(
        			new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent, 
								View child,
								int position, long id) {
							String msg = "";
							msg += "PARENT = " + parent.toString() + "\n";
							msg += "VIEW = " + child.toString() + "\n";
							msg += "VIEW'S TEXT = " + ((TextView)child).getText().toString() + "\n";
							msg += "POSITION = " + Integer.toString(position) + "\n";
							msg += "ID = " + Long.toString(id);
							// 7. This is a subtle point: we cannot specify this as the
							// first argument to makeText, because we are inside OnItemClickListener,
							// not inside the ListActivity where we were in ListViewArrayAdapter1Act.
							// Thus, we have to getApplicationContext() explicitly.
							Toast t = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
							t.show();

							
						}
        				
        			}
        	);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_of_pascals_works_act_02, menu);
        return true;
    }
    
}
