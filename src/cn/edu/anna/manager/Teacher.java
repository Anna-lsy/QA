package cn.edu.anna.manager;

import java.util.ArrayList;

public class Teacher {
    private String tid;
    private String tname;
    private String tintro;
    private String ttitle;
    private String tdept;
    private ArrayList<String> tcourse;

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTintro() {
        return tintro;
    }

    public void setTintro(String tintro) {
        this.tintro = tintro;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public ArrayList<String> getTcourse() {
        return tcourse;
    }

    public void setTcourse(ArrayList<String> tcourse) {
        this.tcourse = tcourse;
    }
}
