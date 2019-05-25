package xyz.bbear.infra.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.bbear.domain.Leaf;
import xyz.bbear.infra.mapper.LeafMapper;
import xyz.bbear.infra.service.LeafService;

/**
 * LeafServiceImpl.
 *
 * @author xiongliu wu 2019-03-31 18:13
 */
@Service
public class LeafServiceImpl extends ServiceImpl<LeafMapper, Leaf> implements LeafService {}
