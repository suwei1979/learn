/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry;

import com.baidu.rigel.domain.PagedList;
import com.baidu.rigel.service.industry.dto.DynamicListIndustry;
import com.baidu.rigel.service.industry.dto.IndustryDto;
import com.baidu.rigel.service.industry.dto.ListChildrenIndustry;

/**
 * 行业分类服务
 * 
 * @author suwei
 *
 */
public interface IndustryService {

    /**
     * 根据传入行业信息的name或code组合查询（And条件）
     * 
     * @param request，查询请求对象
     * @return 行业信息列表
     */
    public PagedList<IndustryDto> findByList(DynamicListIndustry request);

    /**
     * 根据行业编码查询直接下级行业信息列表
     * 
     * @param parentIndustryCode 上级行业编码
     * @return 下级行业列表
     */
    public PagedList<IndustryDto> findSubIndustryByList(ListChildrenIndustry request);

}
