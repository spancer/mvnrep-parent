package cn.v5cn.mvnrep.dao;

import cn.v5cn.mvnrep.entity.JarTypeClickRatio;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/8/29.
 */
@Repository("jarTypeClickRatioDao")
public interface JarTypeClickRatioDao {
    Long addJTCR(JarTypeClickRatio jarTypeClickRatio);
    JarTypeClickRatio findByGaJTCR(String jarga);
    Long updateJTCR(@Param("jtcrId")Long jtcrId,@Param("clickRatio")Long clickRatio);
}
