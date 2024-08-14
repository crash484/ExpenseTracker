package com.shashwat.ExpenseTracker.service.Stats;

import com.shashwat.ExpenseTracker.dto.GraphDTO;
import com.shashwat.ExpenseTracker.dto.StatsDto;

public interface StatsService {

    GraphDTO getChartData();

    StatsDto getStats();
}
