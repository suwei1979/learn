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
 * Service for Industry Management
 * 
 * @author suwei
 *
 */
public interface IndustryService {

    /**
     * 根据传入行业信息的name或code组合查询（And条件）
     * Find the paged list of Industry according to the dynamic request conditions
     * 
     * @param request，the query conditions.
     * @return the search result,  empty list if none is found.
     */
    public PagedList<IndustryDto> findByList(DynamicListIndustry request);

    /**
     * 根据行业编码查询直接下级行业信息列表
     * Find the paged list of industry according to the parent industry code.
     * 
     * @param request query conditions
     * @return the paged under level industry item list. 
     */
    public PagedList<IndustryDto> findSubIndustryByList(ListChildrenIndustry request);

}
