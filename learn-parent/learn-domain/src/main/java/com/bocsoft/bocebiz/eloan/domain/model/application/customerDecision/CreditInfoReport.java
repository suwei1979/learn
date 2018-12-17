/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */

package com.bocsoft.bocebiz.eloan.domain.model.application.customerDecision;

import lombok.Data;

/**
 * ClassName:CreditInfoReport <br/>
 * Function: 征信报告. <br/>
 * Date:     2015年6月27日 下午3:57:27 <br/>
 *
 * @author st-wg-lbw5833
 * @see
 * @since JDK 1.6
 */
@Data
public class CreditInfoReport {
    private String P01;//婚姻状况
    private String P02;//学历
    private String P03;//学位
    private String P04;//住房贷款笔数
    private String P05;//其他贷款笔数
    private String C21;//贷款记录数
    private String C22;//信用卡记录数
    private String C33;//获取贷款最早年份
    private String C34;//获取信用卡最早年份
    private String P06;//贷款逾期笔数
    private String P07;//贷款逾期月份数
    private String P08;//贷款单月最高逾期总额
    private String P09;//贷款最长逾期月数
    private String P10;//信用卡逾期账户数
    private String P11;//信用卡逾期月份数
    private String P12;//信用卡单月最高逾期总额
    private String P13;//信用卡最长逾期月数
    private String P14;//贷款法人机构数
    private String C47;//贷款记录的机构数
    private String P15;//贷款笔数
    private String P16;//贷款余额
    private String P17;//最近6个月平均应还款金额
    private String P18;//信用卡发卡法人机构数
    private String C48;//信用卡发卡机构数
    private String P19;//信用卡账户数
    private String C23;//信用卡总额度
    private String C24;//信用卡已透支额度
    private String P20;//信用卡最近6个月平均使用额度
    private String P21;//每月还款金额
    private String P22;//个人对外担保笔数
    private String C50;//个人对外担保金额
    private String P23;//个人对外担保本金余额
    private String P24;//担保不良贷款余额汇总
    private String P25;//当前贷款余额汇总
    private String P66;//贷款账户状态为正常的笔数
    private String P67;//贷款账户状态为逾期的笔数
    private String P68;//贷款账户状态为结清的笔数
    private String P69;//贷款账户状态为呆账的笔数
    private String P70;//贷款账户状态为转出的笔数
    private String P71;//贷款账户状态为核销的笔数
    private String P26;//当前个人住房贷款余额汇总
    private String P27;//当前个人商用房贷款余额汇总
    private String P28;//当前个人住房公积金贷款余额汇总
    private String P29;//当前个人汽车贷款余额汇总
    private String P30;//当前个人助学贷款余额汇总
    private String P31;//当前个人经营性贷款余额汇总
    private String P32;//当前农户贷款余额汇总
    private String P33;//当前个人消费贷款余额汇总
    private String P34;//当前其他贷款余额汇总
    private String P35;//当前贷款笔数汇总
    private String P36;//当前个人住房贷款笔数汇总
    private String P37;//当前个人商用房贷款笔数汇总
    private String P38;//当前个人住房公积金贷款笔数汇总
    private String P39;//当前个人汽车贷款笔数汇总
    private String P40;//当前个人助学贷款笔数汇总
    private String C38;//当前个人经营性贷款笔数汇总
    private String P41;//当前农户贷款笔数汇总
    private String P42;//当前个人消费贷款笔数汇总
    private String P43;//当前其他贷款笔数汇总
    private String P72;//非我行当前个人住房贷款余额汇总
    private String P73;//非我行当前个人商用房贷款余额汇总
    private String P74;//非我行当前个人住房公积金贷款余额汇总
    private String P75;//非我行当前个人汽车贷款余额汇总
    private String P76;//非我行当前个人助学贷款余额汇总
    private String P77;//非我行当前个人经营性贷款余额汇总
    private String P78;//非我行当前农户贷款余额汇总
    private String P79;//非我行当前个人消费贷款余额汇总
    private String P80;//非我行当前其他贷款余额汇总
    private String P81;//担保方式为信用的非我行当前个人助学贷款余额汇总
    private String P82;//担保方式为信用的非我行当前个人经营性贷款余额汇总
    private String P83;//担保方式为信用的非我行当前农户贷款余额汇总
    private String P84;//担保方式为信用的非我行当前个人消费贷款余额汇总
    private String P85;//担保方式为信用的非我行当前其他贷款余额汇总
    private String C35;//最近6个月贷款发放笔数
    private String P86;//信用卡账户状态为正常的笔数
    private String P87;//信用卡账户状态为冻结的笔数
    private String P88;//信用卡账户状态为止付的笔数
    private String P89;//信用卡账户状态为销户的笔数
    private String P90;//信用卡账户状态为呆账的笔数
    private String P91;//信用卡账户状态为未激活的笔数
    private String P92;//信用卡账户状态为转出的笔数
    private String P93;//信用卡账户状态为核销的笔数
    private String C27;//当前贷款最大逾期期数(C27)
    private String P44;//当前贷款逾期金额汇总
    private String P45;//当前不良贷款余额汇总
    private String P46;//当前不良贷款余额汇总
    private String C55;//贷款近24个月是否存在累计逾期6期的情况:Y-存在,N-不存在
    private String C56;//贷款近24个月是否存在连续逾期3期的情况:Y-存在,N-不存在
    private String C25;//最近24个月贷款逾期2期及以上次数(C25)
    private String P47;//信用卡近24个月累计逾期期数
    private String P48;//信用卡当前逾期金额汇总
    private String P49;//信用卡近24个月是否存在累计逾期6期的情况
    private String P50;//信用卡近24个月是否存在连续逾期3期的情况
    private String C26;//最近24个月信用卡逾期2期及以上次数(C26)
    private String C28;//当前信用卡最大逾期期数(C28)
    private String C29;//当前信用卡额度使用率超过90%的张数(C29)
    private String C36;//最近6个月信用卡发放笔数(C36)
    private String C37;//已注销的信用卡数(C37)
    private String P51;//最近1个月内的贷款审批查询次数
    private String P52;//最近1个月内的贷款审批查询机构数
    private String P53;//最近1个月内的信用卡审批查询次数
    private String P54;//最近1个月内的信用卡审批查询机构数
    private String P55;//最近1个月内的担保资格查询次数
    private String P56;//最近1个月内的担保资格查询机构数
    private String P57;//最近6个月内的贷款审批查询次数
    private String C49;//最近6个月内的贷款审批查询操作员数
    private String P58;//最近6个月内的信用卡审批查询次数
    private String P59;//最近6个月内的信用卡审批查询操作员数
    private String P60;//最近6个月内的担保资格查询次数
    private String P61;//最近6个月内的担保资格查询操作员数
    private String C30;//最近两年因贷款审批查询信用报告总次数
    private String P62;//最近两年因贷款审批查询信用报告操作员数
    private String P63;//最近两年因信用卡审批查询信用报告总次数
    private String P64;//最近两年因信用卡审批查询信用报告操作员数
    private String C32;//最近两年因担保资格查询信用报告次数
    private String P65;//最近两年因担保资格查询信用报告操作员数
    private String C39;//配偶的贷款记录数
    private String C40;//配偶的信用卡记录数
    private String C41;//配偶的最近24个月贷款逾期2期及以上次数
    private String C42;//配偶的最近24个月信用卡逾期2期及以上次数
    private String C43;//配偶的当前贷款最大逾期期数
    private String C44;//配偶的当前信用卡最大逾期期数
    private String C45;//配偶的当前信用卡额度使用率超过90%的张数
    private String C46;//配偶的最近6个月因贷款审批查询信用报告次数
    private String C51;//配偶贷款记录的机构数
    private String C52;//配偶信用卡发卡机构数
    private String C53;//配偶最近6个月因贷款审批查询信用报告的操作查询员数(Querier)
    private String C54;//配偶对外担保金额
}