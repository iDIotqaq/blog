package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.DiscussionGroupService;
import cn.com.taiji.actual.untils.Result;
import cn.com.taiji.actual.untils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/17 11:26
 */

@Controller
@RequestMapping("/disGroup")
public class DiscussionGroupController {

    @Autowired
    DiscussionGroupService discussionGroupService;

//    @GetMapping("/disgroup")
//    public String findAll(Model model){
//
//        List<DiscussionGroup> discussionGroups = discussionGroupService.findAll();
//
//        model.addAttribute("groupList",discussionGroups);
//
//        return "/discussionGroup";
//    }

    /**
     *分页查询
     * @param num
     * @param model
     * @return
     */
    @GetMapping("page/{num}")
    public String getPage(@PathVariable("num") Integer num, Model model){
        Map pagination = discussionGroupService.findPagination(num);
        int pageSize =(int)pagination.get("total");
        List<DiscussionGroup> discussion = (List<DiscussionGroup>)pagination.get("discussions");
        model.addAttribute("groupList",discussion);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",num);
        return "discussion/index";
    }

    /**
     * 根据id删除讨论组
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ResponseBody
    public Result deleteById(Integer id){
        discussionGroupService.deleteById(id);
        return ResultUtils.Success("删除成功");
    }

    /**
     * 添加页面跳转
     * @param model
     * @return
     */
    @GetMapping("/addPage")
    public String addPage(Model model){
        DiscussionGroup discussionGroup = new DiscussionGroup();
        model.addAttribute("dissionList",discussionGroup);
        return "/discussion/edit";
    }

    /**
     * 新增操作
     * @param discussionGroup
     * @return
     */
    @PostMapping("add")
    public String addUser(DiscussionGroup discussionGroup){
        discussionGroupService.addDiscussion(discussionGroup);
        return "redirect:/disGroup/page/1";
    }

    /**
     * 跳转编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editPage/{id}")
    public String editUser(@PathVariable("id")Integer id,Model model){
        DiscussionGroup discussionGroup = discussionGroupService.findById(id);
        model.addAttribute("dissionList",discussionGroup);
        return "/discussion/edit";
    }

    /**
     * 更新操作
     * @param discussionGroup
     * @return
     */
    @PostMapping("edit")
    public String editUser(DiscussionGroup discussionGroup){
        discussionGroupService.updateDiscussion(discussionGroup);
        return "redirect:/disGroup/page/1";
    }
}
