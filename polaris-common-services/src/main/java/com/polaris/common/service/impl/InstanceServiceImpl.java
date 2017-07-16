package com.polaris.common.service.impl;

import com.polaris.common.repository.InstanceRepository;
import com.polaris.common.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Serhii on 15.05.2016.
 */
@Service
public class InstanceServiceImpl implements InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;
}
