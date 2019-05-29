package xyz.bbear.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.bbear.domain.Story;
import xyz.bbear.infra.mapper.StoryMapper;
import xyz.bbear.infra.service.StoryService;

@Slf4j
@Service
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story> implements StoryService {}
