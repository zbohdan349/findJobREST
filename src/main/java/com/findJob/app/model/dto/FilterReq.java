package com.findJob.app.model.dto;

import com.findJob.app.model.Category;
import com.findJob.app.model.Level;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class FilterReq {

    @Nullable
    private List<Integer> categories;

    @Nullable
    private BigDecimal minSalary;

    @Nullable
    private List<Level> levels;

    @Nullable
    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(@Nullable List<Integer> categories) {
        this.categories = categories;
    }

    @Nullable
    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(@Nullable BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    @Nullable
    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(@Nullable List<Level> levels) {
        this.levels = levels;
    }


}
