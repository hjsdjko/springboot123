package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BisaichengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaichengjiView;


/**
 * 比赛成绩
 *
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
public interface BisaichengjiService extends IService<BisaichengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BisaichengjiView> selectListView(Wrapper<BisaichengjiEntity> wrapper);
   	
   	BisaichengjiView selectView(@Param("ew") Wrapper<BisaichengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BisaichengjiEntity> wrapper);
   	

}

