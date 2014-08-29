package cn.v5cn.mvnrep.dao;

import cn.v5cn.mvnrep.entity.SearchInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/8/29.
 */
@Repository("searchInfoDao")
public interface SearchInfoDao {
    Long addSearchJarInfo(SearchInfo searchInfo);
    SearchInfo findByIdAndLastVersion(String id);
    Long updateLastVersionAndVersionCount(String lastVersion,int versionCount,Long sid);
}
