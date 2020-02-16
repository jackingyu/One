package com.elnido.modules.masterdata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elnido.modules.masterdata.entity.Material;
import com.elnido.modules.masterdata.entity.MaterialGroup;
import com.elnido.modules.masterdata.model.MaterialPage;
import com.elnido.modules.masterdata.vo.MaterialSearchVO;
import com.elnido.modules.masterdata.vo.MaterialVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
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
    @ResultMap("materialVOMap")
    @Select("<script>select m.id, m.material_name, m.material_description, m.material_code, mg.material_group_code, mg.material_group_name " +
            "from material m " +
            "left join material_group mg on m.material_group_code = mg.material_group_code " +
            "<where>" +
            "<if test=\"materialGroupCode != null\"> " +
            "and mg.material_group_code = #{materialGroupCode} " +
            "</if> " +
            "<if test=\"materialName != null and materialName != ''\"> " +
            "<bind name=\"pattern\" value=\"'%' + materialName + '%'\" /> " +
            "and m.material_name like #{pattern} " +
            "</if> " +
            "</where>" +
            "</script>")
    MaterialPage<MaterialVO> findPagedMaterials(MaterialPage<MaterialVO> materialPage);
}
