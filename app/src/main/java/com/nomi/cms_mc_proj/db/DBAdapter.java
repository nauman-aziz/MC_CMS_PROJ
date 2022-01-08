package com.nomi.cms_mc_proj.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import com.nomi.cms_mc_proj.bean.AttendanceBean;
import com.nomi.cms_mc_proj.bean.AttendanceSessionBean;
import com.nomi.cms_mc_proj.bean.FacultyBean;
import com.nomi.cms_mc_proj.bean.StudentBean;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



    public class DBAdapter extends SQLiteOpenHelper {

        // All Static variables
        // Database Version
        private static final int DATABASE_VERSION = 1;

        // Database Name
        private static final String DATABASE_NAME = "Attendance";

        // Contacts table name
        private static final String FACULTY_INFO_TABLE = "faculty_table";
        private static final String STUDENT_INFO_TABLE = "student_table";
        private static final String ATTENDANCE_SESSION_TABLE = "attendance_session_table";
        private static final String ATTENDANCE_TABLE = "attendance_table";


        // Contacts Table Columns names
        private static final String KEY_FACULTY_ID = "faculty_id";
        private static final String KEY_FACULTY_FIRSTNAME = "faculty_firstname";
        private static final String KEY_FACULTY_LASTNAME = "faculty_Lastname";
        private static final String KEY_FACULTY_MO_NO = "faculty_mobilenumber";
        private static final String KEY_FACULTY_ADDRESS = "faculty_address";
        private static final String KEY_FACULTY_USERNAME = "faculty_username";
        private static final String KEY_FACULTY_PASSWORD = "faculty_password";

        private static final String KEY_STUDENT_ID = "student_id";
        private static final String KEY_STUDENT_FIRSTNAME = "student_firstname";
        private static final String KEY_STUDENT_LASTNAME = "student_lastname";
        private static final String KEY_STUDENT_MO_NO = "student_mobilenumber";
        private static final String KEY_STUDENT_ADDRESS = "student_address";
        private static final String KEY_STUDENT_DEPARTMENT = "student_department";
        private static final String KEY_STUDENT_CLASS = "student_class";

        private static final String KEY_ATTENDANCE_SESSION_ID = "attendance_session_id";
        private static final String KEY_ATTENDANCE_SESSION_FACULTY_ID = "attendance_session_faculty_id";
        private static final String KEY_ATTENDANCE_SESSION_DEPARTMENT = "attendance_session_department";
        private static final String KEY_ATTENDANCE_SESSION_CLASS = "attendance_session_class";
        private static final String KEY_ATTENDANCE_SESSION_DATE = "attendance_session_date";
        private static final String KEY_ATTENDANCE_SESSION_SUBJECT = "attendance_session_subject";

        private static final String KEY_SESSION_ID = "attendance_session_id";
        private static final String KEY_ATTENDANCE_STUDENT_ID = "attendance_student_id";
        private static final String KEY_ATTENDANCE_STATUS = "attendance_status";


        public DBAdapter(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override

        public void onCreate(SQLiteDatabase db) {
            String queryFaculty="CREATE TABLE "+ FACULTY_INFO_TABLE +" (" +
                    KEY_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_FACULTY_FIRSTNAME + " TEXT, " +
                    KEY_FACULTY_LASTNAME + " TEXT, " +
                    KEY_FACULTY_MO_NO + " TEXT, " +
                    KEY_FACULTY_ADDRESS + " TEXT," +
                    KEY_FACULTY_USERNAME + " TEXT," +
                    KEY_FACULTY_PASSWORD + " TEXT " + ")";
            Log.d("queryFaculty",queryFaculty);


            String queryStudent="CREATE TABLE "+ STUDENT_INFO_TABLE +" (" +
                    KEY_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_STUDENT_FIRSTNAME + " TEXT, " +
                    KEY_STUDENT_LASTNAME + " TEXT, " +
                    KEY_STUDENT_MO_NO + " TEXT, " +
                    KEY_STUDENT_ADDRESS + " TEXT," +
                    KEY_STUDENT_DEPARTMENT + " TEXT," +
                    KEY_STUDENT_CLASS + " TEXT " + ")";
            Log.d("queryStudent",queryStudent );


            String queryAttendanceSession="CREATE TABLE "+ ATTENDANCE_SESSION_TABLE +" (" +
                    KEY_ATTENDANCE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_ATTENDANCE_SESSION_FACULTY_ID + " INTEGER, " +
                    KEY_ATTENDANCE_SESSION_DEPARTMENT + " TEXT, " +
                    KEY_ATTENDANCE_SESSION_CLASS + " TEXT, " +
                    KEY_ATTENDANCE_SESSION_DATE + " DATE," +
                    KEY_ATTENDANCE_SESSION_SUBJECT + " TEXT" + ")";
            Log.d("queryAttendanceSession",queryAttendanceSession );


            String queryAttendance="CREATE TABLE "+ ATTENDANCE_TABLE +" (" +
                    KEY_SESSION_ID + " INTEGER, " +
                    KEY_ATTENDANCE_STUDENT_ID + " INTEGER, " +
                    KEY_ATTENDANCE_STATUS + " TEXT " + ")";
            Log.d("queryAttendance",queryAttendance );


            try
            {
                db.execSQL(queryFaculty);
                db.execSQL(queryStudent);
                db.execSQL(queryAttendanceSession);
                db.execSQL(queryAttendance);
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.e("Exception", e.getMessage());
            }

        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
            String queryFaculty="CREATE TABLE "+ FACULTY_INFO_TABLE +" (" +
                    KEY_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_FACULTY_FIRSTNAME + " TEXT, " +
                    KEY_FACULTY_LASTNAME + " TEXT, " +
                    KEY_FACULTY_MO_NO + " TEXT, " +
                    KEY_FACULTY_ADDRESS + " TEXT," +
                    KEY_FACULTY_USERNAME + " TEXT," +
                    KEY_FACULTY_PASSWORD + " TEXT " + ")";
            Log.d("queryFaculty",queryFaculty);


            String queryStudent="CREATE TABLE "+ STUDENT_INFO_TABLE +" (" +
                    KEY_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_STUDENT_FIRSTNAME + " TEXT, " +
                    KEY_STUDENT_LASTNAME + " TEXT, " +
                    KEY_STUDENT_MO_NO + " TEXT, " +
                    KEY_STUDENT_ADDRESS + " TEXT," +
                    KEY_STUDENT_DEPARTMENT + " TEXT," +
                    KEY_STUDENT_CLASS + " TEXT " + ")";
            Log.d("queryStudent",queryStudent );


            String queryAttendanceSession="CREATE TABLE "+ ATTENDANCE_SESSION_TABLE +" (" +
                    KEY_ATTENDANCE_SESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_ATTENDANCE_SESSION_FACULTY_ID + " INTEGER, " +
                    KEY_ATTENDANCE_SESSION_DEPARTMENT + " TEXT, " +
                    KEY_ATTENDANCE_SESSION_CLASS + " TEXT, " +
                    KEY_ATTENDANCE_SESSION_DATE + " TEXT," +
                    KEY_ATTENDANCE_SESSION_SUBJECT + " TEXT" +")";
            Log.d("queryAttendanceSession",queryAttendanceSession );


            String queryAttendance="CREATE TABLE "+ ATTENDANCE_TABLE +" (" +
                    KEY_SESSION_ID + " INTEGER, " +
                    KEY_ATTENDANCE_STUDENT_ID + " INTEGER, " +
                    KEY_ATTENDANCE_STATUS + " TEXT " + ")";
            Log.d("queryAttendance",queryAttendance );

            try
            {
                db.execSQL(queryFaculty);
                db.execSQL(queryStudent);
                db.execSQL(queryAttendanceSession);
                db.execSQL(queryAttendance);
            }
            catch (Exception e) {
                e.printStackTrace();
                Log.e("Exception", e.getMessage());
            }
        }

        //facult crud
        public void addFaculty(FacultyBean facultyBean) {
            SQLiteDatabase db = this.getWritableDatabase();

            String query = "INSERT INTO faculty_table (faculty_firstname,faculty_Lastname,faculty_mobilenumber,faculty_address,faculty_username,faculty_password) values ('"+
                    facultyBean.getFaculty_firstname()+"', '"+
                    facultyBean.getFaculty_lastname()+"', '"+
                    facultyBean.getFaculty_mobilenumber()+"', '"+
                    facultyBean.getFaculty_address()+"', '"+
                    facultyBean.getFaculty_username()+"', '"+
                    facultyBean.getFaculty_password()+"')";
            Log.d("query", query);
            db.execSQL(query);
            db.close();
        }

        public FacultyBean validateFaculty(String userName,String password)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            String query = "SELECT * FROM faculty_table where faculty_username='"+userName+"' and faculty_password='"+password+"'";
            Cursor cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst())
            {

                FacultyBean facultyBean = new FacultyBean();
                facultyBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
                facultyBean.setFaculty_firstname(cursor.getString(1));
                facultyBean.setFaculty_lastname(cursor.getString(2));
                facultyBean.setFaculty_mobilenumber(cursor.getString(3));
                facultyBean.setFaculty_address(cursor.getString(4));
                facultyBean.setFaculty_username(cursor.getString(5));
                facultyBean.setFaculty_password(cursor.getString(6));
                return facultyBean;
            }
            return null;
        }

        public ArrayList<FacultyBean> getAllFaculty()
        {
            Log.d("in get all","in get all" );
            ArrayList<FacultyBean> list = new ArrayList<FacultyBean>();

            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM faculty_table";
            Cursor cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                do{
                    FacultyBean facultyBean = new FacultyBean();
                    facultyBean.setFaculty_id(Integer.parseInt(cursor.getString(0)));
                    facultyBean.setFaculty_firstname(cursor.getString(1));
                    facultyBean.setFaculty_lastname(cursor.getString(2));
                    facultyBean.setFaculty_mobilenumber(cursor.getString(3));
                    facultyBean.setFaculty_address(cursor.getString(4));
                    facultyBean.setFaculty_username(cursor.getString(5));
                    facultyBean.setFaculty_password(cursor.getString(6));
                    list.add(facultyBean);

                }while(cursor.moveToNext());
            }
            return list;
        }

        public void deleteFaculty(int facultyId) {
            SQLiteDatabase db = this.getWritableDatabase();

            String query = "DELETE FROM faculty_table WHERE faculty_id="+facultyId ;

            Log.d("query", query);
            db.execSQL(query);
            db.close();
        }
    }
