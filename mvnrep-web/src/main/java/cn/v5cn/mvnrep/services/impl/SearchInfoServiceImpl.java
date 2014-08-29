package cn.v5cn.mvnrep.services.impl;

import cn.v5cn.mvnrep.dao.SearchInfoDao;
import cn.v5cn.mvnrep.entity.SearchInfo;
import cn.v5cn.mvnrep.services.SearchInfoService;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/29.
 */
@Service("searchInfoService")
public class SearchInfoServiceImpl implements SearchInfoService {

    @Autowired
    private SearchInfoDao searchInfoDao;

    @Override
    public List<SearchInfo> addSearchJarInfo(List<Map<String,Object>> httpResults) {
        List<SearchInfo> result = Lists.newArrayList();
        SearchInfo dbObj = null;
        for(Map<String,Object> httpResult : httpResults){
            dbObj = new SearchInfo();
            dbObj.setId(httpResult.get("id").toString());
            dbObj.setLatestVersion(httpResult.get("latestVersion").toString());
            dbObj.setVersionCount(Integer.valueOf(httpResult.get("versionCount").toString()));
            SearchInfo si = searchInfoDao.findByIdAndLastVersion(dbObj.getId());
            if(si != null && si.getLatestVersion().equals(dbObj.getLatestVersion())){
                continue;
            }else if(si != null){
                searchInfoDao.updateLastVersionAndVersionCount(dbObj.getLatestVersion(),dbObj.getVersionCount(),si.getSid());
            }
            dbObj.setGroupId(httpResult.get("g").toString());
            dbObj.setArtifactId(httpResult.get("a").toString());

            dbObj.setRepositoryId(httpResult.get("repositoryId").toString());
            dbObj.setPack(httpResult.get("p").toString());
            dbObj.setUpdatetime(new DateTime(Long.valueOf(httpResult.get("timestamp").toString())).toString("YYYY-MM-dd"));

            searchInfoDao.addSearchJarInfo(dbObj);
            result.add(dbObj);
        }

        return result;
    }
}
