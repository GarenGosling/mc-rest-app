package org.garen.mc.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.Board;
import org.garen.mc.mybatis.domain.BoardExample;

public interface BoardMapper {
    long countByExample(BoardExample example);

    int deleteByExample(BoardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Board record);

    int insertSelective(Board record);

    List<Board> selectByExample(BoardExample example);

    Board selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByExample(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}