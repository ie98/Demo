package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.*;
import com.exmaple.Demo.model.Food;
import com.exmaple.Demo.model.Tag;

import java.util.List;

public interface TagService {
    public QueryReturn selectAllTag(Query query);
    public QueryReturn getTagTree(Query query);
    public Meta addTag(String tagname , int pid);
    public List<TagAndChild> selectAllTagNotQuery();
}
