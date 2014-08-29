package cn.v5cn.mvnrep.dao;

import cn.v5cn.mvnrep.entity.JarInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/8/29.
 */
@Repository("jarInfoDao")
public interface JarInfoDao {
    Long addJarInfo(JarInfo jarInfo);
    JarInfo findByGAR(@Param("g")String g,@Param("a")String a,@Param("v")String v);
    Long updateClickRatio(@Param("jarInfoId")Long jarInfoId,@Param("clickRatio")Long clickRatio);
}
