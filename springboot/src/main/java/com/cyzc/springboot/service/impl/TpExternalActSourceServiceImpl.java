package com.cyzc.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyzc.springboot.entity.TpExternalActSource;
import com.cyzc.springboot.mapper.ITpExternalActSourceService;
import com.cyzc.springboot.mapper.TpExternalActSourceMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/08/18 11:28]
 */
@Service
public class TpExternalActSourceServiceImpl extends
        ServiceImpl<TpExternalActSourceMapper, TpExternalActSource> implements
        ITpExternalActSourceService {

}
