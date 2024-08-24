package com.cl.dao;

import com.cl.entity.BisaichengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BisaichengjiView;


/**
 * 比赛成绩
 * 
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
public interface BisaichengjiDao extends BaseMapper<BisaichengjiEntity> {
	
	List<BisaichengjiView> selectListView(@Param("ew") Wrapper<BisaichengjiEntity> wrapper);

	List<BisaichengjiView> selectListView(Pagination page,@Param("ew") Wrapper<BisaichengjiEntity> wrapper);
	
	BisaichengjiView selectView(@Param("ew") Wrapper<BisaichengjiEntity> wrapper);
	

}
