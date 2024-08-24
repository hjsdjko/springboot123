package com.cl.dao;

import com.cl.entity.BisaileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaileixingView;


/**
 * 比赛类型
 * 
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
public interface BisaileixingDao extends BaseMapper<BisaileixingEntity> {
	
	List<BisaileixingView> selectListView(@Param("ew") Wrapper<BisaileixingEntity> wrapper);

	List<BisaileixingView> selectListView(Pagination page,@Param("ew") Wrapper<BisaileixingEntity> wrapper);
	
	BisaileixingView selectView(@Param("ew") Wrapper<BisaileixingEntity> wrapper);
	

}
