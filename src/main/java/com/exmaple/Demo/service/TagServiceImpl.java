package com.exmaple.Demo.service;

import com.exmaple.Demo.dto.*;
import com.exmaple.Demo.mapper.TagMapper;
import com.exmaple.Demo.model.Tag;
import com.exmaple.Demo.util.Result;
import com.exmaple.Demo.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    private int LabelSize = 200;

    @Override
    public QueryReturn selectAllTag(Query query) {
        Utils utils = new Utils();
        List<Tag> list = tagMapper.selectAllTag();
        return utils.selectUtil(list,query);
    }

    @Override
    public QueryReturn getTagTree(Query query) {

        TagAndChild root = createTree();
        Utils utils = new Utils();
        QueryReturn queryReturn =  utils.selectUtil(root.getChildren(),query);
       return   queryReturn;
    }

//    private void change(Label label, Label label1) {
//        Label temp = new Label();
//        temp = label;
//        label = label1;
//        label1 = temp;
//    }


    @Override
    public Meta addTag(String tagname ,int pid ) {
        Tag tag = new Tag();
        tag.setTagname(tagname);
        tag.setPid(pid);
        List<Tag> tags = tagMapper.selectAllTag();
        for (int i = 0; i < tags.size(); i++) {
            if(tag.getTagname().equals(tags.get(i).getTagname())){
                return new Meta("TAGNAME_ISEXIT");
            }
        }
        if (pid == 0){
            tag.setLevel(0);
           return Result.ResuleInfo(tagMapper.addTag(tag)) ;
        }
        if (tagMapper.getLevelById(tag.getPid()) == null){
                return new Meta("NO_P_LABEL");
        }

          tag.setLevel((tagMapper.getLevelById(tag.getPid())+1));
        return Result.ResuleInfo(tagMapper.addTag(tag)) ;
    }

    @Override
    public List<TagAndChild> selectAllTagNotQuery() {
        TagAndChild root = createTree();
        return root.getChildren();
    }

    private TagAndChild createTree(){
        List<Tag> list = tagMapper.selectAllTag();
        List<TagAndChild> tagAndChildren = new ArrayList<>();
        //对list的level进行排序
        list.sort(Comparator.comparing(Tag::getLevel));  //必须先按照层数排序
//        Label[] labels = new Label[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            labels[i] = list.get(i);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int i1 = i; i1 < list.size(); i1++) {
//                if (labels[i].getLevel()>labels[i1].getLevel()){
//                    this.change(labels[i],labels[i1]);
//                }
//            }
//        }
//        for (int i = 0; i < labels.length; i++) {
//            System.out.println(labels[i].getLevel());
//        }
//        List<Label> labels1 = labels.


        TagAndChild root = new TagAndChild(); //创建根节点
        root.setId(0);
        root.setDeleted(false);
        root.setTagname("所有食物");
//        System.out.println("root:"+label.getId());  //数据检查
//        System.out.println("/////////////////////////////");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getLevel());
//        }

//            list.get(i).getPid();
//            if (list.get(i).getLevel() == 0){
//                LabelAndChild labelAndChild = new LabelAndChild();
//                labelAndChild.setLabel(list.get(i));
//                labelAndChildren.add(labelAndChild);
//            }else {
//
//                for (int i1 = 0; i1 < labelAndChildren.size(); i1++) {
//                    if (list.get(i).getPid() == labelAndChildren.get(i1).getLabel().getId()){
//                        LabelAndChild labelAndChild = new LabelAndChild();
//                        labelAndChild.setLabel(list.get(i));
//                        labelAndChildren.get(i1).getChildren().add(labelAndChild);
//                    }
//                }
//            }
//        }
        for (int i = 0; i < list.size(); i++) {
            select(root,list.get(i));
        }
        return root;
    }

    private void select(TagAndChild tagAndChild, Tag tag){  //递归生成表签树
        int i1;

            if (tag.getPid() == tagAndChild.getId()){
                System.out.println(tag.getTagname() + "是" + tagAndChild.getTagname() + "的子标签");
                TagAndChild tagAndChild1 = new TagAndChild();
                BeanUtils.copyProperties(tag, tagAndChild1);
                tagAndChild.getChildren().add(tagAndChild1);
            }

        else {
            for (int i = 0; i < tagAndChild.getChildren().size(); i++) {
                select(tagAndChild.getChildren().get(i),tag);
            }
        }

    }
}
