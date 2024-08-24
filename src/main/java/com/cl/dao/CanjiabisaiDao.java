package com.cl.dao;

import com.cl.entity.CanjiabisaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CanjiabisaiView;


/**
 * 参加比赛
 * 
 * @author 
 * @email 
 * @date 2024-03-28 11:08:50
 */
public interface CanjiabisaiDao extends BaseMapper<CanjiabisaiEntity> {
	
	List<CanjiabisaiView> selectListView(@Param("ew") Wrapper<CanjiabisaiEntity> wrapper);

	List<CanjiabisaiView> selectListView(Pagination page,@Param("ew") Wrapper<CanjiabisaiEntity> wrapper);
	
	CanjiabisaiView selectView(@Param("ew") Wrapper<CanjiabisaiEntity> wrapper);
	

}
