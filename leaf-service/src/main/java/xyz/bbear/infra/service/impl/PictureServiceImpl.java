package xyz.bbear.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.bbear.domain.Picture;
import xyz.bbear.infra.mapper.PictureMapper;
import xyz.bbear.infra.service.PictureService;

@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture>
    implements PictureService {}
