package com.nomi.cms_mc_proj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nomi.cms_mc_proj.bean.AttendanceBean;
import com.nomi.cms_mc_proj.bean.StudentBean;
import com.nomi.cms_mc_proj.context.ApplicationContext;
import com.nomi.cms_mc_proj.db.DBAdapter;
import com.nomi.cms_mc_proj.R;

import java.util.ArrayList;

public class ViewAttendanceByFacultyActivity extends Activity {

	ArrayList<AttendanceBean> attendanceBeanList;
	private ListView listView ;  
	private ArrayAdapter<String> listAdapter;

	DBAdapter dbAdapter = new DBAdapter(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.__listview_main);

		listView=(ListView)findViewById(R.id.listview);
		final ArrayList<String> attendanceList = new ArrayList<String>();
		attendanceList.add("Id | StudentName |  Status");

		attendanceBeanList=((ApplicationContext)ViewAttendanceByFacultyActivity.this.getApplicationContext()).getAttendanceBeanList();

		for(AttendanceBean attendanceBean : attendanceBeanList)
		{
			String users = "";
			if(attendanceBean.getAttendance_session_id() != 0)
			{
				DBAdapter dbAdapter = new DBAdapter(ViewAttendanceByFacultyActivity.this);
				StudentBean studentBean =dbAdapter.getStudentById(attendanceBean.getAttendance_student_id());
				users = attendanceBean.getAttendance_student_id()+".     "+studentBean.getStudent_firstname()+","+studentBean.getStudent_lastname()+"                  "+attendanceBean.getAttendance_status();
			}
			else
			{
				users = attendanceBean.getAttendance_status();
			}

			
			attendanceList.add(users);
			Log.d("users: ", users); 

		}

		listAdapter = new ArrayAdapter<String>(this, R.layout.view_attendance_list, R.id.labelAttendance, attendanceList);
		listView.setAdapter( listAdapter );







	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
