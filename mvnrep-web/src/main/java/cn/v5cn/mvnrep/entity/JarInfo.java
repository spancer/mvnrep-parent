package cn.v5cn.mvnrep.entity;

import java.io.Serializable;

/**
 * Created by ZYW on 2014/8/29.
 */
public class JarInfo implements Serializable {
    private Long jarInfoId;
    private String groupId;
    private String artifactId;
    private String version;
    private String jartype; //当前的jar版本，是release,release candidate,beta,alpha,milestone',
    private String builderTime;
    private String clickRatio;
    private String remark;

    public Long getJarInfoId() {
        return jarInfoId;
    }

    public void setJarInfoId(Long jarInfoId) {
        this.jarInfoId = jarInfoId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getJartype() {
        return jartype;
    }

    public void setJartype(String jartype) {
        this.jartype = jartype;
    }

    public String getBuilderTime() {
        return builderTime;
    }

    public void setBuilderTime(String builderTime) {
        this.builderTime = builderTime;
    }

    public String getClickRatio() {
        return clickRatio;
    }

    public void setClickRatio(String clickRatio) {
        this.clickRatio = clickRatio;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "JarInfo{" +
                "jarInfoId=" + jarInfoId +
                ", groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                ", jartype='" + jartype + '\'' +
                ", builderTime='" + builderTime + '\'' +
                ", clickRatio='" + clickRatio + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}