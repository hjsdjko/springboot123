package com.cl.dao;

import com.cl.entity.BisaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaixinxiView;


/**
 * 比赛信息
 * 
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
public interface BisaixinxiDao extends BaseMapper<BisaixinxiEntity> {
	
	List<BisaixinxiView> selectListView(@Param("ew") Wrapper<BisaixinxiEntity> wrapper);

	List<BisaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BisaixinxiEntity> wrapper);
	
	BisaixinxiView selectView(@Param("ew") Wrapper<BisaixinxiEntity> wrapper);
	

}
