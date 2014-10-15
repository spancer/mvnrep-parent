package cn.v5cn.mvnrep.entity;

import java.io.Serializable;

/**
 * Created by ZYW on 2014/8/29.
 */
public class JarTypeInfo implements Serializable {
    private Long jtiId;
    private String id;
    private String groupId;
    private String artifactId;
    private String latestVersion;
    private String repositoryId;
    private String pack;
    private String updatetime;
    private int versionCount;
    private Long clickRatio;         //这一类包的点击率

    public Long getJtiId() {
        return jtiId;
    }

    public void setJtiId(Long jtiId) {
        this.jtiId = jtiId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public int getVersionCount() {
        return versionCount;
    }

    public void setVersionCount(int versionCount) {
        this.versionCount = versionCount;
    }

    public Long getClickRatio() {
        return clickRatio;
    }

    public void setClickRatio(Long clickRatio) {
        this.clickRatio = clickRatio;
    }

    @Override
    public String toString() {
        return "JarTypeInfo{" +
                "jtiId=" + jtiId +
                ", id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", latestVersion='" + latestVersion + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                ", pack='" + pack + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", versionCount=" + versionCount +
                ", clickRatio=" + clickRatio +
                '}';
    }
}
