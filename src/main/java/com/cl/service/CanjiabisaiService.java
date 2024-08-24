package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CanjiabisaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CanjiabisaiView;


/**
 * 参加比赛
 *
 * @author 
 * @email 
 * @date 2024-03-28 11:08:50
 */
public interface CanjiabisaiService extends IService<CanjiabisaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanjiabisaiView> selectListView(Wrapper<CanjiabisaiEntity> wrapper);
   	
   	CanjiabisaiView selectView(@Param("ew") Wrapper<CanjiabisaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanjiabisaiEntity> wrapper);
   	

}

