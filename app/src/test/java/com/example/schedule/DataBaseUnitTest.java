package com.example.schedule;

import android.content.Context;

import com.example.schedule.db.AdminSQLiteOpenHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class DataBaseUnitTest {
    private AdminSQLiteOpenHelper admin;
    private void setUpScene1(){
        admin = new AdminSQLiteOpenHelper(null);
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void addTeacher_test(){
        setUpScene1();
        admin.addTeacher("Faber");
        assertNotNull(admin.getTeacherById(1));
    }
}