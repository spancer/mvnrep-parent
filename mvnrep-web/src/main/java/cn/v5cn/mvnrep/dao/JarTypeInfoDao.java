package cn.v5cn.mvnrep.dao;

import cn.v5cn.mvnrep.entity.JarTypeInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/8/29.
 */
@Repository("searchInfoDao")
public interface JarTypeInfoDao {
    Long addSearchJarInfo(JarTypeInfo jarTypeInfo);
    JarTypeInfo findByIdAndLastVersion(String id);
    Long updateLastVersionAndVersionCount(String lastVersion,int versionCount,Long jtiId);
}
