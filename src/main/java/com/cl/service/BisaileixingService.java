package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BisaileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaileixingView;


/**
 * 比赛类型
 *
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
public interface BisaileixingService extends IService<BisaileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BisaileixingView> selectListView(Wrapper<BisaileixingEntity> wrapper);
   	
   	BisaileixingView selectView(@Param("ew") Wrapper<BisaileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BisaileixingEntity> wrapper);
   	

}

