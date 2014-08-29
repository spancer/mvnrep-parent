package cn.v5cn.mvnrep.entity;

import java.io.Serializable;

/**
 * Created by ZYW on 2014/8/29.
 */
public class SearchKey implements Serializable {
    private Long skId;
    private String skw;
    private Long searchNum;
    private String stime;

    public Long getSkId() {
        return skId;
    }

    public void setSkId(Long skId) {
        this.skId = skId;
    }

    public String getSkw() {
        return skw;
    }

    public void setSkw(String skw) {
        this.skw = skw;
    }

    public Long getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(Long searchNum) {
        this.searchNum = searchNum;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "SearchKey{" +
                "skId=" + skId +
                ", skw='" + skw + '\'' +
                ", searchNum" + searchNum +
                ", stime='" + stime + '\'' +
                '}';
    }
}
