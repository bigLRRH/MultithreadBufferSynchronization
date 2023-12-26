package org.example.service;
import org.example.entity.Result;
import java.util.List;
public interface ResultService {
    List<Result> getAllResult();
    Result getResultById(Long id);
    Result createResult(Result result);
    Result updateResult(Long id, Result result);
    boolean deleteResult(Long id);
    List<Result> queryByResult(Result result);
    Result findByResultname(String resultname);
}
