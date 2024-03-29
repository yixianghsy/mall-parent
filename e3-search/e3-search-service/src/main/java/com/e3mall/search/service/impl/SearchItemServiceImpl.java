package com.e3mall.search.service.impl;

import com.e3mall.search.Utit.EsUtil;
import com.e3mall.search.mapper.EsEntity;
import com.e3mall.search.mapper.ItemVO;
import com.e3mall.search.service.SearchItemService;
import com.e3mall.pojo.SearchItem;
import com.e3mall.search.mapper.ItemMapper;
import com.e3mall.utils.E3Result;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
/**
 * 索引库维护Service
 * <p>Title: SearchItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p>
 * @version 1.0
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {
    @Autowired
    private EsUtil esUtil;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public E3Result importAllItems() {

        try {
            //查询商品列表
            List<SearchItem> itemList = itemMapper.getItemList();
            System.out.println(itemList.get(0).toString());
            List<EsEntity> list = new ArrayList<>();
            itemList.forEach(item -> list.add(
                    new EsEntity<>(item.getId().toString(),
                    new ItemVO(item.getId(),item.getTitle(),item.getSell_point(),String.valueOf(item.getPrice()) ,item.getImage(),item.getCategory_name()
                    ))));
            esUtil.insertBatch(EsUtil.INDEX_NAME, list);
            //返回导入成功
            return  E3Result.ok();
        } catch (Exception e) {
            return E3Result.build(500,"数据导入时发生异常");
        }
    }


}
