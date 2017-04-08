package com.jp.girl.controller;


import com.jp.girl.aspect.HttpAspect;
import com.jp.girl.dto.Result;
import com.jp.girl.dto.ResultUtil;
import com.jp.girl.exception.ExceptionHandle;
import com.jp.girl.service.GirlService;
import com.jp.girl.dao.GirlDao;
import com.jp.girl.entity.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*@Controller
@ResponseBody*/
@RestController
public class GirlController {
    private  final static Logger logger= LoggerFactory.getLogger(GirlController.class);

    /*  @Autowired
      private GirlP girlP;

      //@RequestMapping(value = "/sya",method = RequestMethod.GET)
      @GetMapping(value = "/say")
      public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
          return "myId:"+myId;
      }*/
    @Autowired
    private GirlDao girlDao;
    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList (){
      logger.info("girlList查询所有女生方法加载了");
        return girlDao.findAll();
    }

    /**
     * 添加一个女生
     * @return@RequestParam("cupSize") String cupSize,
     @RequestParam("age") Integer age
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(1,msg);
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlDao.save(girl));
    }

    /**
     * 查询1个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl  findById(@PathVariable(value = "id") Integer id){
        Girl girl =  girlDao.findOne(id);
        return  girl;
    }

    //更新1个女生
    @PutMapping(value = "/girls/{id}")
    public Girl  girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return  girlDao.save(girl);
    }

    //删除
    @RequestMapping(value = "/girls/{id}",method = RequestMethod.DELETE)
    public  void girlDel(@PathVariable("id") Integer id){
        girlDao.delete(id);
    }

    /**
     * 通过罩杯查询
     * @param cupSize
     * @return
     */
    @GetMapping(value = "/girls/ByCupSize/{cupSize}")
    public  List<Girl> girlListByAge(@PathVariable(value = "cupSize") String cupSize){
        return  girlDao.findByCupSize(cupSize);

    }

    @PostMapping(value = "/girls/two")
    public  void  girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void  getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);
    }
}
