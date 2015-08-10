package com.lonton.mapper;

import java.util.ArrayList;
import com.lonton.bean.TripData;

/**
 * 数据操作接口
 * @author 张国军 
 * @date 2015/8/6
 */
public interface ITripMapper {
	/**
	 * 通过父节点得到景点信息
	 * @param parent_target_id
	 * @return
	 */
	public ArrayList<TripData> getTripDataByParent_targetId(int parent_target_id);
}
