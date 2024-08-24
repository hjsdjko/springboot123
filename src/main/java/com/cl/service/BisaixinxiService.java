package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BisaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaixinxiView;


/**
 * 比赛信息
 *
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
public interface BisaixinxiService extends IService<BisaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BisaixinxiView> selectListView(Wrapper<BisaixinxiEntity> wrapper);
   	
   	BisaixinxiView selectView(@Param("ew") Wrapper<BisaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BisaixinxiEntity> wrapper);
   	

}

