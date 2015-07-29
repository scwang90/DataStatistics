package com.datastatistics.service;

import com.datastatistics.model.DsApplication;
import com.datastatistics.model.DsFeedback;

/**
 * 数据库表ds_feedback的Service接口层
 * @author 树朾
 * @date 2015-07-28 23:44:10 中国标准时间
 */
public interface DsFeedbackService extends BaseService<DsFeedback>{

	/**
	 * 应用反馈信息统计
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	public void feedback(DsFeedback model, DsApplication application) throws Exception;
	
}
