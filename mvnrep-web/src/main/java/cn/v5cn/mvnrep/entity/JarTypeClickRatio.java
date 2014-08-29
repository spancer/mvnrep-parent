package cn.v5cn.mvnrep.entity;

import java.io.Serializable;

/**
 * Created by ZYW on 2014/8/29.
 */
public class JarTypeClickRatio implements Serializable {
    private Long jtcrId;
    private String jarga;
    private Long clickRatio;

    public Long getJtcrId() {
        return jtcrId;
    }

    public void setJtcrId(Long jtcrId) {
        this.jtcrId = jtcrId;
    }

    public String getJarga() {
        return jarga;
    }

    public void setJarga(String jarga) {
        this.jarga = jarga;
    }

    public Long getClickRatio() {
        return clickRatio;
    }

    public void setClickRatio(Long clickRatio) {
        this.clickRatio = clickRatio;
    }

    @Override
    public String toString() {
        return "JarTypeClickRatio{" +
                "jtcrId=" + jtcrId +
                ", jarga='" + jarga + '\'' +
                ", clickRatio=" + clickRatio +
                '}';
    }
}
