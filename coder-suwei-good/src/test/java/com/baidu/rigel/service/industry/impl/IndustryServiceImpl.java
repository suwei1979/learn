/**
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.rigel.service.industry.impl;

import org.springframework.stereotype.Service;

import com.baidu.rigel.domain.PageRequest;
import com.baidu.rigel.domain.PagedList;
import com.baidu.rigel.domain.industry.Industry;
import com.baidu.rigel.domain.support.PagedListHelper;
import com.baidu.rigel.repository.PagingRepository;
import com.baidu.rigel.service.industry.IndustryService;
import com.baidu.rigel.service.industry.dto.DynamicListIndustry;
import com.baidu.rigel.service.industry.dto.IndustryDto;
import com.baidu.rigel.service.industry.dto.ListChildrenIndustry;

/**
 * 行业信息服务实现类
 * @author suwei
 *
 */
@Service("industryService")
public class IndustryServiceImpl implements IndustryService {

    private PagingRepository<Industry, PageRequest, Long> queryRepository;

    /**
     * @see com.baidu.rigel.service.industry.IndustryService#findByList(com.baidu.rigel.service.industry.dto.IndustryDto)
     */
    public PagedList<IndustryDto> findByList(DynamicListIndustry request) {
        
        PagedList<Industry> industryList = queryRepository.listByPage(request);
        
        return PagedListHelper.convert(industryList, IndustryDto.class);
        
    }

    /**
     * @see com.baidu.rigel.service.industry.IndustryService#findSubIndustryByList(java.lang.String)
     */
    public PagedList<IndustryDto> findSubIndustryByList(ListChildrenIndustry request) {
        return PagedListHelper.convert(queryRepository.listByPage(request), IndustryDto.class);
    }

}
