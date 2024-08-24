package com.cl.entity.view;

import com.cl.entity.BisaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 比赛信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-28 11:08:49
 */
@TableName("bisaixinxi")
public class BisaixinxiView  extends BisaixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BisaixinxiView(){
	}
 
 	public BisaixinxiView(BisaixinxiEntity bisaixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, bisaixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
