package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.model.MaterialPage;
import org.apache.ibatis.annotations.Select;

/**
 * @author baogang
 */
public interface MaterialMapper extends BaseMapper<Material> {

    /**
     * 根据物料组和物料名称查询物料
     * @param materialPage
     * @return 分页的物料数组
     */
    @Select("<script>select m.id, m.create_time, m.material_name, m.material_description, m.material_code, m.material_group_code, m.one_time_flag " +
            "from material m " +
            "<where>" +
            "<if test=\"materialGroupCode != null\"> " +
            "and m.material_group_code = #{materialGroupCode} " +
            "</if> " +
            "<if test=\"materialName != null and materialName != ''\"> " +
            "<bind name=\"pattern\" value=\"'%' + materialName + '%'\" /> " +
            "and m.material_name like #{pattern} " +
            "</if> " +
            "</where>" +
            "</script>")
    MaterialPage<Material> findPagedMaterials(MaterialPage<Material> materialPage);


}
