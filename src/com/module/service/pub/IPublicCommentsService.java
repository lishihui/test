package com.module.service.pub;

import com.module.domain.pub.DxxzspPublicComments;

import java.util.List;

public interface IPublicCommentsService {
    int save(DxxzspPublicComments publicComments);

    List<DxxzspPublicComments> list(String workid, String formid);
}
