package cn.edu.anna.stu;

public class Message {
    private String sid;
    private String tid;
    private String tname;
    private int flag=0;
    private String qu;
    private String ans;
    private String mtitle;
    private String mcollege;
    private String mcourse;
    private String mtime;
    private String atime;
    private int mid;
    private int t_haslooked;
    private int s_haslooked;
    private String s_path=null;
    private String t_path=null;

    public String getS_path() {
        return s_path;
    }

    public void setS_path(String s_path) {
        this.s_path = s_path;
    }

    public String getT_path() {
        return t_path;
    }

    public void setT_path(String t_path) {
        this.t_path = t_path;
    }

    public int getS_haslooked() {
        return s_haslooked;
    }

    public void setS_haslooked(int s_haslooked) {
        this.s_haslooked = s_haslooked;
    }

    public int getT_haslooked() {
        return t_haslooked;
    }

    public void setT_haslooked(int t_haslooked) {
        this.t_haslooked = t_haslooked;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMcollege() {
        return mcollege;
    }

    public void setMcollege(String mcollege) {
        this.mcollege = mcollege;
    }

    public String getMcourse() {
        return mcourse;
    }

    public void setMcourse(String mcourse) {
        this.mcourse = mcourse;
    }
}
