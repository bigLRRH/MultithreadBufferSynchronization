package org.example.dao;
import org.example.entity.Result2;

import java.util.List;

public interface ResultMapper {
    List<Result2> findAll();//查找所有结果
    Result2 save(Result2 result2);//保存结果
}