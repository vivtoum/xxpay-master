package org.xxpay.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxpay.dal.dao.mapper.MchInfoMapper;
import org.xxpay.dal.dao.model.MchInfo;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description:
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
@Component
public class MchInfoService {

    @Autowired
    private MchInfoMapper mchInfoMapper;

    public MchInfo selectMchInfo(String mchId) {
        return mchInfoMapper.selectByPrimaryKey(mchId);
    }

}
